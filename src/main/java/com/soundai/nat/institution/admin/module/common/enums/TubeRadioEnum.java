package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

@Getter
public enum TubeRadioEnum {

    RADIO_OTHER(0,"其他"),
    RADIO_ONE(1,"1:1"),
    RADIO_FIVE(5,"1:5"),
    RADIO_TEN(10,"1:10"),
    ;

    private final Integer code;
    private final String name;

    TubeRadioEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }
}
