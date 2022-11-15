package com.soundai.nat.institution.admin.module.system.domain;

import lombok.Data;

import java.util.List;

/**
 * @author liujiahe
 * @description:
 * @date 2020/9/3 17:43
 */
@Data
public class GroupResponse {
    /**
     * 用户层级（1国,2省,3市,4区,5街道,6社区）
     */
    private Integer userGroupLevel;

    private List<AreaResponse> items;
}
