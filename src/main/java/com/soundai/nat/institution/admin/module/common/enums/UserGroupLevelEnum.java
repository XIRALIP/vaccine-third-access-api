package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName UserGroupLevelEnum.java
 * @Description 用户组级别枚举
 * @createTime 2020年12月20日 17:49:00
 */
@Getter
@AllArgsConstructor
public enum UserGroupLevelEnum {
    COUNTRY(1, "国家"),
    PROVINCE(2, "省"),
    CITY(3, "市"),
    AREA(4, "区"),
    SUBDISTRICT(5, "街道"),
    COMMUNITY(6, "社区");

    private final Integer code;

    /**
     * 年龄范围
     */
    private final String range;

    public static UserGroupLevelEnum getEnum(Integer code) {
        if (Objects.isNull(code)) {
            return COUNTRY;
        }
        for (UserGroupLevelEnum e : UserGroupLevelEnum.values()) {
            if (code.equals(e.getCode())) {
                return e;
            }
        }
        return COUNTRY;
    }
}
