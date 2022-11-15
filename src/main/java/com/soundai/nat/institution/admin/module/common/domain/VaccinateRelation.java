package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import com.soundai.nat.institution.admin.module.common.constant.FieldConstant;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.VaccinateRelation.*;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName NatVaccine.java
 * @Description 疫苗与人关联表
 * @createTime 2021年02月22日 10:30:00
 */
@Data
@Document(collection = CollectionNameConstant.VACCINATE_RELATION)
public class VaccinateRelation {
    @Field(ID)
    private String id; //uuid(按照时间戳生成的uuid)

    @Field(VACCIN_CODE)
    private String vaccinCode; // 疫苗码

    @Field(VACCIN_CODE_IMG)
    private String vaccinCodeImg; // 疫苗码图片存储位置

    @Field(PERSON_NAME)
    private String personName;  //接种人姓名

    @Field(PERSON_CODE_TYPE)
    private String personCodeType;  // 证件类型

    @Field(PERSON_CODE)
    private String personCode;  // 证件号

    @Field(PERSON_CODE_IMG)
    private String personCodeImg;  //证件图片存放位置

    @Field(PERSON_PHONE)
    private String personPhone;  // 电话号码

    @Field(SAM_TIME)
    private String samTime;  // 接种时间 yyyy-MM-dd HH:MM:SS

    @Field(SAM_USER_ID)
    private String samUserId;  // 采样人登录账号id

    @Field(SAM_USER_INST_ID)
    private String samUserInstId;  // 登录账号所属机构id

    @Field(SAM_ID)
    private String samId;  // 采样点id

    @Field(SAM_NAME)
    private String samName;  // 采样点名称

    @Field(SAM_INST_ID)
    private String samInstId;  // 采样点所属机构id

    @Field(SAM_DEV_CODE)
    private String samDevCode;  // 采样设备编号

    @Field(MODIFY_TIME)
    private String modifyTime;  // 修改时间 yyyy-MM-dd HH:MM:SS

    @Field(FieldConstant.STATUS)
    private Integer status;  // RESERVED
}
