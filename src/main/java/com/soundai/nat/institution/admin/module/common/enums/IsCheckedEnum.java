package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * @author IsCheckedEnum
 * @version 1.0.0
 * @ClassName IsCheckedEnum.java
 * @Description 校验结果类型
 * @createTime 2020年12月27日 16:07:00
 */
@Getter
@AllArgsConstructor
public enum IsCheckedEnum {

    SAME(0, "校验正确"),
    DIFF(1, "与健康报不符");

    private final Integer code;
    private final String name;

    public static String getName(Integer code) {
        if (Objects.isNull(code)) {
            return "";
        }
        for (IsCheckedEnum e : values()) {
            if (e.getCode().equals(code)) {
                return e.getName();
            }
        }
        return "";
    }
}
