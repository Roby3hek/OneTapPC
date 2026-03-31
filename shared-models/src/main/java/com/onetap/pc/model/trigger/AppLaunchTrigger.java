package com.onetap.pc.model.trigger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class AppLaunchTrigger extends Trigger {
    private String appName;           // имя exe или процесса
    private boolean onLaunch = true;  // true = при запуске, false = при закрытии
}