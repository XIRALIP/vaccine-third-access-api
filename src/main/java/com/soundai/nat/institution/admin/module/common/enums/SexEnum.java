package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: SexEnum
 * @author: Jefferson Li
 * @date: 2020/11/18 18:02
 * @description: 性别枚举
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum SexEnum {

    FEMALE(0, "女"),
    MALE(1, "男"),
    ;

    private Integer sexCode;
    private String sexName;

    public String getNameByCode(Integer sexCode) {
        for (SexEnum sexEnum : values()) {
            if (sexEnum.getSexCode().equals(sexCode))
                return sexEnum.getSexName();
        }
        return "未知类型：" + sexCode;
    }

    public static Integer getCodeByName(String sexName) {
        for (SexEnum sexEnum : values()) {
            if (sexEnum.getSexName().equals(sexName))
                return sexEnum.getSexCode();
        }

        return -1;
    }

}
