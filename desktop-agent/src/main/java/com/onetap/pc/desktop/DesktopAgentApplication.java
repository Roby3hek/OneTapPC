package com.onetap.pc.desktop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DesktopAgentApplication {

    public static void main(String[] args) {
        log.info("Starting OneTap PC Desktop Agent...");

        TrayManager trayManager = new TrayManager();
        trayManager.start();

        // Держим приложение запущенным
        synchronized (DesktopAgentApplication.class) {
            try {
                DesktopAgentApplication.class.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}