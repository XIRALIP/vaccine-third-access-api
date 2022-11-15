package com.soundai.nat.institution.admin.module.common.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_INSTITUTION;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.InstModule.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;

/**
 * @author linziheng
 * @description: 机构信息表
 * @date 2020年11月16日 12:00:44
 */
@Data
@Document(collection = NAT_INSTITUTION)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InstitutionInfo extends BaseEntity {

    //机构ID
    @Indexed(unique = true)
    @Field(ID)
    private String id;

    //机构代码
    @Field(INST_CODE)
    private String instCode;

    //机构名称
    @Field(INST_NAME)
    private String instName;

    //机构类别
    @Field(INST_TYPE)
    private String instType;

    //服务时间
    @Field(SERVICE_TIME)
    private String serviceTime;

    //配额时间单位(默认是天),枚举
    @Field(UNIT_OF_QUOTA_TIME)
    private String unitOfQuotaTime;

    //最低配额(机构每天的检测数低于这个配额就法熔断消息)
    @Field(MIN_CHECK_NUM)
    private long minCheckNum;

    //最高配额(机构所有采样点设置的预约数大于这个就提示不给保存)
    @Field(MAX_CHECK_NUM)
    private long maxCheckNum;

    //最大检测能力
    @Field(MAX_CHECK_ABILITY)
    private long maxCheckAbility;

    //省份(和系统管理创建的第一级用户组一致)
    @Field(PROVINCE)
    private String province;

    //市(和系统管理创建的第二级用户组一致)
    @Field(CITY)
    private String city;

    //区/县(和系统管理创建的第三级用户组一致)
    @Field(AREA)
    private String area;

    //所属街道区划代码
    @Field(SUBDISTRICT_CODE)
    private String subdistrictCode;

    @Field(SUBDISTRICT_NAME)
    private String subdistrictName;

    //详细地址
    @Field(ADDRESS)
    private String address;

    //机构级别（枚举）
    @Field(LEVEL)
    private String level;

    //联系人
    @Field(CONTACTER)
    private String contacter;

    //手机号码
    @Field(PHONE)
    private String phone;

    //座机号码
    @Field(TEL_NUM)
    private String telNum;

    //邮箱
    @Field(EMAIL)
    private String email;

    //传真
    @Field(FAX)
    private String fax;

    //网址
    @Field(WEBSITE)
    private String website;

    //机构总人数
    @Field(INST_PEOPLE_NUM)
    private Integer instPeopleNum;

    //采样人员数
    @Field(SAM_PEOPLE_NUM)
    private Integer samPeopleNum;

    //检测人员数
    @Field(CHECK_PEOPLE_NUM)
    private Integer checkPeopleNum;

    //机构场地总面积
    @Field(INST_TOTAL_AREA)
    private float instTotalArea;

    //实验用房面积
    @Field(EXP_HOUSE_AREA)
    private float expHouseArea;

    //实验配套用房面积
    @Field(EXP_MATCH_HOUSE_AREA)
    private float expMatchHouseArea;

    //核算提取仪数量
    @Field(NUC_DEV_NUM)
    private Integer nucDevNum;

    //医用PCR扩充仪数量
    @Field(PCR_DEV_NUM)
    private Integer pcrDevNum;

    //离心机数量
    @Field(CEN_DEV_NUM)
    private Integer cenDevNum;

    //生物安全柜数量
    @Field(SAFETY_CABINET_NUM)
    private Integer safetyCabinetNum;

    //病毒灭活设备数量
    @Field(INA_DEV_NUM)
    private Integer inaDevNum;

    //机构管理员账号id
    @Field(INST_ADMIN_USER_ID)
    private String instAdminUserId;

    //状态（启用，禁用）(禁用后政府端该机构所有操作权限禁用,机构端采样点的创建和修改不可点击)
    @Field(STATUS)
    private Integer status;

    //经度
    @Field(LONGITUDE)
    private Double longitude;

    //纬度
    @Field(LATITUDE)
    private Double latitude;

    //采样点数(增减采样点时同步更新该字段)
    @Field(SAM_NUM)
    private Integer samNum;

    //检测点数(增减检验点时同步更新该字段)
    @Field(CHECK_NUM)
    private Integer checkNum;

    //昨日预约数(每天0天定时计算前一天的数据更新该字段)
    @Field(YEST_APPO_NUM)
    private Integer yestAppoNum;

    //昨日采样数(每天0天定时计算前一天的数据更新该字段)
    @Field(YEST_SAM_NUM)
    private Integer yestSamNum;

    //昨日检验数(每天0天定时计算前一天的数据更新该字段)
    @Field(YEST_CHECK_NUM)
    private Integer yestCheckNum;

    //用户组ID
    @Field(USER_GROUP_ID)
    private String userGroupId;

    //机构统一码
    @Field(INST_NUMBER)
    private String instNumber;

    //机构统一码最大码
    @Field(MAX_INST_NUMBER)
    private String maxInstNumber;

    @Transient
    private String instId;

}
