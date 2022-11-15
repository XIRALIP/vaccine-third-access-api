package com.soundai.nat.institution.admin.module.system.service.impl;

import com.soundai.nat.institution.admin.framework.constant.UserConstants;
import com.soundai.nat.institution.admin.framework.exception.CustomException;
import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.security.service.TokenService;
import com.soundai.nat.institution.admin.framework.utils.DateUtils;
import com.soundai.nat.institution.admin.framework.utils.ServletUtils;
import com.soundai.nat.institution.admin.framework.utils.StringUtils;
import com.soundai.nat.institution.admin.framework.utils.spring.SpringUtils;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.module.common.enums.UserStatus;
import com.soundai.nat.institution.admin.module.system.domain.SysUser;
import com.soundai.nat.institution.admin.module.system.mapper.SysUserMapper;
import com.soundai.nat.institution.admin.module.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 用户 业务层处理
 *
 * @author soundai
 */
@Service
@Slf4j
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;


    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }
}
