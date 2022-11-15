package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleTypeEnum {
    ENDPOINT_TEST("ENDPOINT_TEST","检测人员"),
    ENDPOINT_STORAGE("ENDPOINT_STORAGE","入库人员"),
    ENDPOINT_SAMPLE("ENDPOINT_SAMPLE","采样人员"),
    ENDPOINT_AUDIT("ENDPOINT_AUDIT","审核人员"),
    ENDPOINT_ENTRY("ENDPOINT_ENTRY","扫码人员"),
    VACCINE("VACCINE","疫苗管理员"),
    ENDPOINT_VACCINATE_REGISTRY("ENDPOINT_VACCINATE_REGISTRY","疫苗试剂关联人员");

    private String type;
    private String value;
}
