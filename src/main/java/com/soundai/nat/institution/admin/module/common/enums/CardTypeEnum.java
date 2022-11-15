package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

@Getter
public enum CardTypeEnum {
    SHENFENZHENG("01", "居民身份证","身份证"),
    HUKOUBEN("02", "居民户口簿","户口本"),
    HUZHAO("03", "护照","护照"),
    JUNGUANZHENG("04", "军官证", "军官证"),
    JIASHIZHENG("05", "驾驶证", "驾驶证"),
    GANGAO("06", "港澳居民来往内地通行证", "港澳居民来往内地通行证"),
    TAIWAN("07", "台湾居民来往内地通行证", "台湾居民来往内地通行证"),
    CHISHENGZHENG("08", "出生医学证明", "出生医学证明"),
    ;

    private String code;
    private String name;
    private String dbname;

    CardTypeEnum(String code, String name,String dbname) {
        this.code = code;
        this.name = name;
        this.dbname = dbname;
    }

    public static String getName(String code) {
        for (CardTypeEnum c : CardTypeEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.dbname;
            }
        }
        return null;
    }

}
