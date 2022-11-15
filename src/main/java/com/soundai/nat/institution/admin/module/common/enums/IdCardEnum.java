package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName ComityEnum.java
 * @Description 证件类型
 * @createTime 2020年12月27日 16:07:00
 */
@Getter
public enum IdCardEnum {

    ID_CARD("身份证"),
    PASSPORT("护照"),
    OFFICER_ID("军官证"),
    HONG_KONG_MACAU_AND_TAIWAN_PASS("港澳台通行证");

    private final String name;

    IdCardEnum(String name) {
        this.name = name;
    }

}
