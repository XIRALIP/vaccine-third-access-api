package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleKeyEnum {
    COMMON("COMMON","公开的角色"),
    PRIVATE("PRIVATE","私有的角色"),
    ADMIN("ADMIN","系统超级管理员角色"),
    WEB_ADMIN_INSTITUTION("WEB_ADMIN_INSTITUTION","后台机构管理员角色"),
    WEB_ADMIN_SAMP_UNIT("WEB_ADMIN_SAMP_UNIT","后台采样单位管理员角色"),
    ;

    private String roleKeyName;
    private String roleKeyValue;

}
