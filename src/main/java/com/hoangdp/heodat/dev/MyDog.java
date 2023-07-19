package com.hoangdp.heodat.dev;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MyDog {
    @EventListener
    @Async
    public void doorBellEventListener(DoorBellEvent doorBellEvent) throws InterruptedException {
        Thread.sleep(2000);

        System.out.println(Thread.currentThread().getName() + ": Chó ngủ dậy!!");
        System.out.println(Thread.currentThread().getName() + ": Go go go!! Có người gõ cửa");
    }
}
