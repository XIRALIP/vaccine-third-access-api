package com.soundai.nat.institution.admin.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author soundai
 */
@Component
@ConfigurationProperties(prefix = "nat.institution.admin")
public class ProjectInfoConfig
{
    /** 上传路径 */
    private static String profile;

    public static String getProfile()
    {
        return profile;
    }

    public void setProfile(String profile)
    {
        ProjectInfoConfig.profile = profile;
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + "/download/";
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + "/upload";
    }
}