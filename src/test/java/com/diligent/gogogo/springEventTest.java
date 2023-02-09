package com.diligent.gogogo;

import com.diligent.gogogo.event.listener.EventConfig;
import com.diligent.gogogo.event.listener.TestEvent;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class springEventTest {
    @Test
    public void test_listener() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        System.out.println("发布事件");
        TestEvent event = new TestEvent(new Object(), "事件1");
        context.publishEvent(event);
        System.out.println("完事");
        context.close();
    }
}
