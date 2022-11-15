package com.soundai.nat.institution.admin.framework.web.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * 业务Mongo Entity基类
 *
 * @author soundai
 */
@Data
public class BaseEntity implements Serializable {
    public static final String CREATE_USER_NAME = "create_user_name";
    public static final String CREATE_TIME = "create_time";
    public static final String UPDATE_USER_NAME = "update_user_name";
    public static final String UPDATE_TIME = "modify_time";
    private static final long serialVersionUID = 1L;
    /**
     * 创建者
     */
    @Field(CREATE_USER_NAME)
    private String createUserName;

    /**
     * 创建时间
     */
    @Field(CREATE_TIME)
    private String createTime;

    /**
     * 更新者
     */
    @Field(UPDATE_USER_NAME)
    private String updateUserName;

    /**
     * 更新时间
     */
    @Field(UPDATE_TIME)
    private String updateTime;

}
