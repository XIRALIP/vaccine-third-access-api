package com.soundai.nat.institution.admin.module.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.soundai.nat.institution.admin.framework.web.domain.SysBaseEntity;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户对象 sys_user
 *
 * @author soundai
 */
@Data
public class SysUser extends SysBaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private String userId;



    /**
     * 用户类型
     */
    private String userType;



    /**
     * 用户账号
     */
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    private String userName;

    /**
     * 用户昵称
     */
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    private String nickName;
    /**
     * 密码
     */
    @JsonIgnore
    @JsonProperty
    private String password;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    private String dbPermissions;

    public boolean isAdmin() {
        return isAdmin(this.userId);
    }

    public static boolean isAdmin(String userId) {
        return StringUtils.equals("3", userId);
    }

    public SysUser(String userId) {
        this.userId = userId;
    }

    public SysUser() {

    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("userType", getUserType())
                .append("userName", getUserName())
                .append("nickName", getNickName())
                .append("password", getPassword())
                .append("dbPermissions",getDbPermissions())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .toString();
    }
}
