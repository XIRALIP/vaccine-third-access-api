package com.soundai.nat.institution.admin.module.system.service;

import com.soundai.nat.institution.admin.module.system.domain.SysUser;

/**
 * 用户 业务层
 *
 * @author soundai
 */
public interface ISysUserService
{

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);


}
