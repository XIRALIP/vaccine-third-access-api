package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

@Getter
public enum AppoChannelEnum {

    APPLET(0, "小程序"),
    APP(1, "app代他人预约"),
    APP_SCAN(2, "app扫描");

    private Integer code;
    private String message;

    AppoChannelEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
