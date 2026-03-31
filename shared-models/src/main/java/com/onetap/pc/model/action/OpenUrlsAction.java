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
public class OpenUrlsAction extends Action {
    private List<String> urls;
    private String browser;           // "chrome", "edge", "default"
    private boolean newWindow = false;
}