package com.soundai.nat.institution.admin.module.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 操作日志记录表 oper_log
 *
 * @author ruoyi
 */
@Data
public class SysOperLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    private String operId;

    /**
     * 操作模块
     */
    @Excel(name = "操作模块", readConverterExp = "1=登录登出,2=检测机构,3=检测机构-待检测样本查询,4=检测机构-样本结果审核,5=检测机构-检测样本查询,6=检测机构-日常采样点,7=检测机构-外采采样点,8=检测机构-团体预约任务,9=检测机构-数据查询管理,10=应急采样组织,11=应急采样组织-采样点信息管理,12=应急采样组织-待检测样本查询,13=应急采样组织-已检测样本查询,14=应急采样组织-采样标记试管查询,15=应急采样组织-团体预约任务,16=应急采样组织-社区居民管理,17=应急采样组织-数据查询管理,18=操作日志,19=系统管理,20=其它")
    private Integer operModule;

    /**
     * 操作内容
     */
    @Excel(name = "操作内容")
    private String operContent;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @Excel(name = "业务类型", readConverterExp = "1=登录,2=登出,3=新增,4=修改,5=删除,6=审核,7=信息查看,8=状态开关,9=导出,10=导入,11=呼叫,12=下载,13=其他")
    private Integer businessType;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求方式
     */
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    private Integer operType;

    /**
     * 操作人员
     */
    @Excel(name = "操作人员")
    private String operUserName;

    /**
     * 操作人员id
     */
    private String operUserId;

    /**
     * 请求url
     */
    private String operUrl;

    /**
     * 操作地址
     */
    private String operIp;

    /**
     * 操作地点
     */
    private String operLocation;

    /**
     * 请求参数
     */
    private String operParam;

    /**
     * 返回参数
     */
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private Integer status;

    /**
     * 错误消息
     */
//    @Excel(name = "错误消息")
    private String errorMsg;

    /**
     * 操作时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date operTime;


    private String beginTime;

    private String endTime;

    /**
     * 排序条件 字段
     */
    private String sortBy;
    /**
     * 排序方式 desc asc
     */
    private String order;
}
