package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName SortEnum.java
 * @Description TODO
 * @createTime 2020年12月20日 17:49:00
 */
@Getter
public enum  SortEnum {
    /**
     * 倒序
     */
    DESC("desc"),
    /**
     * 正序
     */
    ASC("asc");

    /**
     * 排序名称
     */
    private final String name;

    SortEnum(String name) {
        this.name = name;
    }

}
