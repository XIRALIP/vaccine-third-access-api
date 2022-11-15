package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

@Getter
public enum DeviceStatusEnum {

    SOFT_DELETE(2,"软删除");

    private Integer code;
    private String message;

    DeviceStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }

}
