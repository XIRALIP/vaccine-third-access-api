package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName AgeRangeEnum.java
 * @Description AgeRangeEnum
 * @createTime 2020年12月20日 17:49:00
 */
@Getter
@AllArgsConstructor
public enum AgeRangeEnum {
    /**
     * 18岁以下
     */
    TEEN(0, "18岁以下"),

    /**
     * 18岁-60岁
     */
    YOUTH(1, "18岁-60岁"),

    /**
     * 60岁以上
     */
    OLD(2, "60岁以上");

    private final Integer code;

    /**
     * 年龄范围
     */
    private final String range;


    public static String getRange(int age) {
        if (age >= 0 && age < 18) {
            return TEEN.range;
        } else if (age >= 18 && age < 60) {
            return YOUTH.range;
        } else if (age >= 60) {
            return OLD.range;
        } else {
            return "";
        }
    }
}
