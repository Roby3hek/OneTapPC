package com.onetap.pc.model.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SetVolumeAction extends Action {
    private int volumeLevel;        // 0 - 100
    private String target;          // "master", "media", "system", "notifications"
    private boolean mute = false;
}