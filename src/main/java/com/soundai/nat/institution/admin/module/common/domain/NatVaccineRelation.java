package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatAppoCheck.APPO_PERIOD;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.NEIGHBORHOOD;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.SUBDISTRICT_NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.AGE;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.CARD_NUMBER_TYPE;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.CHECKED_PERSON_CARD_NUMBER;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.CHECKED_PERSON_DETAIL_ADDRESS;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.CHECKED_PERSON_NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.CHECKED_PERSON_TELEPHONE;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.COMPANY;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.PERSON_CLASSIFICATION;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.SAM_ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.SAM_ID_OLD;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName NatVaccineRelation.java
 * @Description TODO
 * @createTime 2021年02月22日 10:30:00
 */
@Data
@Document(collection = CollectionNameConstant.NAT_VACCINE_RELATION)
public class NatVaccineRelation extends BaseEntity {
    @Field(ID)
    private String id; //uuid(按照时间戳生成的uuid)

    @Field(CHECKED_PERSON_NAME)
    private String checkedPersonName;  //受检人姓名

    @Field(CHECKED_PERSON_TELEPHONE)
    private String checkedPersonTelephone;  //受检人联系方式

    @Field(CARD_NUMBER_TYPE)
    private String cardNumberType;  //受检人证件类型（身份证/护照/港澳通行证/台胞证）

    @Field(CHECKED_PERSON_CARD_NUMBER)
    private String checkedPersonCardNumber;  //受检人证件号码

    @Field(AGE)
    private Integer age;

    @Field(VACCINATION_STATUS)
    private Integer vaccinationStatus;  //接种状态

    @Field(FIRST_VACCINATION_DATE)
    private String firstVaccinationDate;  //完成第一次接种日期

    @Field(SECOND_VACCINATION_DATE)
    private String secondVaccinationDate;  //完成第二次接种日期

    @Field(INST_ID)
    private String instId;  //最后一次接种单位id

    @Field(SAM_INST_NAME)
    private String samInstName;  //最后一次接种单位名称

    @Field(SAM_ID)
    private String samId;  //最后一次接种点id（留观点id）

    @Field(SAM_NAME)
    private String samName;  //最后一次接种点名称（留观点名称）

    @Field(APPO_CHANNEL)
    private Integer appoChannel;  //最后一次预约渠道

    @Field(APPO_DATE)
    private String appoDate;  //最后一次预约日期

    @Field(APPO_PERIOD)
    private String appoPeriod;  //最后一次次预约时间段

    @Field(VACCINATE_TIME)
    private String vaccinateTime;  //第一次扫留观码登记时间

    @Field(REGIST_TIME)
    private String registTime;  //第一次APP扫码登记时间

    @Field(SUBDISTRICT_NAME)
    private String subdistrictName;  //街镇

    @Field(NEIGHBORHOOD)
    private String neighborhood;  //村/居委会

    @Field(PERSON_CLASSIFICATION)
    private String personClassification;  //人群分类

    @Field(CHECKED_PERSON_DETAIL_ADDRESS)
    private String checkedPersonDetailAddress;  //详细地址

    @Field(COMPANY)
    private String company;  //所属公司

    @Field(MANUFACTURER)
    private String manufacturer;  //疫苗厂商

    @Field(SAM_ID_OLD)
    private String samIdOld;  // 接种点id（预约接种点id）

    @Field(SAM_NAME_OLD)
    private String samNameOld;  // 接种点名称（预约接种点名称）

    @Field(VACCINE_CODE)
    private String vaccineCode;

    @Field(VACCINE_BATCH_ID)
    private String vaccineBatchId;

    @Field(FIRST_INST_ID)
    private String firstInstId;

    @Field(FIRST_VACCINE_BATCH_ID)
    private String firstVaccineBatchId;

    @Field(FIRST_VACCINE_CODE)
    private String firstVaccineCode;

    @Field(FIRST_MANUFACTURER)
    private String firstManufacturer;
}
