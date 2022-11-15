package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {
    A(0,"已创建"),
    B(1,"运行中"),
    C(2,"运行成功"),
    D(3,"运行失败");

    private Integer code;
    private String name;
}
