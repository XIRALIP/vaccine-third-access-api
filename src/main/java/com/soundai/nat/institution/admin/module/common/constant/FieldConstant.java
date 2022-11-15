package com.soundai.nat.institution.admin.module.common.constant;

import javax.swing.plaf.PanelUI;

/**
 * @author liujiahe
 * @description: 数据库字段名常量
 * @date 2020/12/10 2:29
 */
public class FieldConstant {

    /**
     * 公共字段
     */
    public static final String ID = "id";
    public static final String CODE = "code";
    public static final String NAME = "name";
    public static final String PROVINCE = "province";
    public static final String CITY = "city";
    public static final String AREA = "area";
    public static final String ADDRESS = "address";
    public static final String TYPE = "type";
    public static final String TELPHONE = "telphone";
    public static final String BATCH = "batch";
    public static final String STATUS = "status";
    //检测状态为检测完成
    public static final Integer FINISH = 6;
    public static final Integer HAS_APPO = 1;

    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 查询条件常量
     */
    public static final String CHECK_POINT_ID_PARAM = "checkPointId";
    public static final String CHECK_POINT_NAME_PARAM = "checkPointName";

    public class NatCheckedPerson{
        public static final String OPEN_ID = "open_id";

        public static final String PERSON_NAME = "person_name";

        public static final String CARD_TYPE = "card_type";

        public static final String IS_CHECKED = "is_checked";

        public static final String CARD_NUMBER = "card_number";
        public static final String SHARD_ID = "shard_id";

        public static final String TELEPHONE = "telephone";

        public static final String ADDRESS = "address";

        public static final String PERSON_TYPE = "person_type";

        public static final String CREATE_TIME = "create_time";

        public static final String UPDATE_TIME = "update_time";
        public static final String PERSON_CLASSIFICATION = "person_classification";
        public static final String PERSON_CLASSIFICATION_CODE = "person_classification_code";
        public static final String COMPANY = "company";
        public static final String CITY_CODE = "city_code";
        public static final String CITY_NAME = "city_name";
        public static final String AREA_CODE = "area_code";
        public static final String AREA_NAME = "area_name";
        public static final String CAREER_CODE = "career_code";
        public static final String ORIGIN_PROVINCECODE = "origin_provincecode";
        public static final String ORIGIN_PROVINCENAME = "origin_provincename";
        public static final String ORIGIN_CITY_CODE = "origin_city_code";
        public static final String ORIGIN_CITY_NAME = "origin_city_name";
        public static final String ORIGIN_AREA_CODE = "origin_area_code";
        public static final String ORIGIN_AREANAME = "origin_areaname";
        public static final String ORIGIN_ADDRESS = "origin_address";
        public static final String PROVINC_ECODE = "provinc_ecode";
        public static final String PROVINCE_NAME = "province_name";
        public static final String GENDER = "gender";
        public static final String BIRTHDAY = "birthday";
        public static final String CAREER = "career";
    }
    /**
     * 采样点模块
     */
    public class SamplePointModule {

        //采样点名称
        public static final String SAMPLE_POINT_NAME = "samplePointName";

    }


