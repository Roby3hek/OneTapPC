package com.onetap.pc.model.trigger;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TimeTrigger.class, name = "TIME"),
    @JsonSubTypes.Type(value = AppLaunchTrigger.class, name = "APP_LAUNCH")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Trigger {
    private TriggerType type;
    private boolean enabled = true;
}