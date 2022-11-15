package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_TASK_INFO;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatTaskInfo.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.STATUS;

@Data
@Document(collection = NAT_TASK_INFO)
public class NatTaskInfo extends BaseEntity {

    @Field(ID)
    private String id;  //id
    @Field(TASK_TYPE)
    private Integer taskType;// 0:机构；1：政府采样数据tab 2：政府检测数据tab 3、机构疫苗
    @Field(TASK_NAME)
    private String taskName;//任务名称
    @Field(TASK_GROUP_ID)
    private String taskGroupId;//任务所属组织id
    @Field(TASK_SCOPE)
    private Integer taskScope;//任务维度（0：采样点；1：应急采样组织）<政府用，机构默认0>
    @Field(SAM_START_TIME)
    private String samStartTime;//采样开始时间
    @Field(SAM_END_TIME)
    private String samEndTime;//采样结束时间
    @Field(TASK_DATA_NUMBER)
    private Integer taskDataNumber;//采样点数<机构用 必填>
    @Field(TASK_DATA_IDS)
    private List<String> taskDataIds;//采样点ids/采样单位ids
    @Field(STATUS)
    private Integer status;//运行状态：0：已创建；1：运行中；2：运行成功；3：运行失败
    @Field(FAIL_COUNT)
    private Integer failCount;//失败次数 defalut：0
    @Field(ALERT)
    private Boolean alert;//是否告警 default：false
    @Field(TASK_START_TIME)
    private String taskStartTime; //任务开始执行时间
    @Field(TASK_FINISH_TIME)
    private String taskFinishTime;//任务完成时间==计算完成时间



}
