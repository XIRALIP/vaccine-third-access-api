package com.soundai.nat.institution.admin.module.common.annotation;

import org.springframework.data.annotation.Persistent;

import java.lang.annotation.*;

/**
 * @title: NotNullArg
 * @author: Jefferson Li
 * @date: 2020/11/20 22:08
 * @description: 非空参数注解
 * @version: 1.0
 */
@Persistent
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface NotNullArg {
}
