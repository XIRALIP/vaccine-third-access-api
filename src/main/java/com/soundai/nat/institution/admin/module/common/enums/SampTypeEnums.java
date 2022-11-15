package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @Author: changjiarui
 * @description: 检测类型
 */
@Getter
public enum SampTypeEnums {
    NORMAL(1, "日常"),
    EMERGENCY(2, "应急"),
    OUTSOURCE(3, "外采");

    private Integer code;
    private String name;

    SampTypeEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (SampTypeEnums c : SampTypeEnums.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
