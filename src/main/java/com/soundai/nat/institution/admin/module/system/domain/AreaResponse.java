package com.soundai.nat.institution.admin.module.system.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author lumengyi
 * @description: 社区信息参数
 * @date 2020/11/24 21:37
 */
@Data
@Builder
public class AreaResponse {
    private String areaName;
    private String areaCode;
}
