package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskScope {
    SAMPLE_POINT(0,"采样点"),
    SAMP_UNIT(1,"应急采样组织");

    private Integer type;
    private String name;
}
