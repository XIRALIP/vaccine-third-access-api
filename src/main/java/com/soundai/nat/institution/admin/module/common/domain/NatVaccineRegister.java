package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import com.soundai.nat.institution.admin.module.common.constant.FieldConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRegister.*;

/**
 * @Author: changjiarui
 * @description: 疫苗登记表
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionNameConstant.NAT_VACCINE_REGISTER)
public class NatVaccineRegister{
    @Field("id")
    private String id;
    @Field("appo_date")
    private String appoDate;
    @Field("appo_period")
    private String appoPeriod;
    @Field("checked_person")
    private String checkedPerson;
    @Field("checked_person_name")
    private String checkedPersonName;
    @Field("card_number_type")
    private String cardNumberType;
    @Field("checked_person_card_number")
    private String checkedPersonCardNumber;
    @Field("checked_person_telephone")
    private String checkedPersonTelephone;
    @Field("person_classification")
    private String personClassification;
    @Field("area")
    private String area;
    @Field("subdistrict_name")
    private String subdistrictName;
    @Field("neighborhood")
    private String neighborhood;
    @Field("checked_person_detail_address")
    private String checkedPersonDetailAddress;
    @Field("comity_person_address")
    private String comityPersonAddress;
    @Field("company")
    private String company;
    @Field("status")
    private Integer status;
    @Field("regist_time")
    private String registTime;
    @Field("regist_user_id")
    private String registUserId;
    @Field("regist_user_name")
    private String registUserName;
    @Field("regist_dev_code")
    private String registDevCode;
    @Field("vaccinate_time")
    private String vaccinateTime;
    @Field("not_vaccinate_time")
    private String notVaccinateTime;
    @Field("not_vaccinate_reason")
    private String notVaccinateReason;
    @Field("inst_id")
    private String instId;
    @Field("sam_inst_name")
    private String samInstName;
    @Field("sam_id")
    private String samId;
    @Field("sam_name")
    private String samName;
    @Field("sam_area_code")
    private String samAreaCode;
    @Field("subdistrict_code")
    private String subdistrictCode;
    @Field("sam_subdistrict_code")
    private String samSubdistrictCode;
    @Field("sam_subdistrict_name")
    private String samSubdistrictName;
    @Field("inst_id_old")
    private String instIdOld;
    @Field("sam_inst_name_old")
    private String samInstNameOld;
    @Field("sam_id_old")
    private String samIdOld;
    @Field("sam_name_old")
    private String samNameOld;
    @Field("sam_subdistrict_code_old")
    private String samSubdistrictCodeOld;
    @Field("sam_subdistrict_name_old")
    private String samSubdistrictNameOld;
    @Field("appo_channel")
    private Integer appoChannel;
    @Field("create_time")
    private String createTime;
    @Field("modify_time")
    private String modifyTime;
    @Field("age")
    private Integer age;
    /**
     *性别
     */
    @Field("gender")
    private String gender;

}
