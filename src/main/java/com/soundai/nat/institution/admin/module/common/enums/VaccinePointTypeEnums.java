package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @Author: changjiarui
 * @description: 接种点类型
 */
@Getter
public enum VaccinePointTypeEnums {
    OPEN_VACCINATION(0, "公开预约接种点"),
    SPECIAL_VACCINATION(1, "特定团体接种点");

    private Integer code;
    private String name;

    VaccinePointTypeEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (VaccinePointTypeEnums c : VaccinePointTypeEnums.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
