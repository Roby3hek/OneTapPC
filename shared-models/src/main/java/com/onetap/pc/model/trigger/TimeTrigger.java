package com.onetap.pc.model.trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class TimeTrigger extends Trigger {
    private LocalTime time;
    private List<Integer> daysOfWeek;   // 1 = понедельник, 7 = воскресенье
    private boolean repeatDaily = false;
}