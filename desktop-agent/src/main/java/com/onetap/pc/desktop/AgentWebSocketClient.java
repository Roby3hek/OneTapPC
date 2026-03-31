package com.onetap.pc.desktop;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@Slf4j
public class AgentWebSocketClient extends WebSocketClient {

    private final TrayManager trayManager;

    public AgentWebSocketClient(String serverUri, TrayManager trayManager) {
        super(URI.create(serverUri));
        this.trayManager = trayManager;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log.info("WebSocket connected to backend");
        trayManager.updateStatus("Подключено");
    }

    @Override
    public void onMessage(String message) {
        log.info("Received from server: {}", message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log.warn("WebSocket closed: {}", reason);
    }

    @Override
    public void onError(Exception ex) {
        log.error("WebSocket error", ex);
    }
}