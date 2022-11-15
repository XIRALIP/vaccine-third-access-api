package com.soundai.nat.institution.admin.module.system.mapper;

import com.soundai.nat.institution.admin.module.system.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户表 数据层
 *
 * @author soundai
 */
@Mapper
public interface SysUserMapper
{
    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByUserName(String userName);

}
