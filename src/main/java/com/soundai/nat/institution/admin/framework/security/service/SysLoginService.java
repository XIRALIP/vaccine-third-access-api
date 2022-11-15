package com.soundai.nat.institution.admin.framework.security.service;

import com.soundai.nat.institution.admin.framework.exception.CustomException;
import com.soundai.nat.institution.admin.framework.security.LoginBody;
import com.soundai.nat.institution.admin.framework.security.LoinParam;
import com.soundai.nat.institution.admin.framework.utils.redis.RedisCache;
import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.module.common.enums.UserStatus;
import com.soundai.nat.institution.admin.module.system.domain.SysUser;
import com.soundai.nat.institution.admin.module.system.mapper.SysUserMapper;
import com.soundai.nat.institution.admin.module.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author soundai
 */
@Slf4j
@Component
public class SysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;


    /**
     * @return com.soundai.nat.institution.admin.framework.security.LoginUser
     * @Author biantongtong
     * @Description 登录验证
     * @Date 下午9:09 2021/1/2
     * @Param [loginBody]
     **/
    public LoginUser login(LoinParam loginBody, SysUser user) {

        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            throw new CustomException(RespStatus.RS_USER_LOCK);
        }

        String username = loginBody.getAppkey();
        String password = loginBody.getAppSecret();
        // 用户验证
        Authentication authentication = null;

        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            if (e instanceof UsernameNotFoundException) {
//                AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, "user.password.not.match"));
                throw new UsernameNotFoundException(e.getMessage());
            }
        }
        return (LoginUser) authentication.getPrincipal();
    }
}
