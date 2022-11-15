package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

@Getter
public enum CallStatusEnum {

    IN_CALL("IN_CALL","呼叫中"),
    CALL_SUCCESS("CALL_SUCCESS","有效接通"),
    CALL_FAILURE("CALL_FAIL","无效接通");

    private final String code;
    private final String message;

    CallStatusEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
}
