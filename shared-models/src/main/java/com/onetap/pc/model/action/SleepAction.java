package com.onetap.pc.model.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class SleepAction extends Action {
    private boolean hibernate = false;   // true = гибернация, false = спящий режим
    private int delaySeconds = 0;        // задержка перед выполнением
}