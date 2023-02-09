package com.diligent.gogogo.annotation;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TestAnnotation(msg = "类上的注解msg")
public class Test {

    @TestAnnotation("value")
    private String msgClass;

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        //获取类上的注解
        TestAnnotation annotation = Test.class.getAnnotation(TestAnnotation.class);
        if (annotation != null) {
            System.out.println("value的值为" + annotation.value());
            System.out.println("msg的值为" + annotation.msg());
        }
        //获取方法上的注解
        Method method = Test.class.getMethod("testMsg");
        TestAnnotation annotation1 = method.getAnnotation(TestAnnotation.class);
        if (annotation1 != null) {
            System.out.println("-----------------");
            System.out.println("value的值为" + annotation1.value());
            System.out.println("msg的值为" + annotation1.msg());
        }
        //获取属性上的注解
        Field a = Test.class.getDeclaredField("msgClass");
        TestAnnotation annotation2 = a.getAnnotation(TestAnnotation.class);
        if (annotation1 != null) {
            System.out.println("-----------------");
            System.out.println("value的值为" + annotation2.value());
            System.out.println("msg的值为" + annotation2.msg());
        }
    }

    @TestAnnotation(value = "方法上的注解value" ,msg = "方法上的注解msg")
    public void testMsg() {
    }
}


