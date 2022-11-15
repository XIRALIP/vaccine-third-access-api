package com.soundai.nat.institution.admin.module.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_APPO_CHECK;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatAppoCheck.*;
import static com.soundai.nat.institution.admin.module.common.domain.NatInstSamplePoint.ID;

/**
 * @Author: changjiarui
 * @description: 预约检验表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = NAT_APPO_CHECK)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NatAppoCheck extends BaseEntity {

    @Excel(name = "序号")
    private Integer exportSequence;

    @Indexed(unique = true)
    @Field(ID)
    @Excel(name = "预约ID")
    private String id; // uuid(按照时间戳生成的uuid)

    @Excel(name = "检测机构名称")
    private String instName;

    @Field(APPO_DATE)
    @Excel(name = "预约日期")
    private String appoDate; // 预约日期(2020-11-11)

    @Field(APPO_PERIOD)
    @Excel(name = "预约时间（时间段）")
    private String appoPeriod; // 预约时间段(10:00-11:00)

    @Field(APPO_PERSON)
    private String appoPerson; // 预约人信息码（个人信息码）

    @Field(CHECKED_PERSON)
    private String checkedPerson; // 受检人信息码（个人信息码）

    @Field(CHECKED_PERSON_NAME)
    @Excel(name = "姓名(必填)")
    private String checkedPersonName; // 受检人姓名

    @Excel(name = "性别")
    private String sex;

    @Field(CARD_NUMBER_TYPE)
    @Excel(name = "证件类型(必填)")
    private String cardNumberType;  // 受检人证件类型

    @Field(CHECKED_PERSON_CARD_NUMBER)
    @Excel(name = "证件号码(必填)")
    private String checkedPersonCardNumber; // 受检人证件号码

    @Excel(name = "门科诊室")
    private String clinic;

    @Excel(name = "检查科目")
    private String checkItem;

    @Field(CHECKED_PERSON_TELEPHONE)
    @Excel(name = "联系方式")
    private String checkedPersonTelephone; // 受检人联系方式

    @Field(CHECKED_PERSON_LIVE_ADDRESS)
    @Excel(name = "居住地区(必填)")
    @JsonIgnore
    private String checkedPersonLiveAddress; // 居住地

    @Field(CHECKED_PERSON_DETAIL_ADDRESS)
    @Excel(name = "居住地址(必填)")
    @JsonIgnore
    private String checkedPersonDetailAddress; // 详细地址

    @Field(COMMUNITY_CODE)
    private String communityCode; // 受检人居住地所属社区代码

    @Field(STATUS)
    private Integer status; // 预约单状态（1已预约，2检测中，3已检测，4已取消，5已过期, 6检测完成, 7已采样）

    @Field(CHECK_RESULT)
    private Integer checkResult; //检测结果

    @Field(CHECK_RESULT_TIME)
    private String checkResultTime; // 检测结果时间

    @Field(TUBE_ID)
    private String tubeId; // 试管码id

    @Field(TUBE_CODE)
    private String tubeCode; // 试管码

    @Field(SAM_TIME)
    private String samTime; // 采样时间

    @Field(APPO_TYPE)
    private Integer appoType;  // 预约类型

    @Field(INST_ID)
    private String instId; // 机构id(需要的机构名称可以从redis里取)

    @Field(SAM_ID)
    private String samId; // 采样点id(需要的采样点名称可以区redis里取)

    @Field(NEED_REPORT)
    private Integer needReport; // 是否开具报告（0否，1是）

    @Field(INST_ID_OLD)
    private String instIdOld; // 原预约时采样点id所属的组织id

    @Field(SAM_ID_OLD)
    private String samIdOld; // 采样点id(需要的采样点名称可以区redis里取)

    @Field(COMITY_ID)
    private String comityId; // 团体预约id

    @Field(AUDIT_TIME)
    private String auditTime;

    @Transient
    private String samplePointName;//采样点名称

    @Field(ABNORMAL_SIGN)
    private Integer abnormalSign; // 异常标记（0非异常，1异常）

    @Transient
    private Integer row;

}
