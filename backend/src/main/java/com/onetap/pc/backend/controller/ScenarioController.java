package com.onetap.pc.backend.controller;

import com.onetap.pc.backend.websocket.ScenarioWebSocketHandler;
import com.onetap.pc.model.Scenario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/scenarios")
@RequiredArgsConstructor
public class ScenarioController {

    private final ScenarioWebSocketHandler webSocketHandler;

    @GetMapping
    public ResponseEntity<List<Scenario>> getAllScenarios() {
        // Заглушка для теста
        return ResponseEntity.ok(List.of());
    }

    @PostMapping("/execute/{scenarioId}")
    public ResponseEntity<?> executeScenario(@PathVariable UUID scenarioId) {
        // Отправляем сообщение через WebSocket
        webSocketHandler.sendExecutionStatus(
            "test-device", 
            "Command received: Execute scenario ID = " + scenarioId
        );

        return ResponseEntity.ok(Map.of(
            "status", "success",
            "message", "Execution command sent to Desktop Agent via WebSocket",
            "scenarioId", scenarioId.toString()
        ));
    }
}