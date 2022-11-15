package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: QRTypeEnum
 * @author: zhaozhenyu
 * @date: 2020/11/18 18:02
 * @description: 二维码类型枚举
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum QRTypeEnum {

    Observation(1),
    Escape(2),
    ;

    private final Integer qrType;

}
