package com.hoangdp.heodat.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyHouse {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void rangDoorbellBy(String name){
        applicationEventPublisher.publishEvent(new DoorBellEvent(name));
    }
    
}