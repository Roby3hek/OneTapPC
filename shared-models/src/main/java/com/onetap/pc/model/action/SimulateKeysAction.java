package com.onetap.pc.model.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SimulateKeysAction extends Action {
    private List<String> keys;           // например: ["Ctrl", "Shift", "T"] или ["Win", "D"]
    private String keyCombination;       // "Ctrl+Shift+T" — альтернативный формат
    private int delayMs = 100;           // задержка между нажатиями
}