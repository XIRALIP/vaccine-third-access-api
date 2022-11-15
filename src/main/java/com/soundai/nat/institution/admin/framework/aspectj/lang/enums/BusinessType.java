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
public enum BusinessType {
    /**
     * 登录
     */
    LOGIN(1, "登录"),
    /**
     * 登出
     */
    LOGOUT(2, "登出"),
    /**
     * 新增
     */
    INSERT(3, "新增"),

    /**
     * 修改
     */
    UPDATE(4, "修改"),

    /**
     * 删除
     */
    DELETE(5, "删除"),

    /**
     * 审核
     */
    CHECK(6, "审核"),

    /**
     * 信息查看
     */
    VIEW(7, "信息查看"),

    /**
     * 开关
     */
    SWITCH(8, "状态开关"),
    /**
     * 导出
     */
    EXPORT(9, "导出"),

    /**
     * 导入
     */
    IMPORT(10, "导入"),


    /**
     * 呼叫
     */
    CALL(11, "呼叫"),

    /**
     * 下载
     */
    DOWNLOAD(12, "下载"),

    /**
     * 其它
     */
    OTHER(13, "其它");

    private final Integer dictValue;
    private final String dictLabel;

    BusinessType(Integer dictValue, String dictLabel) {
        this.dictValue = dictValue;
        this.dictLabel = dictLabel;
    }

    public static String getNameByCode(Integer dictValue) {
        for (BusinessType c : BusinessType.values()) {
            if (c.getDictValue() == dictValue) {
                return c.dictLabel;
            }
        }
        return null;
    }

    public static List<Map> getValues() {
        List<Map> values=new ArrayList<>();
        for (BusinessType c : BusinessType.values()) {
            Map item=new HashMap();
            item.put("dictValue",c.dictValue);
            item.put("dictLabel",c.dictLabel);
            values.add(item);
        }
        return values;
    }

}

