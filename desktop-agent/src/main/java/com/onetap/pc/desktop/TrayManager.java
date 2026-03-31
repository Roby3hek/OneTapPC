package com.onetap.pc.desktop;

import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.net.URI;

@Slf4j
public class TrayManager {

    private TrayIcon trayIcon;
    private AgentWebSocketClient webSocketClient;

    public void start() {
        if (!SystemTray.isSupported()) {
            log.error("System tray is not supported on this platform!");
            return;
        }

        try {
            Image image = Toolkit.getDefaultToolkit().createImage("");
            trayIcon = new TrayIcon(image, "OneTap PC Agent");
            trayIcon.setImageAutoSize(true);

            PopupMenu popup = createPopupMenu();
            trayIcon.setPopupMenu(popup);

            SystemTray.getSystemTray().add(trayIcon);

            webSocketClient = new AgentWebSocketClient("ws://localhost:8080/ws", this);
            webSocketClient.connect();

            trayIcon.displayMessage("OneTap PC", "Desktop Agent запущен", TrayIcon.MessageType.INFO);

        } catch (Exception e) {
            log.error("Failed to initialize tray", e);
        }
    }

    private PopupMenu createPopupMenu() {
        PopupMenu popup = new PopupMenu();

        MenuItem statusItem = new MenuItem("Статус: Подключение...");
        statusItem.setEnabled(false);

        MenuItem openWebItem = new MenuItem("Открыть веб-интерфейс");
        openWebItem.addActionListener(e -> openWebInterface());

        MenuItem exitItem = new MenuItem("Выход");
        exitItem.addActionListener(e -> System.exit(0));

        popup.add(statusItem);
        popup.addSeparator();
        popup.add(openWebItem);
        popup.add(exitItem);

        return popup;
    }

    private void openWebInterface() {
        try {
            Desktop.getDesktop().browse(new URI("http://localhost:8080"));
        } catch (Exception e) {
            log.error("Cannot open web interface", e);
        }
    }

    public void updateStatus(String status) {
        log.info("Agent status: {}", status);
    }
}