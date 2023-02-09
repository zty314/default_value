package com.diligent.gogogo.event.listener;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import java.util.concurrent.TimeUnit;

@Configuration
public class EventConfig {
    @EventListener
    public void listen(TestEvent event) throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        System.out.println("接收到事件：" + event);

    }
}
