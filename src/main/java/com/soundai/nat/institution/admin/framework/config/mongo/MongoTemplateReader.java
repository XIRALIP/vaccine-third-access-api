package com.soundai.nat.institution.admin.framework.config.mongo;

import com.alibaba.fastjson.JSONObject;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.soundai.nat.institution.admin.framework.enums.ProvinceEnum;
import com.soundai.nat.institution.admin.framework.utils.SecurityUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class MongoTemplateReader extends AbstractMongoRouting {

    final String READ_SUFFIX = ".read.uri";

    private final ConcurrentHashMap<Object, Object> dataSources = new ConcurrentHashMap<>();

    public MongoTemplateReader() {
        this.initDataSources();
    }

    @Override
    protected void initDataSources() {
        Config config = ConfigService.getAppConfig();
        for (ProvinceEnum provinceEnum : ProvinceEnum.values()) {

            String uriKey = PREFIX + provinceEnum.getProvinceAlphabetic().toLowerCase() + READ_SUFFIX;
            for (String key : config.getPropertyNames()) {
                if (uriKey.equals(key)) {
                    dataSources.put(provinceEnum.getProvinceAlphabetic(), new MongoDBFactory(config.getProperty(key, null)).getMongoDBTemplate());
                }
            }
        }

        super.setTargetDataSources(dataSources);
        super.afterPropertiesSet();
    }

    public MongoTemplate getMongoTemplate(String key) {
        return super.determineTargetDataSource(key);
    }
    public MongoTemplate mongoTemplate(){
        String dbPermissions = SecurityUtils.getUserDbPermissions();
        return super.determineTargetDataSource(ProvinceEnum.getAlphabeticByMd5Code(dbPermissions));
    }
}
