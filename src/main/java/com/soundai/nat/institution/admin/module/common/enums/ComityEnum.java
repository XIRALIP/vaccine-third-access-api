package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName ComityEnum.java
 * @Description TODO
 * @createTime 2020年12月10日 20:09:00
 */
@Getter
public enum ComityEnum {

    NTA("暂无检测机构"),
    NTFITAOR("暂未填写居住地区"),
    NTFITRA("暂未填写居住地址");

    private final String name;

    ComityEnum(String name) {
        this.name = name;
    }

}
