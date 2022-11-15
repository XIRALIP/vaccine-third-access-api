package com.soundai.nat.institution.admin.module.common.domain;


import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.CheckPointModule.CARD_NUMBER;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.CheckPointModule.CARD_TYPE;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.EmergencyModule.LAST_CALL_STATUS;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.EmergencyModule.LAST_CALL_TIME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineComityPerson.VACCINE_POINT_ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.SAM_ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.SAM_NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.APPO_STATUS;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineResident.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.TELPHONE;
import static com.soundai.nat.institution.admin.module.common.domain.NatInstSamplePoint.*;

/**
 * @author
 * @version 1.0.0
 * @ClassName NatVaccineResident.java
 * @Description 疫苗居民表
 * @createTime 2021年02月08日 10:48:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionNameConstant.NAT_VACCINE_RESIDENT)
public class NatVaccineResident extends BaseEntity {
    @Field(ID)
    private String  id; //ID
    @Field(INST_ID)
    private String  instId; //所属组织id(接种单位id)
    @Field(SAM_ID)
    private String vaccinePointId; // 接种点id
    @Field(SAM_NAME)
    private String vaccinePointName; // 接种点名称
    @Field(NAME)
    @Excel(name = "姓名(必填)")
    private String  name;               //姓名

    @Excel(name = "联系方式(必填)")
    @Field(TELPHONE)
    private String  telphone;	     	//	联系方式

    @Field(CARD_TYPE)
    @Excel(name = "证件类型(必填)")
    private String  cardType;	     	//	证件类型

    @Field(CARD_NUMBER)
    @Excel(name = "证件号码(必填)")
    private String  cardNumber;    	//	证件号码

    @Field(ADDRESS)
    @Excel(name = "居住地址(必填)" )
    private String  address;	         //	居住地址
    @Field(COMMUNITY_CODE)
    private String  communityCode;     //	居住地所属社区代码

    @Field(AREA_CODE)
    private String areaCode;           //居民所属行政区区划代码
    @Field(AREA_NAME)
    @Excel(name = "居住地区(必填)")
    private String areaName;           //居民所属行政区区划名称

    @Field(COMMUNITY_NAME)
    private String  communityName;     //	居住地所属社区名称
    @Field(LAST_CALL_TIME)
    private String  lastCallTime;     //	最近一次呼叫时间
    @Field(LAST_CALL_TIME_SUCCESS)
    private String  lastCallTimeSuccess;	//否	最近一次呼叫成功时间
    @Field(LAST_CALL_STATUS)
    private String  lastCallStatus;	   //否	最近一次呼叫状态（"IN_CALL"呼叫中，“CALL_SUCCESS”有效接通，“CALL_FAIL”无效接通）
    @Field(LAST_SMS_TIME)
    private String  lastSmsTime;	        //否	最近一次短信通知时间
    @Field(LAST_SMS_TIME_SUCCESS)
    private String  lastSmsTimeSuccess;	//否	最近一次短信通知成功时间
    @Field(APPO_STATUS)
    private Integer  appoStatus;	            //预约状态（1：第一次接种预约，2：第二次接种预约， -1:未预约，缺省 ）
    @Field(VACCINE_STATUS)
    private Integer  vaccineStatus;      	//接种状态（10：第一次接种完成，20：第二次接种完成， -1:未接种，缺省 ）
    @Field(MANUFACTURER)
    private String manufacturer;
    @Field(FIRST_VACCINE_TIME)
    private String  firstVaccineTime;  	//第一次接种时间
    @Field(SECOND_VACCINE_TIME)
    private String  secondVaccineTime; 	//第二次接种时间
    @Field(VACCINE_INTERVAL_OVER)
    private Integer  vaccineIntervalOver;	//两次接种时间是否超过 14 天，1：是，2：否，缺省 2
    @Field(REGISTER_SUBDISTRICT_CODE)
    private String  registerSubdistrictCode;//登记街道/乡镇区划代码
    @Field(REGISTER_SUBDISTRICT_NAME)
    private String  registerSubdistrictName;//登记街道/乡镇名称
    @Field(REGISTER_COMMITY_CODE)
    private String  registerCommityCode;//登记村/居委会区划代码
    @Field(REGISTER_COMMITY_NAME)
    private String  registerCommityName;//登记村/居委会名称
    @Field(REGISTER_ADDRESS)
    private String  registerAddress;   //登记详细地址
    @Field(REGISTER_NONVACCINE_REASON)
    private String  registerNonvaccineReason;//登记未接种原因(暂未定以 code 或者 detail 存储)
    @Field(REGISTER_CROWD_TYPE)
    private String  registerCrowdType;    //登记人群分类
    @Field(REGISTER_COMPANY)
    private String  registerCompany;   //登记所属公司
}
