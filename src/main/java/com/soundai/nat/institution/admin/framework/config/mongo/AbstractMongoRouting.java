package com.soundai.nat.institution.admin.framework.config.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jefferson Li
 * @title AbstractMongoRouting
 * @description: abstract class of MongoDB rout
 * @date 2021/3/23 19:42
 */
public abstract class AbstractMongoRouting {

    protected final String PREFIX = "spring.data.";

    @Nullable
    private Map<Object, Object> targetDataSources;

    @Nullable
    private Map<Object, MongoTemplate> resolvedDataSources;

    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }

    public void afterPropertiesSet() {
        if (this.targetDataSources == null) {
            throw new IllegalArgumentException("Property 'targetDataSources' is required");
        }
        this.resolvedDataSources = new HashMap<>(this.targetDataSources.size());
        this.targetDataSources.forEach((key, value) -> {
            Object lookupKey = resolveSpecifiedLookupKey(key);
            MongoTemplate dataSource = resolveSpecifiedDataSource(value);
            this.resolvedDataSources.put(lookupKey, dataSource);
        });
    }

    protected Object resolveSpecifiedLookupKey(Object lookupKey) {
        return lookupKey;
    }

    protected MongoTemplate resolveSpecifiedDataSource(Object dataSource) throws IllegalArgumentException {
        if (dataSource instanceof MongoTemplate) {
            return (MongoTemplate) dataSource;
        } else {
            throw new IllegalArgumentException(
                    "Illegal data source value - only [org.springframework.data.mongodb.core.MongoTemplate] and String supported: " + dataSource);
        }
    }

    protected MongoTemplate determineTargetDataSource(Object lookupKey) {
        Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
        MongoTemplate dataSource = this.resolvedDataSources.get(lookupKey);
        if (dataSource == null || lookupKey == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
        }
        return dataSource;
    }

    protected abstract void initDataSources();

}
