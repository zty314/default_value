package com.diligent.gogogo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @version: v1.0
 * @author: zhangty
 * @date: 2022/8/18 10:55
 */
@Target(ElementType.PARAMETER)
@Retention(RUNTIME)
@Documented
public @interface GGBody {
}