    /**
     * 机构模块
     */
    public class InstModule {
        public static final String INST_CODE = "inst_code";
        public static final String INST_NAME = "inst_name";
        public static final String INST_TYPE = "inst_type";
        public static final String SERVICE_TIME = "service_time";
        public static final String UNIT_OF_QUOTA_TIME = "unit_of_quota_time";
        public static final String MIN_CHECK_NUM = "min_check_num";
        public static final String MAX_CHECK_NUM = "max_check_num";
        public static final String MAX_CHECK_ABILITY = "max_check_ability";
        public static final String PROVINCE = "province";
        public static final String CITY = "city";
        public static final String AREA = "area";
        public static final String ADDRESS = "address";
        public static final String LEVEL = "level";
        public static final String CONTACTER = "contacter";
        public static final String PHONE = "phone";
        public static final String TEL_NUM = "tel_num";
        public static final String EMAIL = "email";
        public static final String FAX = "fax";
        public static final String WEBSITE = "website";
        public static final String INST_PEOPLE_NUM = "inst_people_num";
        public static final String SAM_PEOPLE_NUM = "sam_people_num";
        public static final String CHECK_PEOPLE_NUM = "check_people_num";
        public static final String INST_TOTAL_AREA = "inst_total_area";
        public static final String EXP_HOUSE_AREA = "exp_house_area";
        public static final String EXP_MATCH_HOUSE_AREA = "exp_match_house_area";
        public static final String NUC_DEV_NUM = "nuc_dev_num";
        public static final String PCR_DEV_NUM = "pcr_dev_num";
        public static final String CEN_DEV_NUM = "cen_dev_num";
        public static final String SAFETY_CABINET_NUM = "safety_cabinet_num";
        public static final String INA_DEV_NUM = "ina_dev_num";
        public static final String INST_ADMIN_USER_ID = "inst_admin_user_id";
        public static final String STATUS = "status";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String SAM_NUM = "sam_num";
        public static final String CHECK_NUM = "check_num";
        public static final String YEST_APPO_NUM = "yest_appo_num";
        public static final String YEST_SAM_NUM = "yest_sam_num";
        public static final String YEST_CHECK_NUM = "yest_check_num";
        public static final String CREATE_TIME = "create_time";
        public static final String MODIFY_TIME = "modify_time";
        public static final String USER_GROUP_ID = "user_group_id";
        public static final String INST_NUMBER = "inst_number";
        public static final String MAX_INST_NUMBER = "max_inst_number";
        public static final String SUBDISTRICT_CODE = "subdistrict_code";
        public static final String SUBDISTRICT_NAME = "subdistrict_name";
        public static final String INST_ID = "inst_id";
        public static final String REDIS_INST_NAME = "instName";
        public static final String REDIS_SAMPLE_POINT_TYPE = "samplePointType";
        public static final String REDIS_USER_GROUP_ID = "userGroupId";
    }

    /**
     * 检测点管理 模块
     */
    public class CheckPointModule {
        public static final String CHECK_POINT_NAME = "check_point_name";
        public static final String FAX = "fax";
        public static final String PHONE = "phone";
        public static final String TEL_NUMBER = "tel_number";
        public static final String EMAIL = "email";
        public static final String MAX_CHECK_ABILITY = "max_check_ability";
        public static final String SERVICE_TIME = "service_time";
        public static final String STATUS = "status";
        public static final String LONGITUDE = "longitude";
        public static final String LATITUDE = "latitude";
        public static final String YEST_CHECK_NUM = "yest_check_num";
        public static final String SEX = "sex";
        public static final String AGE = "age";
        public static final String UNIVERSITY = "university";
        public static final String MAJOR = "major";
        public static final String CARD_NUMBER = "card_number";
        public static final String CARD_TYPE = "card_type";
        public static final String POLITIC = "politic";
        public static final String EDU = "edu";
        public static final String NATION = "nation";
        public static final String BIRTHDATE = "birthdate";

    }

    /**
     * 设备模块
     */
    public class DeviceModule {
        public static final String BIND_POINT_ID = "bind_point_id";
        public static final String BIND_POINT_NAME = "bind_point_name";
        public static final String INST_ID = "inst_id";
        public static final String INST_NAME = "inst_name";
        public static final String OWNER = "owner";
        public static final String OWNER_TELPHONE = "owner_telphone";
        public static final String VERSION = "version";
        public static final String OPERATE_TYPE = "operate_type";
        public static final String IMSI = "imsi";
        public static final String BIND_TYPE = "bind_type";

    }

    /**
     * 应急采样
     */
    public class EmergencyModule {
        public static final String CARD_TYPE = "card_type";
        public static final String CARD_NUMBER = "card_number";
        public static final String ADDRESS = "address";
        public static final String COMMUNITY_NAME = "community_name";
        public static final String COMMUNITY_CODE = "community_code";
        public static final String LAST_CALL_TIME = "last_call_time";
        public static final String LAST_CALL_STATUS = "last_call_status";
        public static final String AREA_CODE = "area_code";
        public static final String APPO_RESULT = "appo_result";
        public static final String CHECKED_PERSON_CARD_NAME = "checked_person_card_number";
        public static final String SAMPLING_NUM = "sampling_num";
        public static final String COMPLETE_DETECT_NUM = "complete_detect_num";
        public static final String LAST_TEST_RESULT = "last_test_result";
        public static final String LAST_SAMPLING_TIME = "last_sampling_time";
        public static final String LAST_TEST_COMPLETED_TIME = "last_test_completed_time";
        public static final String CURRENT_DETECTION_STATUS = "current_detection_status";
    }

