package com.soundai.nat.institution.admin.module.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_RESIDENT;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.CheckPointModule.SEX;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.EmergencyModule.ADDRESS;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.EmergencyModule.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.InstModule.INST_ID;

/**
 * @author liujiahe
 * @description: 采样单位居民信息表
 * @date 2020/11/24 14:17
 */

@Data
@Document(collection = NAT_RESIDENT)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class NatResident extends BaseEntity {

    /**
     * 居民ID
     */
    @Indexed(unique = true)
    @Field(ID)
    private String id;

    /**
     * 采样单位ID
     */
    @Field(INST_ID)
    private String instId;

    /**
     * 姓名
     */
    @Field(NAME)
    @Excel(name = "姓名(必填)")
    private String name;

    @Field(SEX)
    private Integer sex;
    /**
     * 联系方式
     */
    @Field(TELPHONE)
    @Excel(name = "联系方式(必填)")
    private String telphone;

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
     * 居住地址
     */
    @Field(ADDRESS)
    @Excel(name = "居住地址(必填)")
    private String address;

    /**
     * 居住地所属社区
     */
    @Field(COMMUNITY_NAME)
    private String communityName;

    /**
     * 居住地所属社区code
     */
    @Field(COMMUNITY_CODE)
    private String communityCode;

    @Field(LAST_CALL_TIME)
    private String lastCallTime;

    @Field(LAST_CALL_STATUS)
    @Excel(name = "是否接听")
    private String callResult;

    @Field(AREA_CODE)
    private String areaCode;

    @Excel(name = "居住地区(必填)")
    private String area;

    /**
     * 居民采样次数
     */
    @Field(SAMPLING_NUM)
    private Integer samplingNum;
    /**
     * 完成检测次数
     */
    @Field(COMPLETE_DETECT_NUM)
    private Integer completeDetectNum;
    /**
     * 最近一次检测结果
     */
    @Field(LAST_TEST_RESULT)
    private Integer lastTestResult;
    /**
     * 最近一次采样时间
     */
    @Field(LAST_SAMPLING_TIME)
    private String lastSamplingTime;
    /**
     * 最近一次检测完成时间
     */
    @Field(LAST_TEST_COMPLETED_TIME)
    private String lastTestCompletedTime;
    /**
     * 当前检测状态
     */
    @Field(CURRENT_DETECTION_STATUS)
    private Integer currentDetectionStatus;

}
