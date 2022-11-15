package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.VaccinationInfoField.*;

/**
 * @author Jefferson Li
 * @title VaccinationInfo
 * @description 接收新冠接种推送记录对象
 * @date 2021/4/1 2:15
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionNameConstant.NAT_VACCINATION_RECORD)
public class VaccinationInfo extends BaseEntity {

    @Field(ID)
    private String id;

    @Field(NAME)
    private String name;

    @Field(CARD_NO)
    private String cardNo;

    @Field(DEPA_CODE)
    private String depaCode;

    /** 接种剂次 */
    @Field(INOC_TIME)
    private Integer inocTime;

    @Field(INOC_BACT_CODE)
    private String inocBactCode;

    @Field(INOC_BACT_NAME)
    private String inocBactName;

    @Field(INOC_DATE)
    private String inocDate;

    @Field(INOC_BACH_NO)
    private String inocBachNo;

    @Field(INOC_CORP_CODE)
    private String inocCorpCode;

}
