package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: StatusEnum
 * @author: Jefferson Li
 * @date: 2020/11/16 21:21
 * @description:
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum WeekEnum {
    MON("1", "周一"),
    TUE("2", "周二"),
    WED("3", "周三"),
    THU("4", "周四"),
    FRI("5", "周五"),
    SAT("6", "周六"),
    SUN("7", "周日"),
    ;

    private final String code;
    private final String week;

    public static String getWeekByCode(String code) {

        for (WeekEnum weekEnum : values()) {

            if (weekEnum.getCode().equals(code)) {
                return weekEnum.getWeek();
            }

        }
        return "未知错误: " + code;
    }

}
