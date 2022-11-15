package com.soundai.nat.institution.admin.module.common.enums;

import com.soundai.nat.institution.admin.framework.utils.StringUtils;
import lombok.Getter;

/**
 * @Author: liujiahe
 * @Description: 机构类型枚举
 */
@Getter
public enum InstTypeEnum {

    INSTITUTION("INSTITUTION", "机构"),
    SAMP_UNIT("SAMP_UNIT", "采样单位");

    private String code;
    private String name;

    InstTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String code) {
        for (InstTypeEnum c : InstTypeEnum.values()) {
            if (c.getCode() == code) {
                return c.name;
            }
        }
        return null;
    }

    public static InstTypeEnum findEnumByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (InstTypeEnum dataEnum : InstTypeEnum.values()) {
            if (dataEnum.getCode().equals(code)) {
                return dataEnum;
            }
        }
        return null;
    }

}
