package com.soundai.nat.institution.admin.framework.utils;

import com.soundai.nat.institution.admin.framework.exception.CustomException;
import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全服务工具类
 *
 * @author soundai
 */
@Slf4j
public class SecurityUtils {

    /**
     * 获取用户id
     **/
    public static String getUserId() {
        try {
            return getLoginUser().getUser().getUserId();
        } catch (Exception e) {
            throw new UsernameNotFoundException("获取用户账户异常");
        }
    }


    /**
     * 获取用户账户
     **/
    public static String getUsername() {
        try {
            return getLoginUser().getUsername();
        } catch (Exception e) {
            throw new UsernameNotFoundException("获取用户账户异常");
        }
    }

    /**
     * 获取用户账户
     **/
    public static String getUserNickName() {
        try {
            return getLoginUser().getUser().getNickName();
        } catch (Exception e) {
            throw new UsernameNotFoundException("获取用户账户异常");
        }
    }

    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser() {
        try {
            return (LoginUser) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new UsernameNotFoundException("获取用户信息异常");
        }
    }
    public static String getUserDbPermissions() {
        try {
            return getLoginUser().getUser().getDbPermissions();
        }
        catch (Exception e)
        {
            throw new UsernameNotFoundException("获取用户所在机构ID异常");
        }
    }


    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword     真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    /**
     * 是否为管理员
     *
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(String userId) {
        return StringUtils.equals("3", userId);
    }

    public static void main(String[] args) {
        //密码生成
        System.out.println(encryptPassword("szjk_u1Pass1234"));
        System.out.println(encryptPassword("szjk_u1Pass4567"));
        System.out.println(encryptPassword("szjk_u1Pass8910"));
    }
}
