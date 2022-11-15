package com.soundai.nat.institution.admin.framework.security.handle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.framework.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 认证失败处理类 返回未授权
 *
 * @author soundai
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable {
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException {
        JSONObject unAuth = new JSONObject();
        unAuth.put("code", RespStatus.RS_FORBIDDEN.getCode());
        unAuth.put("message", RespStatus.RS_FORBIDDEN.getMsg());
        ServletUtils.renderString(response, JSON.toJSONString(unAuth));
    }
}
