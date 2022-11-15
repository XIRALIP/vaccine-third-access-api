package com.soundai.nat.institution.admin.module.common.constant;

/**
 * @author liujiahe
 * @description: redis key 常量
 * @date 2020/12/10 2:29
 */
public interface RedisKeyConstant {

    //采样点key
    String SAMPLEPOINTBASIC = "samplePointBasic.";

    /**
     * 机构redis_key:institution.{instId}
     */
    String INST_REDIS_KEY = "institution.";

    /**
     * 机构全量redis_key:institution.all
     */
    String INSTITUTION_REDIS_KEY = "institution.all";

    /**
     * 检测点redis_key: checkPointBasic.{id}
     * value：（jsonStrin） id,checkPointName,instId,area,address,status
     */
    String CHECK_POINT_REDIS_KEY = "checkPointBasic.";


    /**
     * 采样点 redis_key: samplePointDetail.{samId}
     * value：（hashmap）samId,instId,instName,samplePointName,area,address,status
     */
    String SAMPLE_POINT_REDIS_KEY = "samplePointDetail.";

}
