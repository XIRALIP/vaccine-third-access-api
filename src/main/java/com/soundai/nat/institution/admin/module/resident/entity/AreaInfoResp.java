package com.soundai.nat.institution.admin.module.resident.entity;

import lombok.Data;

/**
 * @author lumengyi
 * @description: 社区信息参数
 * @date 2020/11/24 21:37
 */
@Data
public class AreaInfoResp extends AreaInfoVO {
    private Long communityResidentCount;
    private Long callCount;
    private Long messageCount;
}
