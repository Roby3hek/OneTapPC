package com.onetap.pc.backend.dto;

public record LoginRequest(
        String username,
        String password
) {}