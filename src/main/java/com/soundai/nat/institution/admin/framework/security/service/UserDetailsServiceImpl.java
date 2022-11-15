package com.soundai.nat.institution.admin.framework.security.service;

import com.soundai.nat.institution.admin.framework.exception.BaseException;
import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.utils.StringUtils;
import com.soundai.nat.institution.admin.module.common.enums.UserStatus;
import com.soundai.nat.institution.admin.module.system.domain.SysUser;
import com.soundai.nat.institution.admin.module.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户验证处理
 *
 * @author soundai
 */
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.selectUserByUserName(username);
        if (StringUtils.isNull(user)) {
            log.info("登录用户：{} 不存在.", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        } else if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new BaseException("对不起，您的账号：" + username + " 已停用");
        }

        return createLoginUser(user,user.getUserType());
    }

    public UserDetails createLoginUser(SysUser user,String userType) {
        Set<String> permissions = new HashSet<>();
        permissions.add(userType);
        return new LoginUser(user);
    }

}
