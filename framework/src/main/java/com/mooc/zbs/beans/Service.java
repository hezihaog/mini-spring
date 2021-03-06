package com.mooc.zbs.beans;

import java.lang.annotation.*;

/**
 * Service注解，标识这个类是Service层的对象
 */
@Documented
//作用于类上
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Service {
}