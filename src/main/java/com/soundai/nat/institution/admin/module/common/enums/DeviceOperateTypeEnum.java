package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

@Getter
public enum DeviceOperateTypeEnum {

    NO_OPERATE(0,"无操作"),
    LOG_UPLOAD(1,"日志上传")
    ;

    private Integer code;
    private String message;

    DeviceOperateTypeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
