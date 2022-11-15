package com.soundai.nat.institution.admin.module.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;

import java.util.List;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_INST_DEVICE;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.DeviceModule.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.InstModule.INST_ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.STATUS;

/**
 * @author wangyu
 * @description: 设备信息表
 * @date 2020/11/16 10:34
 */
@Data
@Document(collection = NAT_INST_DEVICE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Device extends BaseEntity {

    @Indexed(unique = true)
    @Field(ID)
    private String id;

    /**
     * 机构id
     */
    @Field(INST_ID)
    private String instId;


    private List<String> instIds;

    /**
     * 设备编号
     */
    @Field(CODE)
    @NotBlank(message = "设备编号不能为空")
    @Excel(name = "设备编号（必填）")
    private String code;

    /**
     * 设备名称
     */
    @Field(NAME)
    @NotBlank(message = "设备名称不能为空")
    @Excel(name = "设备名称（必填）")
    private String name;

    /**
     * 设备类型（0手持硬携扫码，1智能取码，2台式扫码）
     */
    @Field(TYPE)
    @NotBlank(message = "设备类型不能为空")
    @Excel(name = "设备类型（必填）", readConverterExp = "0=手持便捷扫码,1=智能取码,2=台式扫码,3=译码APP,4=疫苗信息关联终端")
    private Integer type;

    @Field(INST_NAME)
    @Excel(name = "绑定医疗机构（必填）")
    private String instName;

    /**
     * 绑定采样点/检测点的id
     */
    @Field(BIND_POINT_ID)
    private String bindPointId;

    @Field(BIND_POINT_NAME)
    private String bindPointName;

    /**
     * 负责人姓名
     */
    @Field(OWNER)
    @NotBlank(message = "负责人姓名不能为空")
    @Excel(name = "负责人姓名（非必填）")
    private String owner;

    /**
     * 负责人联系方式
     */
    @Field(OWNER_TELPHONE)
    @NotBlank(message = "负责人联系方式不能为空")
    @Excel(name = "负责人联系方式（非必填）")
    private String ownerTelphone;

    /**
     * 设备状态（0启用，1禁用）
     */
    @Field(STATUS)
    @NotBlank(message = "状态（启用0，禁用1）")
    private Integer status;

    @Field(VERSION)
    private String version;

    @Field(OPERATE_TYPE)
    private Integer operateType;

    @Field(IMSI)
    private String imsi;

    @Field(BIND_TYPE)
    private String bindType;

    @Transient
    private List<String> checkPointIds;

    @Transient
    private Integer limit;
    @Transient
    private Integer page;
    /** 排序条件 字段*/
    @Transient
    private String sortBy;
    /** 排序方式 desc asc */
    @Transient
    private String order;

}
