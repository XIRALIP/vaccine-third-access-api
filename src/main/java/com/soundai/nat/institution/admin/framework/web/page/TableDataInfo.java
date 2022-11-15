package com.soundai.nat.institution.admin.framework.web.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 * 
 * @author soundai
 */
@Data
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long totalCount;

    /** 列表数据 */
    private List<?> data;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String message;

    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
    }

    /**
     * 分页
     * 
     * @param list 列表数据
     * @param totalCount 总记录数
     */
    public TableDataInfo(List<?> list, int totalCount)
    {
        this.data = list;
        this.totalCount = totalCount;
    }

    public long getTotal()
    {
        return totalCount;
    }

    public void setTotal(long totalCount)
    {
        this.totalCount = totalCount;
    }

    public List<?> getRows()
    {
        return data;
    }

    public void setRows(List<?> data)
    {
        this.data = data;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return message;
    }

    public void setMsg(String message)
    {
        this.message = message;
    }
}