package com.mooc.zbs.web.mvc;

import java.lang.annotation.*;

/**
 * 接口方法注解，需要指定Url
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping {
    /**
     * Url
     */
    String value();
}