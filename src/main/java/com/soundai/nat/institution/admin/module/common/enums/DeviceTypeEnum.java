package com.soundai.nat.institution.admin.module.common.enums;

import lombok.Getter;

/**
 * @Author: wangyu
 * @Date: Created 2020-11-16 15:30
 * @Description:
 * @Modified By:
 */
@Getter
public enum DeviceTypeEnum {

    HAND_SCAN_DEVICE(0, "手持便捷扫码"),
    SMART_SCAN_DEVICE(1, "智能取码"),
    DESKTOP_SCAN_DEVICE(2, "台式扫码"),
    APP_SCAN_DEVICE(3,"译码APP"),
    VACCINE_BIND_DEVICE(4, "疫苗信息关联终端");

    private Integer code;

    private String name;


    DeviceTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

}
