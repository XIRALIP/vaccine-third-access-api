package com.soundai.nat.institution.admin.framework.web.page;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页数据
 * 
 * @author soundai
 */
@Data
public class CommonDomain implements Serializable
{
    private static final long serialVersionUID = -922749868715917742L;
    /** 每页显示记录数 */
    private Integer limit;
    /** 当前记录页数 */
    private Integer page;
    /** 排序条件 字段*/
    private String sortBy;
    /** 排序方式 desc asc */
    private String order;

}
