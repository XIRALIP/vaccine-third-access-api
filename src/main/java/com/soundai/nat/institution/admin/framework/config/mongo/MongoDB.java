package com.soundai.nat.institution.admin.framework.config.mongo;

import lombok.Data;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.support.TransactionTemplate;

@Data
public class MongoDB {

    private MongoTemplate mongoTemplate;
    private MongoDbFactory mongodbFactory;
    private TransactionTemplate transactionTemplate;

    public MongoDB(MongoTemplate mongoTemplate, MongoDbFactory mongodbFactory, TransactionTemplate transactionTemplate) {
        this.mongoTemplate = mongoTemplate;
        this.mongodbFactory = mongodbFactory;
        this.transactionTemplate = transactionTemplate;
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }

    public MongoDbFactory getMongodbFactory() {
        return mongodbFactory;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }
}
