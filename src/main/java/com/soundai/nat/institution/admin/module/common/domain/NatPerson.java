package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.module.common.constant.FieldConstant;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("nat_checked_person")
public class NatPerson {

    @Field(FieldConstant.NatCheckedPerson.PERSON_NAME)
    private String person_name;

    @Field(FieldConstant.NatCheckedPerson.CARD_TYPE)
    private String card_type;

    @Field(FieldConstant.NatCheckedPerson.IS_CHECKED)
    private Integer isChecked;

    @Field(FieldConstant.NatCheckedPerson.CARD_NUMBER)
    private String card_number;
    @Field(FieldConstant.NatCheckedPerson.SHARD_ID)
    private String shardId;

    @Field(FieldConstant.NatCheckedPerson.TELEPHONE)
    private String telephone;

    @Field(FieldConstant.NatCheckedPerson.ADDRESS)
    private String address;

    @Field(FieldConstant.NatCheckedPerson.PERSON_CLASSIFICATION)
    private String personClassification;

    @Field(FieldConstant.NatCheckedPerson.PERSON_CLASSIFICATION_CODE)
    private String personClassificationCode;


    @Field(FieldConstant.NatCheckedPerson.COMPANY)
    private String company;

    @Field(FieldConstant.NatCheckedPerson.PROVINC_ECODE)
    private String provinceCode;

    @Field(FieldConstant.NatCheckedPerson.PROVINCE_NAME)
    private String provinceName;

    @Field(FieldConstant.NatCheckedPerson.CITY_CODE)
    private String cityCode;

    @Field(FieldConstant.NatCheckedPerson.CITY_NAME)
    private String cityName;

    @Field(FieldConstant.NatCheckedPerson.AREA_CODE)
    private String areaCode;

    @Field(FieldConstant.NatCheckedPerson.AREA_NAME)
    private String areaName;

    @Field(FieldConstant.NatCheckedPerson.PERSON_TYPE)
    private Integer person_type;

    @Field(FieldConstant.NatCheckedPerson.CREATE_TIME)
    private String create_time;

    @Field(FieldConstant.NatCheckedPerson.UPDATE_TIME)
    private String update_time;
    @Transient
    private String reportState;
    @Transient
    private String reportTime;

    /**
     *性别
     */
    @Field(FieldConstant.NatCheckedPerson.GENDER)
    private String gender;
    /**
     *出生日期
     */
    @Field(FieldConstant.NatCheckedPerson.BIRTHDAY)
    private String birthday;
    /**
     *职业
     */
    @Field(FieldConstant.NatCheckedPerson.CAREER)
    private String career;
    /**
     *职业代码
     */
    @Field(FieldConstant.NatCheckedPerson.CAREER_CODE)
    private String careerCode;

    /**
     * 户籍地省代码
     */
    @Field(FieldConstant.NatCheckedPerson.ORIGIN_PROVINCECODE)
    private String originProvinceCode;

    @Field(FieldConstant.NatCheckedPerson.ORIGIN_PROVINCENAME)
    private String originProvinceName;

    @Field(FieldConstant.NatCheckedPerson.ORIGIN_CITY_CODE)
    private String originCityCode;

    @Field(FieldConstant.NatCheckedPerson.ORIGIN_CITY_NAME)
    private String originCityName;

    @Field(FieldConstant.NatCheckedPerson.ORIGIN_AREA_CODE)
    private String originAreaCode;

    @Field(FieldConstant.NatCheckedPerson.ORIGIN_AREANAME)
    private String originAreaName;


    @Field(FieldConstant.NatCheckedPerson.ORIGIN_ADDRESS)
    private String originAddress;
}
