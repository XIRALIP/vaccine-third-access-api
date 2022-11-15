package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_VACCINE_DATA_TASK_INFO;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineDataTaskInfo.*;

/**
 * @Author: changjiarui
 * @description: 疫苗数据统计表
 */
@Data
@Accessors(chain = true)
@Document(collection = NAT_VACCINE_DATA_TASK_INFO)
public class NatVaccineDataTaskInfo extends BaseEntity {

    @Field(ID)
    private String id;  // id

    @Field(INST_ID)
    private String instId;  // 所属组织id(接种单位id)

    @Field(TASK_ID)
    private String taskId;  // 任务id

    @Field(VACCINE_INST_ID)
    private String vaccineInstId;  // 接种点Id

    @Excel(name = "接种点名称",sort = 1)
    @Field(VACCINE_INST_NAME)
    private String vaccineInstName;  // 接种点名称

    @Excel(name = "第一次接种预约接种人数",sort = 2)
    @Field(APPO_FIRST_VACCINE_NUM)
    private Integer appoFirstVaccineNum;  // 第一次接种预约接种人数

    @Excel(name = "签到第一次接种人数",sort = 3)
    @Field(SIGIN_FIRST_VACCINE_NUM)
    private Integer siginFirstVaccineNum;  // 签到第一次接种人数

    @Excel(name = "完成第一次接种人数",sort = 4)
    @Field(FINISH_FIRST_VACCINE_NUM)
    private Integer finishFirstVaccineNum;  // 完成第一次接种人数

    @Excel(name = "未完成第一次接种人数",sort = 5)
    @Field(UNFINISH_FIRST_VACCINE_NUM)
    private Integer unfinishFirstVaccineNum;  // 未完成第一次接种人数

    @Excel(name = "第二次接种预约接种人数",sort = 6)
    @Field(APPO_SECOND_VACCINE_NUM)
    private Integer appoSecondVaccineNum;  // 第二次接种预约接种人数

    @Excel(name = "签到第二次接种人数",sort = 7)
    @Field(SIGIN_SECOND_VACCINE_NUM)
    private Integer siginSecondVaccineNum;  // 签到第二次接种人数

    @Excel(name = "完成第二次接种人数",sort = 8)
    @Field(FINISH_SECOND_VACCINE_NUM)
    private Integer finishSecondVaccineNum;  // 完成第二次接种人数

    @Excel(name = "未完成第二次接种人数",sort = 9)
    @Field(UNFINISH_SECOND_VACCINE_NUM)
    private Integer unfinishSecondVaccineNum;  // 未完成第二次接种人数

}
