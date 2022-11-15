package com.soundai.nat.institution.admin.module.vaccine.repository;

import com.mongodb.client.result.UpdateResult;
import com.soundai.nat.institution.admin.framework.config.mongo.MongoTemplateReader;
import com.soundai.nat.institution.admin.framework.config.mongo.MongoTemplateWriter;
import com.soundai.nat.institution.admin.module.common.domain.NatVaccineRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * @author Jefferson Li
 * @title NatVaccineRelationRepository
 * @description nat_vaccine_relation 持久层
 * @date 2021/4/1 3:28
 */
@Repository
public class NatVaccineRelationRepository {

    @Autowired
    private MongoTemplateReader reader;

    @Autowired
    private MongoTemplateWriter writer;

    public NatVaccineRelation findOne(Query query) {
        return reader.mongoTemplate().findOne(query, NatVaccineRelation.class);
    }

    public UpdateResult updateOne(Query query, Update update) {
        return writer.mongoTemplate().updateFirst(query, update, NatVaccineRelation.class);
    }
}
