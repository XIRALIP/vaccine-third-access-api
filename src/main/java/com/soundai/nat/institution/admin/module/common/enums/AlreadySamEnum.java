package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 是否已采样
 */
@Getter
@AllArgsConstructor
public enum AlreadySamEnum {
    YSE("yes", "是"),
    NO("no", "否");

    private final String code;

    private final String msg;

    public static String getMsgByCode(String code) {

        for (AlreadySamEnum alreadySamEnum : values()) {

            if (alreadySamEnum.getCode().equals(code)) {
                return alreadySamEnum.getMsg();
            }

        }
        return "未知错误: " + code;
    }

}
