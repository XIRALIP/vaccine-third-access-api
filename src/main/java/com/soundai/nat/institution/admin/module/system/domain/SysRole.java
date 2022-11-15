package com.soundai.nat.institution.admin.module.system.domain;

import com.soundai.nat.institution.admin.framework.web.domain.SysBaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 角色表 sys_role
 *
 * @author soundai
 */
@Data
public class SysRole extends SysBaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
    private String roleName;

    /**
     * 角色类型（权限KEY）
     */
    private String roleType;

    /**
     * 角色所属组织id
     */
    private String institutionId;

    /**
     * 角色描述
     */
    private String desc;

    /** 菜单组 */
    private Long[] menuIds;

    /**
     * 角色Key
     */
    private String roleKey;

    public boolean isAdmin() {
        return isAdmin(this.roleId);
    }

    public static boolean isAdmin(Long roleId) {
        return roleId != null && 1L == roleId;
    }

    public SysRole(Long roleId)
    {
        this.roleId = roleId;
    }

    public SysRole()
    {

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("roleId", getRoleId())
                .append("roleName", getRoleName())
                .append("institutionId", getInstitutionId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