    public class NatAppoCheck {
        public static final String CHECKED_PERSON_NAME = "checked_person_name";
        public static final String COMMUNITY_CODE = "community_code";
        public static final String CHECKED_PERSON_TELEPHONE = "checked_person_telephone";
        public static final String TUBE_ID = "tube_id";
        public static final String TUBE_CODE = "tube_code";
        public static final String CHECK_RESULT = "check_result";
        public static final String NEED_REPORT = "need_report";
        public static final String INST_ID = "inst_id";
        public static final String CHECKED_PERSON_LIVE_ADDRESS = "checked_person_live_address";
        public static final String APPO_DATE = "appo_date";
        public static final String APPO_PERIOD = "appo_period";
        public static final String CHECKED_PERSON = "checked_person";
        public static final String CARD_NUMBER_TYPE = "card_number_type";
        public static final String CARD_NUMBER = "card_number";
        public static final String CHECKED_PERSON_CARD_NUMBER = "checked_person_card_number";
        public static final String CHECKED_PERSON_DETAIL_ADDRESS = "checked_person_detail_address";
        public static final String STATUS = "status";
        public static final String APPO_TYPE = "appo_type";
        public static final String SAM_TIME = "sam_time";
        public static final String PROVINCE = "province";
        public static final String CITY = "city";
        public static final String AREA = "area";
        public static final String CHECK_RESULT_TIME = "check_result_time";
        public static final String REPORT_PATH = "report_path";
        public static final String APPO_PERSON = "appo_person";
        public static final String SAM_ID = "sam_id";
        public static final String REPORT_NAME = "report_name";
        public static final String INST_ID_OLD = "inst_id_old";
        public static final String SAM_ID_OLD = "sam_id_old";
        public static final String COMITY_ID = "comity_id";
        public static final String AUDIT_TIME = "audit_time";
        public static final String ABNORMAL_SIGN = "abnormal_sign";
    }

    public class NatTaskInfo{
        public static final String TASK_TYPE = "task_type";
        public static final String TASK_NAME = "task_name";
        public static final String TASK_GROUP_ID = "task_group_id";
        public static final String TASK_SCOPE = "task_scope";
        public static final String SAM_START_TIME = "sam_start_time";
        public static final String SAM_END_TIME = "sam_end_time";
        public static final String TASK_DATA_NUMBER = "task_data_number";
        public static final String TASK_DATA_IDS = "task_data_ids";
        public static final String FAIL_COUNT = "fail_count";
        public static final String ALERT = "alert";
        public static final String TASK_START_TIME = "task_start_time";
        public static final String TASK_FINISH_TIME = "task_finish_time";
    }

    public class NatDataTaskInfo{
        public static final String TASK_ID = "task_id";
        public static final String PROVINCE = "province";
        public static final String CITY = "city";
        public static final String AREA = "area";
        public static final String SAMP_ID = "samp_id";
        public static final String SAMP_NAME = "samp_name";
        public static final String INST_ID = "inst_id";
        public static final String INST_NAME = "inst_name";
        public static final String TUBE_TOTAL_NUMBER = "tube_total_number";
        public static final String TUBE_TO_CHECK_NUMBER = "tube_to_check_number";
        public static final String TUBE_CHECKING_NUMBER = "tube_checking_number";
        public static final String TUBE_CHECKED_NUMBER = "tube_checked_number";

        public static final String TUBE_ABNORMAL_NUMBER = "tube_abnormal_number";
        public static final String PERSON_TOTAL_NUMBER = "person_total_number";
        public static final String PERSON_TO_CHECK_NUMBER = "person_to_check_number";
        public static final String PERSON_CHECKING_NUMBER = "person_checking_number";
        public static final String PERSON_CHECKED_NUMBER = "person_checked_number";
        public static final String PERSON_NEGATIVE_NUMBER = "person_negative_number";

