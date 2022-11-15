package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_COMITY;

/**
 * @Author: changjiarui
 * @description: 团体预约表
 */
@Data
@Document(collection = NAT_COMITY)
public class NatComity extends BaseEntity {

    public static final String ID="id";
    public static final String INST_ID="inst_id";
    public static final String COMITY_NAME="comity_name";
    public static final String COMITY_APPO_DATE="comity_appo_date";
    public static final String COMITY_APPO_NUMBER = "comity_appo_number";
    public static final String COMITY_SAMPLED_NUMBER="comity_sampled_number";
    public static final String COMITY_CHECKED_NUMBER="comity_checked_number";
    public static final String COMITY_NEGATIVE_NUMBER = "comity_negative_number";
    public static final String COMITY_POSITIVE_NUMBER = "comity_positive_number";
    public static final String COMITY_PRINCIPAL_NAME = "comity_principal_name";
    public static final String COMITY_PRINCIPAL_PHONE_NUMBER = "comity_principal_phone_number";
    public static final String COMITY_TYPE = "comity_type";
    public static final String SAM_ID = "sam_id";

    /**
     * 团体预约id
     */
    @Indexed(unique=true)
    @Field(ID)
    private String id;

    /**
     * 团体预约机构id，新增团体预约数据的机构 id
     */
    @Field(INST_ID)
    private String instId;

    /**
     * 团体预约名称
     */
    @Field(COMITY_NAME)
    private String comityName;

    /**
     * 团体预约日期
     */
    @Field(COMITY_APPO_DATE)
    private String comityAppoDate;

    /**
     * 团体预约人数，根据导入的数据表计算
     */
    @Field(COMITY_APPO_NUMBER)
    private Long comityAppoNumber;

    /**
     * 团体已采样人数，默认 0
     */
    @Field(COMITY_SAMPLED_NUMBER)
    private Long comitySampledNumber;

    /**
     * 团体已检测人数，默认 0
     */
    @Field(COMITY_CHECKED_NUMBER)
    private Long comityCheckedNumber;

    /**
     * 团体人员检测阴性数，默认0
     */
    @Field(COMITY_NEGATIVE_NUMBER)
    private Long comityNegativeNumber;

    /**
     * 团体人员检测阳性数，默认0
     */
    @Field(COMITY_POSITIVE_NUMBER)
    private Long comityPositiveNumber;

    /**
     * 团体预约负责人名称
     */
    @Field(COMITY_PRINCIPAL_NAME)
    private String comityPrincipalName;

    /**
     * 团体预约负责人联系方式
     */
    @Field(COMITY_PRINCIPAL_PHONE_NUMBER)
    private String comityPrincipalPhoneNumber;

    /**
     * 团体预约类型，1：常规；2：应急
     */
    @Field(COMITY_TYPE)
    private Integer comityType;

    /**
     * 采样点id
     */
    @Field(SAM_ID)
    private String samId;
}
