package com.onetap.pc.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = LaunchAppAction.class, name = "LAUNCH_APP"),
    @JsonSubTypes.Type(value = OpenUrlsAction.class, name = "OPEN_URLS"),
    @JsonSubTypes.Type(value = SetVolumeAction.class, name = "SET_VOLUME"),
    @JsonSubTypes.Type(value = SimulateKeysAction.class, name = "SIMULATE_KEYS"),
    @JsonSubTypes.Type(value = SleepAction.class, name = "SLEEP_PC"),
    @JsonSubTypes.Type(value = WakeOnLanAction.class, name = "WAKE_ON_LAN"),
    @JsonSubTypes.Type(value = FocusAssistAction.class, name = "FOCUS_ASSIST")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Action {
    private ActionType type;
    private int order;
    private boolean enabled = true;
}