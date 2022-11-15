package com.soundai.nat.institution.admin.module.vaccine.repository.impl;

import com.soundai.nat.institution.admin.framework.config.mongo.MongoTemplateReader;
import com.soundai.nat.institution.admin.framework.config.mongo.MongoTemplateWriter;
import com.soundai.nat.institution.admin.module.common.constant.FieldConstant;
import com.soundai.nat.institution.admin.module.common.domain.NatPerson;
import com.soundai.nat.institution.admin.module.common.domain.NatVaccineRegister;
import com.soundai.nat.institution.admin.module.common.domain.VaccinationInfo;
import com.soundai.nat.institution.admin.module.common.enums.CardTypeEnum;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.domain.UserInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.repository.VaccineThirdAccessRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.soundai.nat.institution.admin.module.common.constant.CollectionNameConstant.NAT_VACCINATION_RECORD;

@Slf4j
@Repository
public class VaccineThirdAccessRepositoryImpl implements VaccineThirdAccessRepository {
    @Autowired
    private MongoTemplateReader reader;

    @Autowired
    private MongoTemplateWriter writer;

    @Override
    public NatVaccineRegister appointmentSearch(AppointmentInfoParam appointmentInfoParam) {
        Query query = Query.query(Criteria.where(FieldConstant.NatVaccineRegister.CHECKED_PERSON_CARD_NUMBER).is(appointmentInfoParam.getCardNo())
                .and(FieldConstant.NatVaccineRegister.CARD_NUMBER_TYPE).is(CardTypeEnum.getName(appointmentInfoParam.getCardType()))
        );
        query.with(Sort.by(Sort.Order.desc(FieldConstant.NatVaccineRegister.CREATE_TIME)));
        log.info("预约记录查询语句：{}",query);
        return reader.mongoTemplate().findOne(query,NatVaccineRegister.class);
    }

    @Override
    public NatPerson queryPersonAppoInfo(UserInfoParam userInfoParam) {
        Query query = Query.query(Criteria.where(FieldConstant.NatCheckedPerson.CARD_NUMBER).is(userInfoParam.getCardNo())
                .and(FieldConstant.NatCheckedPerson.CARD_TYPE).is(userInfoParam.getCardType()));
        log.info("个人信息查询语句：{}",query);
        return reader.mongoTemplate().findOne(query, NatPerson.class);
    }

    /**
     * 云南--保存推送新冠接种记录
     * @param vaccinationInfo
     */
    @Override
    public VaccinationInfo saveVaccinationInfo(VaccinationInfo vaccinationInfo) {
        return writer.mongoTemplate().save(vaccinationInfo, NAT_VACCINATION_RECORD);
    }
}
