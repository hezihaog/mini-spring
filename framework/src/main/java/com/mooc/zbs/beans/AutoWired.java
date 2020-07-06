package com.mooc.zbs.beans;

import java.lang.annotation.*;

/**
 * 依赖注入注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
//作用于类属性上
@Target(ElementType.FIELD)
public @interface AutoWired {
}