        public static final String PERSON_POSITIVE_NUMBER = "person_positive_number";
        public static final String PERSON_RECHECK_NUMBER = "person_recheck_number";
        public static final String PERSON_ABNORMAL_NUMBER = "person_abnormal_number";

    }

    public class NatVaccineDataTaskInfo{
        public static final String INST_ID = "inst_id";
        public static final String TASK_ID = "task_id";
        public static final String VACCINE_INST_ID = "vaccine_inst_id";
        public static final String VACCINE_INST_NAME = "vaccine_inst_name";
        public static final String APPO_FIRST_VACCINE_NUM = "appo_first_vaccine_num";
        public static final String SIGIN_FIRST_VACCINE_NUM = "sigin_first_vaccine_num";
        public static final String FINISH_FIRST_VACCINE_NUM = "finish_first_vaccine_num";
        public static final String UNFINISH_FIRST_VACCINE_NUM = "unfinish_first_vaccine_num";
        public static final String APPO_SECOND_VACCINE_NUM = "appo_second_vaccine_num";
        public static final String SIGIN_SECOND_VACCINE_NUM = "sigin_second_vaccine_num";
        public static final String FINISH_SECOND_VACCINE_NUM = "finish_second_vaccine_num";
        public static final String UNFINISH_SECOND_VACCINE_NUM = "unfinish_second_vaccine_num";
    }

    public class NatVaccinePoint {
        public static final String VACCINE_POINT_NAME = "vaccine_point_name";
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String STATUS = "status";
        public static final String START_DATE = "start_date";
        public static final String END_DATE = "end_date";
        public static final String WORK_DAYS = "work_days";
        public static final String AM_START_TIME = "am_start_time";
        public static final String AM_END_TIME = "am_end_time";
        public static final String PM_START_TIME = "pm_start_time";
        public static final String PM_END_TIME = "pm_end_time";
        public static final String APPO_QUOTA = "appo_quota";
        public static final String AGE_MIN_LIMIT = "age_min_limit";
        public static final String AGE_MAX_LIMIT = "age_max_limit";
        public static final String INST_ID = "inst_id";
        public static final String PROVINCE = "province";
        public static final String PROVINCE_CODE = "province_code";
        public static final String CITY = "city";
        public static final String CITY_CODE = "city_code";
        public static final String AREA = "area";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
        public static final String HOTLINE = "hotline";
        public static final String CONTACTS = "contacts";
        public static final String SUBDISTRICT_CODE = "subdistrict_code";
        public static final String SUBDISTRICT_NAME = "subdistrict_name";
        public static final String AREA_CODE = "area_code";
        public static final String OBSERVATION_ID = "observation_id";
        public static final String ESCAPE_ID = "escape_id";
        public static final String VACCINE_POINT_TYPE = "vaccine_point_type";
        public static final String REMARK = "remark";
        public static final String SECOND_VACCINE_APPO_TIME_INTERVAL = "second_vaccine_appo_time_interval";
    }

    //疫苗登记表（nat_vaccine_register）
    public class NatVaccineRegister {
        public static final String ID = "id";
        public static final String APPO_DATE = "appo_date";
        public static final String APPO_PERIOD = "appo_period";
        public static final String CHECKED_PERSON = "checked_person";
        public static final String CHECKED_PERSON_NAME = "checked_person_name";
        public static final String CARD_NUMBER_TYPE = "card_number_type";
        public static final String CHECKED_PERSON_CARD_NUMBER = "checked_person_card_number";
        public static final String AGE = "age";
        public static final String CHECKED_PERSON_TELEPHONE = "checked_person_telephone";
        public static final String PERSON_CLASSIFICATION = "person_classification";
        public static final String AREA = "area";
        public static final String SUBDISTRICT_NAME = "subdistrict_name";
        public static final String NEIGHBORHOOD = "neighborhood";
        public static final String CHECKED_PERSON_DETAIL_ADDRESS = "checked_person_detail_address";
        public static final String COMPANY = "company";
        public static final String STATUS = "status";
        public static final String REGIST_TIME = "regist_time";
        public static final String REGIST_USER_ID = "regist_user_id";
        public static final String REGIST_USER_NAME = "regist_user_name";
        public static final String REGIST_DEV_CODE = "regist_dev_code";
        public static final String VACCINATE_TIME = "vaccinate_time";
        public static final String NOT_VACCINATE_TIME = "not_vaccinate_time";
        public static final String NOT_VACCINATE_REASON = "not_vaccinate_reason";
        public static final String INST_ID = "inst_id";
        public static final String SAM_INST_NAME = "sam_inst_name";
        public static final String SAM_ID = "sam_id";
        public static final String SAM_ID_OLD = "sam_id_old";

