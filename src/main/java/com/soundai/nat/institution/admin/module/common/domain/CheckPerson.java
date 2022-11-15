package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.CheckPointModule.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.InstModule.INST_ID;

/**
 * @Author: wangyu
 * @Date: Created 2020-11-18 15:46
 * @Description: 采样人员/检测人员数据表
 * @Modified By:
 */
@Data
@Document(collection = "nat_inst_person")
public class CheckPerson extends BaseEntity {

    @Indexed(unique = true)
    @Field(ID)
    private String id;

    /**
     * 机构id
     */
    @Field(INST_ID)
    private String instId;

    /**
     * 姓名
     */
    @Field(NAME)
    private String name;

    /**
     * 性别 0：男 1：女
     */
    @Field(SEX)
    private Integer sex;

    /**
     * 出生日期
     */
    @Field(BIRTHDATE)
    private String birthdate;

    /**
     * 民族
     */
    @Field(NATION)
    private String nation;

    /**
     * 学历
     */
    @Field(EDU)
    private String edu;

    /**
     * 政治面貌
     */
    @Field(POLITIC)
    private String politic;

    /**
     * 证件类型
     */
    @Field(CARD_TYPE)
    private String cardType;

    /**
     * 证件号码
     */
    @Field(CARD_NUMBER)
    private String cardNumber;


    /**
     * 联系方式
     */
    @Field(TELPHONE)
    private String telphone;

    /**
     * 邮箱
     */
    @Field(EMAIL)
    private String email;

    /**
     * 省份
     */
    @Field(PROVINCE)
    private String province;

    /**
     * 市
     */
    @Field(CITY)
    private String city;

    /**
     * 区/县
     */
    @Field(AREA)
    private String area;

    /**
     * 详细地址
     */
    @Field(ADDRESS)
    private String address;

    /**
     * 毕业院校
     */
    @Field(UNIVERSITY)
    private String university;

    /**
     * 专业
     */
    @Field(MAJOR)
    private String major;

    /**
     * 类型（0采样人员，1检测人员）
     */
    @Field(TYPE)
    private Integer type;


}
