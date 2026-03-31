package com.onetap.pc.model.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class LaunchAppAction extends Action {
    private String appName;           // например: "chrome", "code", "discord"
    private String executablePath;    // полный путь (опционально)
    private String arguments;         // аргументы запуска
    private boolean waitForExit = false;
}