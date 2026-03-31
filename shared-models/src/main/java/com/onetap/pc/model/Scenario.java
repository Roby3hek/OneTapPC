package com.onetap.pc.model;

import com.onetap.pc.model.action.Action;
import com.onetap.pc.model.trigger.Trigger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Scenario {
    private UUID id = UUID.randomUUID();
    private UUID userId;
    private String name;
    private String icon;           // emoji или название Material Icon
    private String description;
    private String color;          // hex для карточки

    private List<Trigger> triggers = new ArrayList<>();
    private List<Action> actions = new ArrayList<>();

    private boolean enabled = true;
    private boolean isPublic = false;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public void addAction(Action action) {
        action.setOrder(actions.size());
        actions.add(action);
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
    }
}