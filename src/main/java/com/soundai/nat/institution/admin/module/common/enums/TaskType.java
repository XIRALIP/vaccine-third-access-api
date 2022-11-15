package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskType {
    INSTITUTIONR(0,"机构"),
    GOV(1,"政府"),
    VACCINE_INSTITUTION(3, "疫苗");

    private Integer type;
    private String name;
}
