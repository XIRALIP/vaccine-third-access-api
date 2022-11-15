package com.soundai.nat.institution.admin.module.resident.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.module.common.domain.NatResident;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.CheckPointModule.SEX;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.EmergencyModule.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.EmergencyModule.COMMUNITY_NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NAME;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.TELPHONE;

/**
 * @author liujiahe
 * @description: 采样单位居民信息表
 * @date 2020/11/24 14:17
 */

@Data
public class NatResidentResponseVO {

    private String id;

    private String name;
    /**
     * 联系方式
     */
    private String telphone;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号码
     */
    private String cardNumber;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 居住地所属社区
     */
    private String communityName;

    private String callResult;

    /**
     * 居民采样次数
     */
    private Integer samplingNum;
    /**
     * 完成检测次数
     */
    private Integer completeDetectNum;
    /**
     * 最近一次检测结果
     */
    private Integer lastTestResult;
    private String lastTestResultName;
    /**
     * 最近一次采样时间
     */
    private String lastSamplingTime;
    /**
     * 最近一次检测完成时间
     */
    private String lastTestCompletedTime;
    /**
     * 当前检测状态
     */
    private Integer currentDetectionStatus;
    private String currentDetectionStatusName;
}
