package com.soundai.nat.institution.admin.framework.config.mongo;

import com.github.pagehelper.util.StringUtil;
import com.mongodb.ClientSessionOptions;
import com.mongodb.DB;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;
import lombok.Data;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

@Data
public class MongoDBFactory {
    private String mongodbUri;

    private MongoDB mongoDB;

    /**
     * 初始化并 mongoTemplate 并保存
     *
     * @param mongodbUri
     */
    public MongoDBFactory(String mongodbUri) {
        if (StringUtil.isEmpty(mongodbUri)) {
            throw new RuntimeException("The mongoUri is missing.");
        }

        this.mongodbUri = mongodbUri;

        SimpleMongoClientDbFactory simpleMongoClientDbFactory = new SimpleMongoClientDbFactory(mongodbUri);
        DefaultDbRefResolver dbRefResolver = new DefaultDbRefResolver(simpleMongoClientDbFactory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
        /**
         * 自定义的 {@link MongoTypeMapper} 去除写入 MongoDB 时的 {@code _class}
         */
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoClientDbFactory);

        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(simpleMongoClientDbFactory);
        TransactionTemplate transactionTemplate = new TransactionTemplate(mongoTransactionManager);
        this.mongoDB = new MongoDB(mongoTemplate, simpleMongoClientDbFactory, transactionTemplate);
    }

    /**
     * 获取mongoDB 模板类， 使用key值hash分布
     *
     * @return
     */
    public MongoTemplate getMongoDBTemplate() {
        return this.mongoDB.getMongoTemplate();
    }

    /**
     * GridFsMongoDbFactory -- 抄自 MongoDbFactoryDependentConfiguration
     */
    static class GridFsMongoDbFactory implements MongoDbFactory {

        private final MongoDbFactory mongoDbFactory;

        private final MongoProperties properties;

        GridFsMongoDbFactory(MongoDbFactory mongoDbFactory, MongoProperties properties) {
            Assert.notNull(mongoDbFactory, "MongoDbFactory must not be null");
            Assert.notNull(properties, "Properties must not be null");
            this.mongoDbFactory = mongoDbFactory;
            this.properties = properties;
        }

        @Override
        public MongoDatabase getDb() throws DataAccessException {
            String gridFsDatabase = this.properties.getGridFsDatabase();
            if (StringUtils.hasText(gridFsDatabase)) {
                return this.mongoDbFactory.getDb(gridFsDatabase);
            }
            return this.mongoDbFactory.getDb();
        }

        @Override
        public MongoDatabase getDb(String dbName) throws DataAccessException {
            return this.mongoDbFactory.getDb(dbName);
        }

        @Override
        public PersistenceExceptionTranslator getExceptionTranslator() {
            return this.mongoDbFactory.getExceptionTranslator();
        }

        @Override
        @Deprecated
        public DB getLegacyDb() {
            return this.mongoDbFactory.getLegacyDb();
        }

        @Override
        public ClientSession getSession(ClientSessionOptions options) {
            return this.mongoDbFactory.getSession(options);
        }

        @Override
        public MongoDbFactory withSession(ClientSession session) {
            return this.mongoDbFactory.withSession(session);
        }
    }

}
