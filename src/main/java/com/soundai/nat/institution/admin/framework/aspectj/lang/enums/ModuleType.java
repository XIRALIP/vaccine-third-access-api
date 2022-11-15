package com.soundai.nat.institution.admin.framework.aspectj.lang.enums;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务操作类型
 *
 * @author azero
 */
@Getter
public enum ModuleType {
    /**
     * 登录登出
     */
    LOGIN_OR_LOGOUT(1, "登录登出"),

    /**
     * 检测机构
     */
    INST(2, "检测机构"),

    /**
     * 检测机构-待检测样本查询
     */
    INST_TO_CHECK(3, "检测机构-待检测样本查询"),

    /**
     * 检测机构-样本结果审核
     */
    INST_CHECKED(4, "检测机构-样本结果审核"),

    /**
     * 检测机构-检测样本查询
     */
    INST_CHECK(5, "检测机构-检测样本查询"),

    /**
     * 检测机构-日常采样点
     */
    INST_SAMP(6, "检测机构-日常采样点"),

    /**
     * 检测机构-外采采样点
     */
    INST_OUTSIDE_SAMP(7, "检测机构-外采采样点"),

    /**
     * 检测机构-团体预约任务
     */
    INST_COMITY(8, "检测机构-团体预约任务"),

    /**
     * 检测机构-数据查询管理
     */
    INST_DATA(9, "检测机构-数据查询管理"),


    /**
     * 应急采样组织
     */
    SAMP(10, "应急采样组织"),
    /**
     * 应急采样组织-采样点信息管理
     */
    SAMP_POINT(11, "应急采样组织-采样点信息管理"),
    /**
     * 应急采样组织-待检测样本查询
     */
    SAMP_TO_CHECK(12, "应急采样组织-待检测样本查询"),
    /**
     * 应急采样组织-已检测样本查询
     */
    SAMP_CHECKED(13, "应急采样组织-已检测样本查询"),
    /**
     * 应急采样组织-采样标记试管查询
     */
    SAMP_SIGN(14, "应急采样组织-采样标记试管查询"),
    /**
     * 应急采样组织-团体预约任务
     */
    SAMP_COMITY(15, "应急采样组织-团体预约任务"),
    /**
     * 应急采样组织-社区居民管理
     */
    SAMP_RESIDENT(16, "应急采样组织-社区居民管理"),
    /**
     * 应急采样组织-数据查询管理
     */
    SAMP_DATA(17, "应急采样组织-数据查询管理"),

    /**
     * 操作日志
     */
    LOG(18, "操作日志"),

    /**
     * 系统管理
     */
    SYSTEM(19, "系统管理"),

    /**
     * 其它
     */
    OTHER(20, "其它"),

    /**
     *
     */
    VACCINE(21, "疫苗管理");


    private final Integer dictValue;
    private final String dictLabel;

    ModuleType(Integer dictValue, String dictLabel) {
        this.dictValue = dictValue;
        this.dictLabel = dictLabel;
    }

    public static String getNameByCode(Integer dictValue) {
        for (ModuleType c : ModuleType.values()) {
            if (c.getDictValue() == dictValue) {
                return c.dictLabel;
            }
        }
        return null;
    }

    public static List<Map> getValues() {
        List<Map> values = new ArrayList<>();
        for (ModuleType c : ModuleType.values()) {
            Map item = new HashMap();
            item.put("dictValue", c.dictValue);
            item.put("dictLabel", c.dictLabel);
            values.add(item);
        }
        return values;
    }

}