        public static final String SAM_NAME = "sam_name";
        public static final String SAM_AREA_CODE = "sam_area_code";
        public static final String SUBDISTRICT_CODE = "subdistrict_code";

        public static final String APPO_CHANNEL = "appo_channel";

        public static final String COMITY_PERSON_ADDRESS = "comity_person_address";
        public static final String HAS_VACCINATED = "has_vaccinated";
        public static final String CREATE_TIME = "create_time";

        public static final String SAM_SUBDISTRICT_CODE = "sam_subdistrict_code";
        public static final String SAM_SUBDISTRICT_NAME = "sam_subdistrict_name";
        public static final String SAM_SUBDISTRICT_CODE_OLD = "sam_subdistrict_code_old";
        public static final String SAM_SUBDISTRICT_NAME_OLD = "sam_subdistrict_name_old";
    }

    /**
     * 疫苗特定团体接种点人员名单表
     */
    public class NatVaccineComityPerson {
        public static final String ID = "id";
        public static final String VACCINE_POINT_ID = "vaccine_point_id";
        public static final String NAME = "name";
        public static final String CARD_TYPE = "card_type";
        public static final String CARD_NUMBER = "card_number";
        public static final String AREA = "area";
        public static final String ADDRESS = "address";
        public static final String TELEPHONE = "telephone";
        public static final String ORDER_FLAG = "order_flag";

    }

    //疫苗登记、接种关联表（nat_vaccine_relation）
    public class NatVaccineRelation {
        public static final String ID = "id";
        public static final String CHECKED_PERSON_NAME = "checked_person_name";
        public static final String CHECKED_PERSON_TELEPHONE = "checked_person_telephone";
        public static final String CARD_NUMBER_TYPE = "card_number_type";
        public static final String CHECKED_PERSON_CARD_NUMBER = "checked_person_card_number";
        public static final String AGE = "age";
        public static final String VACCINATION_STATUS = "vaccination_status";
        public static final String APPO_STATUS = "appo_status";
        public static final String FIRST_VACCINATION_DATE = "first_vaccination_date";
        public static final String SECOND_VACCINATION_DATE = "second_vaccination_date";
        public static final String SUBDISTRICT_NAME = "subdistrict_name";
        public static final String NEIGHBORHOOD = "neighborhood";
        public static final String NOT_VACCINATE_REASON = "not_vaccinate_reason";
        public static final String NOT_VACCINATE_TIME = "not_vaccinate_time";
        public static final String PERSON_CLASSIFICATION = "person_classification";
        public static final String CHECKED_PERSON_DETAIL_ADDRESS = "checked_person_detail_address";
        public static final String COMPANY = "company";
        public static final String MANUFACTURER = "manufacturer";
        public static final String SAM_ID = "sam_id";
        public static final String SAM_ID_OLD = "sam_id_old";
        public static final String SAM_NAME_OLD = "sam_name_old";
        public static final String VACCINE_CODE = "vaccine_code";
        public static final String VACCINE_BATCH_ID = "vaccine_batch_id";
        public static final String FIRST_INST_ID = "first_inst_id";
        public static final String FIRST_VACCINE_BATCH_ID = "first_vaccine_batch_id";
        public static final String FIRST_VACCINE_CODE = "first_vaccine_code";
        public static final String FIRST_MANUFACTURER = "first_manufacturer";
    }

