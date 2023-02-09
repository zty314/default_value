package com.diligent.gogogo.event.listener;

public class TestEvent {
    private String name;
    public TestEvent(Object source, String name) {
//        super(source);
        this.name = name;
    }
//    public TestEvent(Object source) {
//        super(source);
//    }
    @Override
    public String toString() {
        return "TestEvent{name='" + name + '\'' + '}';
    }
}
