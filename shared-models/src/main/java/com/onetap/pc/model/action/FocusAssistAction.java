package com.onetap.pc.model.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class FocusAssistAction extends Action {
    private String mode;                 // "off", "priority", "alarmsOnly"
}