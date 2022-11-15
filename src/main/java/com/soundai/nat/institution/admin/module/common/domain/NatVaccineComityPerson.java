package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineComityPerson.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineComityPerson.AREA;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineComityPerson.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.*;

/**
 * @Author: changjiarui
 * @description: 疫苗特定团体接种点人员名单表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionNameConstant.NAT_VACCINE_COMITY_PERSON)
public class NatVaccineComityPerson extends BaseEntity {
    @Indexed(unique = true)
    @Field(ID)
    private String id;

    /**
     * 疫苗接种点id
     */
    @Field(VACCINE_POINT_ID)
    private String vaccinePointId;

    /**
     * 姓名
     */
    @Field(NAME)
    @Excel(name = "姓名(必填)")
    private String name;

    /**
     * 证件类型
     */
    @Field(CARD_TYPE)
    @Excel(name = "证件类型(必填)")
    private String cardType;

    /**
     * 证件号码
     */
    @Field(CARD_NUMBER)
    @Excel(name = "证件号码(必填)")
    private String cardNumber;

    /**
     * 居住地区
     */
    @Field(AREA)
    @Excel(name = "居住地区(必填)")
    private String area;

    /**
     * 居住地址
     */
    @Field(ADDRESS)
    @Excel(name = "居住地址(必填)")
    private String address;

    /**
     * 联系方式
     */
    @Field(TELEPHONE)
    @Excel(name = "联系方式(必填)")
    private String telephone;

    /**
     * 是否预约（0否，1是）
     */
    @Field(ORDER_FLAG)
    private Integer orderFlag;

    @Transient
    private Integer row;

}
