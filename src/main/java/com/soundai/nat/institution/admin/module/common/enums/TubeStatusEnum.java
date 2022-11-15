package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 试管状态表
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum TubeStatusEnum {
    SAMPLED(1, "已采样"),
    STORED(2, "已入库"),
    CHECKED(4, "待审核"),
    CHECKING(3, "检测中"),
    REVIEWED(5, "已完成"),
    REJECTED(6, "已驳回");

    private Integer code;
    private String name;

    TubeStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(int code) {
        for (TubeStatusEnum c : TubeStatusEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }
}
