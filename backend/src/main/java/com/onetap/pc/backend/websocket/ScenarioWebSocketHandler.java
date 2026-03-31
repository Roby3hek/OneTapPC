package com.onetap.pc.backend.websocket;

import com.onetap.pc.model.Scenario;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ScenarioWebSocketHandler {

    private final SimpMessagingTemplate messagingTemplate;
    private final ObjectMapper objectMapper;

    /**
     * Получает запрос на выполнение сценария от клиента (например, из веб или Desktop Agent)
     */
    @MessageMapping("/execute")
    @SendTo("/topic/execution")
    public String executeScenario(String scenarioJson, Principal principal) {
        try {
            Scenario scenario = objectMapper.readValue(scenarioJson, Scenario.class);
            String username = principal != null ? principal.getName() : "unknown";

            log.info("Received execute request for scenario '{}' from user: {}", scenario.getName(), username);

            return "Scenario '" + scenario.getName() + "' received and queued for execution on PC";

        } catch (Exception e) {
            log.error("Error processing scenario execution", e);
            return "Error processing scenario: " + e.getMessage();
        }
    }

    /**
     * Метод для отправки статуса выполнения обратно (будет использоваться из других сервисов)
     */
    public void sendExecutionStatus(String deviceId, String message) {
        messagingTemplate.convertAndSend("/topic/execution/" + deviceId, message);
    }
}