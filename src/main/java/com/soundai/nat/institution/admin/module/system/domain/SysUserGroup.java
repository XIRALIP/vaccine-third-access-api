package com.soundai.nat.institution.admin.module.system.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author liujiahe
 * @description:
 * @date 2020/9/3 17:43
 */
@Data
public class SysUserGroup {
    /**
     * 用户组ID
     */
    private String userGroupId;

    /**
     * 用户组ID
     */
    private String parentId;

    /**
     * 用户组名称
     */
    private String userGroupName;

    /**
     * 用户层级（1国,2省,3市,4区,5街道,6社区）
     */
    private Integer userGroupLevel;

    /**
     * 创建人名称
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人名称
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 1固定，2临时
     */
    private Integer groupType;

    /**
     * 社区负责人
     */
    private String areaContactor;

    /**
     * 负责人电话
     */
    private String contactorTelephone;

    /**
     * 社区地址
     */
    private String areaAddress;
}
