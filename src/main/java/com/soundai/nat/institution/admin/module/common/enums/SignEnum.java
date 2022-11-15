package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @Author: changjiarui
 * @description: 异常标记（0非异常，1异常）
 */
@Getter
public enum SignEnum {
    NOT_ABNORMAL(0, "非异常"),
    ABNORMAL(1, "异常");

    private Integer code;
    private String name;

    SignEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (SignEnum c : SignEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