    public class VaccinateRelation {
        public static final String VACCIN_CODE = "vaccin_code";
        public static final String VACCIN_CODE_IMG = "vaccin_code_img";
        public static final String PERSON_NAME = "person_name";
        public static final String PERSON_CODE_TYPE = "person_code_type";
        public static final String PERSON_CODE = "person_code";
        public static final String PERSON_CODE_IMG = "person_code_img";
        public static final String PERSON_PHONE = "person_phone";
        public static final String SAM_TIME = "sam_time";
        public static final String SAM_USER_ID = "sam_user_id";
        public static final String SAM_USER_INST_ID = "sam_user_inst_id";
        public static final String SAM_ID = "sam_id";
        public static final String SAM_INST_ID = "sam_inst_id";
        public static final String SAM_DEV_CODE = "sam_dev_code";
        public static final String MODIFY_TIME = "modify_time";
        public static final String SAM_NAME = "sam_name";
    }

    public class NatVaccineResident {
        public static final String VACCINE_POINT_NAME = "vaccine_point_name";
        public static final String LAST_CALL_TIME_SUCCESS = "last_call_time_success";
        public static final String LAST_SMS_TIME = "last_sms_time";
        public static final String LAST_SMS_TIME_SUCCESS = "last_sms_time_success";
        public static final String VACCINE_STATUS = "vaccine_status";
        public static final String FIRST_VACCINE_TIME = "first_vaccine_time";
        public static final String SECOND_VACCINE_TIME = "second_vaccine_time";
        public static final String VACCINE_INTERVAL_OVER = "vaccine_interval_over";
        public static final String REGISTER_SUBDISTRICT_CODE = "register_subdistrict_code";
        public static final String REGISTER_SUBDISTRICT_NAME = "register_subdistrict_name";
        public static final String REGISTER_COMMITY_CODE = "register_commity_code";
        public static final String REGISTER_COMMITY_NAME = "register_commity_name";
        public static final String REGISTER_ADDRESS = "register_address";
        public static final String REGISTER_NONVACCINE_REASON = "register_nonvaccine_reason";
        public static final String REGISTER_CROWD_TYPE = "register_crowd_type";
        public static final String REGISTER_COMPANY = "register_company";
        public static final String AREA_NAME = "area_name";
        public static final String MANUFACTURER = "manufacturer";
    }

    public static class NatVaccineAppoConfig {
        public static final String ID = "id";
        public static final String INST_ID = "inst_id";
        public static final String VACCINE_POINT_ID = "vaccine_point_id";
        public static final String DATE = "date";
        public static final String AM_START_TIME = "am_start_time";
        public static final String AM_END_TIME = "am_end_time";
        public static final String PM_START_TIME = "pm_start_time";
        public static final String PM_END_TIME = "pm_end_time";
        public static final String AM_APPO_QUOTA = "am_appo_quota";
        public static final String PM_APPO_QUOTA = "pm_appo_quota";
        public static final String AM_TIME_INTERVAL = "am_time_interval";
        public static final String PM_TIME_INTERVAL = "pm_time_interval";
        public static final String APPO_QUOTA = "appo_quota";
        public static final String APPO_FLAG = "appo_flag";
        public static final String CREATE_TIME = "create_time";
        public static final String MODIFY_TIME = "modify_time";
    }

    public static final String IS_CHECKED = "is_checked";

    public static final String FUZZY_PREFIX = "^.*";

    public static final String FUZZY_SUFFIX = ".*$";

    public static final String SAMP_UNIT = "SAMP_UNIT";

    public static final String INSTITUTION = "INSTITUTION";

    public static final String TEST_USERGROUP = "110666000000";

    public static class VaccinationInfoField {
        public static final String CARD_NO= "card_no";
        public static final String DEPA_CODE = "depa_code";
        public static final String INOC_TIME = "inoc_time";
        public static final String INOC_BACT_CODE = "inoc_bact_code";
        public static final String INOC_BACT_NAME = "inoc_bact_name";
        public static final String INOC_DATE = "inoc_date";
        public static final String INOC_BACH_NO = "inoc_bach_no";
        public static final String INOC_CORP_CODE = "inoc_corp_code";

    }

}
