package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName UserTypeEnum
 * @Description 用户类型，区分是政府端用户还是机构端用户
 * @Author biantongtong
 * @Date 2020/12/10 下午5:19
 * @Version 1.0
 **/
@Getter
@AllArgsConstructor
public enum  UserTypeEnum {
    LANGCHAO("LANGCHAO","浪潮"),
    VACCINE("VACCINE","疫苗用户");

    private String type;
    private String name;
}
