package com.onetap.pc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    private UUID id;
    private UUID userId;
    private String name;
    private String hostname;
    private String osInfo;
    private String lastIpAddress;
    private boolean online = false;
    private LocalDateTime lastSeen;
    private LocalDateTime registeredAt;
}