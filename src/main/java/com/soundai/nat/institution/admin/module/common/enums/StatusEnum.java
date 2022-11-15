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
public enum StatusEnum {
    ENABLE(0, "启用"),
    DISABLE(1, "禁用"),
    HIDE(2, "隐藏");


    private final Integer status;
    private final String msg;

    public static String getMsgByCode(Integer status) {

        for (StatusEnum statusEnum : values()) {

            if (statusEnum.getStatus().equals(status)) {
                return statusEnum.getMsg();
            }

        }
        return "未知错误: " + status;
    }

}
