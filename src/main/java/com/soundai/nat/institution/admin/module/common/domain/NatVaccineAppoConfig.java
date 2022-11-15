package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineAppoConfig.*;

/**
 * @author Jefferson Li
 * @title NatVaccineAppoConfig
 * @description 疫苗接种预约号源配置类
 * @date 2021/2/25 18:57
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = CollectionNameConstant.NAT_VACCINE_APPO_CONFIG)
public class NatVaccineAppoConfig {

    @Indexed(unique = true)
    @Field(ID)
    private String id;
    @Field(INST_ID)
    private String instId;
    @Field(VACCINE_POINT_ID)
    private String vaccinePointId;
    @Field(DATE)
    private String date;
    @Field(AM_START_TIME)
    private String amStartTime;
    @Field(AM_END_TIME)
    private String amEndTime;
    @Field(PM_START_TIME)
    private String pmStartTime;
    @Field(PM_END_TIME)
    private String pmEndTime;
    @Field(AM_APPO_QUOTA)
    private Long amAppoQuota;
    @Field(PM_APPO_QUOTA)
    private Long pmAppoQuota;
    @Field(AM_TIME_INTERVAL)
    private String amTimeInterval;
    @Field(PM_TIME_INTERVAL)
    private String pmTimeInterval;
    @Field(APPO_QUOTA)
    private Long appoQuota;
    @Field(APPO_FLAG)
    private Integer appoFlag;
    @Field(CREATE_TIME)
    private String createTime;
    @Field(MODIFY_TIME)
    private String modifyTime;
    private Long appoAm; // 上午预约数
    private Long appoPm; // 下午预约数
}
