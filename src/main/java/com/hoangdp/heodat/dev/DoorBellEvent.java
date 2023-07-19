package com.hoangdp.heodat.dev;

import org.springframework.context.ApplicationEvent;

public class DoorBellEvent extends ApplicationEvent {

    public DoorBellEvent(Object source) {
        super(source);
    }
}
