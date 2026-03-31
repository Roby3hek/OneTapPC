package com.onetap.pc.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "✅ OneTap PC Backend is running successfully!<br><br>" +
               "WebSocket endpoint: ws://localhost:8080/ws<br>" +
               "Auth endpoints: /api/auth/login и /api/auth/register";
    }

    @GetMapping("/api/health")
    public String health() {
        return "OK";
    }
}