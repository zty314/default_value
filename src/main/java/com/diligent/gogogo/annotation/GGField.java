package com.diligent.gogogo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author GGG
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface GGField {

    String value();

    Class<?> type();

}
