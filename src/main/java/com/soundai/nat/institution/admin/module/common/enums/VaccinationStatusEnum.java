package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 接种状态枚举
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum VaccinationStatusEnum {
    AUDIT(1, "接种申请审核中"),
    FAILED(2, "接种申请未通过"),
    APPLIED(3, "已申请未接种"),
    FIRST(4, "完成第一次接种"),
    SECOND(5, "完成第二次接种"),
    OTHER(6, "其它");

    private Integer code;
    private String name;

    VaccinationStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(Integer code) {
        for (VaccinationStatusEnum c : VaccinationStatusEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.name;
            }
        }
        return null;
    }
}
