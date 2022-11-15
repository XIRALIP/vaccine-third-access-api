package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @Author: changjiarui
 * @description: 采样点是否可见, 0：可见；1：不可见，虚拟采样点不可见，创建团体预约时生成的采样点
 */
@Getter
public enum SampEnums {
    VISIABLE(0, "可见"),
    NO_VISIABLE(1, "不可见");

    private Integer code;
    private String name;

    SampEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (SampEnums c : SampEnums.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
