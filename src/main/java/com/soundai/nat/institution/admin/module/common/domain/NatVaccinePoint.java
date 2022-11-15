package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccinePoint.*;

/**
 * @title: NatVaccinePoint
 * @author: zhaozhenyu
 * @date: 2020/11/16 19:47
 * @description: 疫苗接种点数据表
 * @version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionNameConstant.NAT_VACCINE_POINT)
public class NatVaccinePoint extends BaseEntity {
    @Indexed(unique = true)
    @Field(ID)
    private String id;            //id
    @Field(INST_ID)
    private String instId;        //机构id
    @Field(VACCINE_POINT_NAME)
    private String vaccinePointName;//采样点名称
    @Field(VACCINE_POINT_TYPE)
    private Integer vaccinePointType; // 疫苗接种类型（0公开预约接种点， 1特定团体接种点）
    @Field(PROVINCE)
    private String province;      //省份
    @Field(PROVINCE_CODE)
    private String provinceCode;
    @Field(CITY)
    private String city;         //市
    @Field(CITY_CODE)
    private String cityCode;         //市
    @Field(AREA)
    private String area;          //区/县
    @Field(ADDRESS)
    private String address;       //详细地址
    @Field(PHONE)
    private String phone;         //手机号码
    @Field(HOTLINE)
    private String hotline;
    @Field(CONTACTS)
    private String contacts;        //联系人
    @Field(STATUS)
    private Integer status;       //状态（0启用，1禁用，2隐藏）
//    @Field(START_DATE)
//    private String startDate;     // 起始日期（yyyy-MM-dd）
//    @Field(END_DATE)
//    private String endDate;       // 结束日期（yyyy-MM-dd）
    @Field(WORK_DAYS)
    private List<String> workDays; //周工作日(["1","2","3","4","5","6","7"])
    @Field(AM_START_TIME)
    private String amStartTime;     //上午开始时间(08:30)
    @Field(AM_END_TIME)
    private String amEndTime;       //上午结束时间(11:30)
    @Field(PM_START_TIME)
    private String pmStartTime;     //下午开始时间(13:30)
    @Field(PM_END_TIME)
    private String pmEndTime;       //下午结束时间(19:30)
    @Field(APPO_QUOTA)
    private Integer appoQuota;     //预约额度
    @Field(AGE_MIN_LIMIT)
    private Integer ageMinLimit;
    @Field(AGE_MAX_LIMIT)
    private Integer ageMaxLimit;
    @Field(SUBDISTRICT_CODE)
    private String subdistrictCode; // 所属街道区划代码
    @Field(SUBDISTRICT_NAME)
    private String subdistrictName; // 所属街道区划名称
    @Field(AREA_CODE)
    private String areaCode; // 地区编码
    @Field(OBSERVATION_ID)
    private String observationId;
    @Field(ESCAPE_ID)
    private String escapeId;
    @Field(REMARK)
    private String remark;
    @Field(SECOND_VACCINE_APPO_TIME_INTERVAL)
    private Integer secondVaccineAppoTimeInterval;
}
