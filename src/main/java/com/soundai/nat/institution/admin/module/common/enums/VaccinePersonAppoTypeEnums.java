package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @Author: changjiarui
 * @description: 团体接种点人员是否预约
 */
@Getter
public enum VaccinePersonAppoTypeEnums {
    NO(0, "否"),
    YES(1, "是");

    private Integer code;
    private String name;

    VaccinePersonAppoTypeEnums(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (VaccinePersonAppoTypeEnums c : VaccinePersonAppoTypeEnums.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

}
