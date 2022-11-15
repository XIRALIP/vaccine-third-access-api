package com.soundai.nat.institution.admin.framework.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.module.system.domain.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName AuthorizationInterceptor
 * @Description 系统授权统一拦截器
 * @Author biantongtong
 * @Date 2020/12/11 下午2:47
 * @Version 1.0
 **/
@Slf4j
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("institution request url:{} params:{}", request.getRequestURL().toString());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof LoginUser) {
            LoginUser loginUser = (LoginUser) principal;
            SysUser sysUser = loginUser.getUser();
            if(sysUser == null){
                returnJson(response);
                return false;
            }
            return true;
        }
        returnJson(response);
        return false;
    }

    private void returnJson(HttpServletResponse response){
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            writer = response.getWriter();
            JSONObject result = new JSONObject();
            result.put("code",RespStatus.RS_UNAUTHORIZED.getCode());
            result.put("message",RespStatus.RS_UNAUTHORIZED.getMsg());
            result.put("data",null);
            writer.print(result);
        } catch (IOException e){
            log.error("拦截器输出流异常",e);
        } finally {
            if(writer != null){
                writer.close();
            }
        }
    }
}
