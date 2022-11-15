package com.soundai.nat.institution.admin.framework.config;

import com.soundai.nat.institution.admin.framework.constant.Constants;
import com.soundai.nat.institution.admin.framework.interceptor.AuthorizationInterceptor;
import com.soundai.nat.institution.admin.framework.interceptor.RepeatSubmitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 通用配置
 *
 * @author soundai
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer
{
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;

    @Autowired
    private RepeatSubmitInterceptor repeatSubmitInterceptor;

    /**
     * 不需要登录拦截的url
     */
    final String[] notLoginInterceptPaths = {"/login", "/captchaImage","/phoneCaptcha","/v3/api-docs/**","/swagger**/**"};


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        /** 本地文件上传路径 */
        registry.addResourceHandler(Constants.RESOURCE_PREFIX + "/**").addResourceLocations("file:" + ProjectInfoConfig.getProfile() + "/");
    }

    /**
     * 自定义拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**").excludePathPatterns(notLoginInterceptPaths);
        registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }

    /**
     * 跨域配置
     */
    @Bean
    public CorsFilter corsFilter()
    {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置访问源地址
        config.addAllowedOrigin("*");
        // 设置访问源请求头
        config.addAllowedHeader("*");
        // 设置访问源请求方法
        config.addAllowedMethod("*");
        // 对接口配置跨域设置
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
