package com.soundai.nat.institution.admin.module.common.domain;

import com.soundai.nat.institution.admin.framework.aspectj.lang.annotation.Excel;
import com.soundai.nat.institution.admin.framework.web.domain.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_DATA_TASK_INFO;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.ID;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatDataTaskInfo.*;


@Data
@Accessors(chain = true)
@Document(collection = NAT_DATA_TASK_INFO)
public class NatDataTaskInfo extends BaseEntity {

    @Field(ID)
    private String id;  //id
    @Field(TASK_ID)
    private String taskId;  //任务id
    @Field(PROVINCE)
    private String province;  //省
    @Field(CITY)
    private String city;  //市
    @Field(AREA)
    private String area;  //区
    @Field(SAMP_ID)
    private String sampId;  //采样点id
    @Excel(name = "采样点",sort = 1)
    @Field(SAMP_NAME)
    private String sampName;  //采样点名称
    @Field(INST_ID)
    private String instId;  //应急采样组织id
    @Field(INST_NAME)
    private String instName;  //应急采样组织name
    @Excel(name = "采样试管数",sort = 2)
    @Field(TUBE_TOTAL_NUMBER)
    private Integer tubeTotalNumber;  //采样试管总数
    @Excel(name = "其中待检测试管数",sort = 4)
    @Field(TUBE_TO_CHECK_NUMBER)
    private Integer tubeToCheckNumber;  //待检测试管数（tube表status：1 abnormal_sign！=1 ）
    @Excel(name = "其中检测中试管数",sort = 5)
    @Field(TUBE_CHECKING_NUMBER)
    private Integer tubeCheckingNumber;  //检测中试管数 （tube表status：！=1 && ！=5 abnormal_sign！=1 ）
    @Excel(name = "其中检测完成试管数",sort = 6)
    @Field(TUBE_CHECKED_NUMBER)
    private Integer tuberCheckedNumber;  //检测完成试管数（tube表status：5  abnormal_sign！=1）
    @Excel(name = "其中作废试管数",sort = 3)
    @Field(TUBE_ABNORMAL_NUMBER)
    private Integer tubeAbnormalNumber;  //作废试管数（tube表 abnormal_sign：1）
    @Excel(name = "采样人次",sort = 7)
    @Field(PERSON_TOTAL_NUMBER)
    private Integer personTotalNumber;  //采样总人次 (releation表status：!1 !4 !5)
    @Excel(name = "其中待检测人次",sort = 8)
    @Field(PERSON_TO_CHECK_NUMBER)
    private Integer personToCheckNumber;  //待检测人次（releation表status：7 abnormal_sign！=1）
    @Excel(name = "其中检测中人次",sort = 9)
    @Field(PERSON_CHECKING_NUMBER)
    private Integer personCheckingNumber;  //检测中人次（releation表status：2||3 abnormal_sign！=1）
    @Excel(name = "其中检测完成人次",sort = 10)
    @Field(PERSON_CHECKED_NUMBER)
    private Integer personCheckedNumber;  //检测完成人次（releation表status：6  abnormal_sign！=1）
    @Excel(name = "其中阴性人次",sort = 11)
    @Field(PERSON_NEGATIVE_NUMBER)
    private Integer personNegativeNumber;  //阴性人次（releation表status：6 checkreusult 0  abnormal_sign！=1）
    @Excel(name = "其中阳性人次",sort = 12)
    @Field(PERSON_POSITIVE_NUMBER)
    private Integer personPositiveNumber;  //阳性人次（releation表status：6 checkreusult 1  abnormal_sign！=1）
    @Excel(name = "其中复检人次",sort = 13)
    @Field(PERSON_RECHECK_NUMBER)
    private Integer personRecheckNumber;  //复检人次（releation表status：6 checkreusult 3  abnormal_sign！=1）
    @Excel(name = "其中标记作废人次",sort = 14)
    @Field(PERSON_ABNORMAL_NUMBER)
    private Integer personAbnormalNumber;  //标记作废人次（releation表status：!1 !4 !5 releation表abnormal_sign：1）

}
