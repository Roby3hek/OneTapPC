package com.onetap.pc.backend.dto;

public record RegisterRequest(
        String username,
        String password,
        String fullName
) {}