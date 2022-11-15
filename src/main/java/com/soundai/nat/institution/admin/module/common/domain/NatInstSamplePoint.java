package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @title: NatInstSamplePoint
 * @author: Jefferson Li
 * @date: 2020/11/16 19:47
 * @description: 采样点数据表
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "nat_inst_sample_point")
public class NatInstSamplePoint extends BaseEntity {
    private static final long serialVersionUID = 7030012767335920536L;

    public static final String COLLECTION_NAME = "nat_inst_sample_point";

    public static final String SAMPLE_POINT_NAME = "sample_point_name";
    public static final String ID = "id";
    public static final String STATUS = "status";
    public static final String INST_ID = "inst_id";
    public static final String AM_START_TIME = "am_start_time";
    public static final String AM_END_TIME = "am_end_time";
    public static final String PM_START_TIME = "pm_start_time";
    public static final String PM_END_TIME = "pm_end_time";
    public static final String WORK_DAYS = "work_days";
    public static final String APPO_QUOTA = "appo_quota";
    public static final String SAMPLE_POINT_TYPE = "sample_point_type";
    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String AREA = "area";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String ADDRESS = "address";
    public static final String FAX = "fax";
    public static final String PHONE = "phone";
    public static final String TEL_NUM = "tel_num";
    public static final String EMAIL = "email";
    public static final String LONGITUDE = "longitude";
    public static final String LATITUDE = "latitude";
    public static final String YEST_APPO_NUM = "yest_appo_num";
    public static final String YEST_SAM_NUM = "yest_sam_num";
    public static final String APPO_INTERVAL = "appo_interval";

    public static final String SUBDISTRICT_CODE = "subdistrict_code";
    public static final String SUBDISTRICT_NAME = "subdistrict_name";
    public static final String VISIABLE = "visiable";
    public static final String COMMUNITY_CODE = "community_code";
    public static final String COMMUNITY_NAME = "community_name";
    public static final String AREA_CODE = "area_code";

    @Indexed(unique = true)
    @Field("id")
    private String id;            //id
    @Field(INST_ID)
    private String instId;        //机构id
    @Field(SAMPLE_POINT_NAME)
    private String samplePointName;//采样点名称
    @Field("province")
    private String province;      //省份
    @Field("city")
    private String city;         //市
    @Field("area")
    private String area;          //区/县
    @Field("address")
    private String address;       //详细地址
    @Field("fax")
    private String fax;           //传真
    @Field("phone")
    private String phone;         //手机号码
    @Field("tel_num")
    private String telNum;        //座机号
    @Field("email")
    private String email;         //邮箱
    @Field("am_start_time")
    private String amStartTime;     //上午开始时间(08:30)
    @Field("am_end_time")
    private String amEndTime;       //上午结束时间(11:30)
    @Field("pm_start_time")
    private String pmStartTime;     //下午开始时间(13:30)
    @Field("pm_end_time")
    private String pmEndTime;       //下午结束时间(19:30)
    @Field("work_days")
    private List<String> workDays; //周工作日(["1","2","3","4","5","6","7"])
    @Field("appo_quota")
    private Integer appoQuota;     //预约额度
    @Field("status")
    private Integer status;       //状态（0启用，1禁用，2隐藏）该采样点的所有操作被禁用
    @Field("longitude")
    private Double longitude;     //经度
    @Field("latitude")
    private Double latitude;      //纬度
    @Field("yest_appo_num")
    private Long yestAppoNum;     //昨日预约数(每天0天定时计算前一天的数据更新该字段)
    @Field("yest_sam_num")
    private Long yestSamNum;      //昨日采样数(每天0天定时计算前一天的数据更新该字段)
    @Field("sample_point_type")
    private Integer samplePointType; // 采样点类型，1：日常采样点，2：应急采样点 3：外采采样点
    @Field("appo_interval")
    private String appoInterval;  // 预约时间间隔
    @Field("start_date")
    private String startDate;     // 起始日期（yyyy-MM-dd，大规模采样点必填）
    @Field("end_date")
    private String endDate;       // 结束日期（yyyy-MM-dd，大规模采样点必填）
    @Field(SUBDISTRICT_CODE)
    private String subdistrictCode; // 所属街道区划代码
    @Field(SUBDISTRICT_NAME)
    private String subdistrictName; // 所属街道区划名称
    @Field(VISIABLE)
    private Integer visiable; // 该采样点是否可见，0：可见；1：不可见，虚拟采样点不可见，创建团体预约时生成的采样点，v2.0 新增
    @Field(COMMUNITY_CODE)
    private String communityCode; // 社区码，v2.1 新增
    @Field(COMMUNITY_NAME)
    private String communityName; // 社区名称 ，v2.1 新增
    @Field(AREA_CODE)
    private String areaCode; // 地区编码
}
