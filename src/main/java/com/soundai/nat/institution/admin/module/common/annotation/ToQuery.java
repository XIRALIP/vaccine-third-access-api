package com.soundai.nat.institution.admin.module.common.annotation;

import org.springframework.data.annotation.Persistent;

import java.lang.annotation.*;

/**
 * @title: ToQuery
 * @author: Jefferson Li
 * @date: 2020/11/24 17:45
 * @description: 查询条件判断
 * @version: 1.0
 */
@Persistent
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToQuery {

    String value() default "";
}
