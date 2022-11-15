package com.soundai.nat.institution.admin.framework.security.filter;

import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.security.service.TokenService;
import com.soundai.nat.institution.admin.framework.utils.DateUtils;
import com.soundai.nat.institution.admin.framework.utils.SecurityUtils;
import com.soundai.nat.institution.admin.framework.utils.StringUtils;
import com.soundai.nat.institution.admin.framework.utils.thread.Constants;
import com.soundai.nat.institution.admin.framework.utils.thread.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token过滤器 验证token有效性
 *
 * @author soundai
 */
@Component
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter
{
    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException
    {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser) && StringUtils.isNull(SecurityUtils.getAuthentication()))
        {
            //如果有上层调用就用上层的ID
            String traceId = request.getHeader(Constants.TRACE_ID);
            if (traceId == null) {
                traceId = TraceIdUtil.getTraceId();
            }
            String uuid_UserId = traceId+"_"+loginUser.getUser().getUserId();
            MDC.put(Constants.TRACE_ID, uuid_UserId);
            response.setHeader("requestId",uuid_UserId);

            log.info("用户信息：用户名：{}，登陆IP：{}",loginUser.getUsername(),loginUser.getIpaddr());
            tokenService.verifyToken(loginUser);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }
}
