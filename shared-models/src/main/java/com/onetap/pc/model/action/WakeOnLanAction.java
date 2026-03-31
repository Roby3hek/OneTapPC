package com.onetap.pc.model.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class WakeOnLanAction extends Action {
    private String macAddress;
    private String broadcastIp;       // обычно 192.168.1.255 или 255.255.255.255
}