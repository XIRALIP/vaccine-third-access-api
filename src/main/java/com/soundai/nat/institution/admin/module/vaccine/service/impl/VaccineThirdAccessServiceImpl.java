package com.soundai.nat.institution.admin.module.vaccine.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.mongodb.client.result.UpdateResult;
import com.soundai.nat.institution.admin.framework.utils.StringUtils;
import com.soundai.nat.institution.admin.framework.web.domain.RespResult;
import com.soundai.nat.institution.admin.framework.web.domain.ThirdRespResult;
import com.soundai.nat.institution.admin.module.common.domain.NatPerson;
import com.soundai.nat.institution.admin.module.common.domain.NatVaccineRegister;
import com.soundai.nat.institution.admin.module.common.domain.NatVaccineRelation;
import com.soundai.nat.institution.admin.module.common.domain.VaccinationInfo;
import com.soundai.nat.institution.admin.module.common.enums.VaccinationStatusEnum;
import com.soundai.nat.institution.admin.module.common.util.DateUtils;
import com.soundai.nat.institution.admin.module.common.util.ToolUtil;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentResult;
import com.soundai.nat.institution.admin.module.vaccine.domain.PersonAppoInfoResult;
import com.soundai.nat.institution.admin.module.vaccine.domain.UserInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.repository.NatVaccineRelationRepository;
import com.soundai.nat.institution.admin.module.vaccine.repository.VaccineThirdAccessRepository;
import com.soundai.nat.institution.admin.module.vaccine.service.VaccineThirdAccessService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.soundai.nat.institution.admin.framework.web.domain.RespStatus.*;
import static com.soundai.nat.institution.admin.module.common.constant.FieldConstant.NatVaccineRelation.CHECKED_PERSON_CARD_NUMBER;

/**
 * @title: SampleServiceImpl
 * @author: Jefferson Li
 * @date: 2020/11/16 21:49
 * @description: ??????????????????????????????
 * @version: 1.0
 */
@Slf4j
@Service
public class VaccineThirdAccessServiceImpl implements VaccineThirdAccessService {

    @Autowired
    private VaccineThirdAccessRepository vaccineThirdAccessRepository;

    @Autowired
    private NatVaccineRelationRepository natVaccineRelationRepository;

    @Override
    public ResponseEntity<?> appointmentSearch(AppointmentInfoParam appointmentInfoParam) {
        if (StringUtils.isEmpty(appointmentInfoParam.getCardNo())) {
            return RespResult.fail(PARAM_ERROR,"???????????????");
        }
        if (StringUtils.isEmpty(appointmentInfoParam.getCardType())) {
            return RespResult.fail(PARAM_ERROR,"??????????????????");
        }
        NatVaccineRegister natVaccineRegister =vaccineThirdAccessRepository.appointmentSearch(appointmentInfoParam);
        if(null==natVaccineRegister){
            return RespResult.fail(RESULT_ERROR,"???????????????");
        }
        String appoPeriod = natVaccineRegister.getAppoPeriod();
        String appoPeriodStart =natVaccineRegister.getAppoDate();
        String appoPeriodEnd =natVaccineRegister.getAppoDate();
        if(null!=appoPeriod){
            appoPeriodStart = appoPeriodStart+" "+appoPeriod.split("-")[0];
            appoPeriodEnd = appoPeriodEnd+" "+appoPeriod.split("-")[1];
        }
        String status = natVaccineRegister.getStatus().toString();
        AppointmentResult appointmentResult = AppointmentResult.builder()
                .infoID(natVaccineRegister.getId())  //????????????id
                .depaCode(natVaccineRegister.getInstId())  //????????????
                .depaName(natVaccineRegister.getSamInstName())//????????????
                .name(natVaccineRegister.getCheckedPersonName()) //??????
                .gender(natVaccineRegister.getGender()) //??????
                .phone(natVaccineRegister.getCheckedPersonTelephone()) //????????????
                .idnumber(natVaccineRegister.getCheckedPersonCardNumber()) //?????????
                .reseDate(natVaccineRegister.getAppoDate()) //????????????
                .reseBeginTime(appoPeriodStart) //??????????????????
                .reseEndTime(appoPeriodEnd) //??????????????????
                .reseCreateTime(natVaccineRegister.getCreateTime()) //??????????????????
                .reseState(status).build(); //todo ???????????????0-????????????1-????????????2-????????????3-?????????, 4-????????????
//        appointmentResults.add(appointmentResult);
        return RespResult.ok(appointmentResult);
    }

    @Override
    public ResponseEntity<?> queryPersonAppoInfo(UserInfoParam userInfoParam) {
        if (StringUtils.isEmpty(userInfoParam.getCardNo())) {
            return RespResult.fail(PARAM_ERROR,"???????????????");
        }
        if (StringUtils.isEmpty(userInfoParam.getCardType())) {
            return RespResult.fail(PARAM_ERROR,"??????????????????");
        }
        NatPerson natCheckedPerson = vaccineThirdAccessRepository.queryPersonAppoInfo(userInfoParam);
        if(null==natCheckedPerson){
            return RespResult.fail(RESULT_ERROR,"???????????????");
        }
        String card = natCheckedPerson.getCard_type();
        PersonAppoInfoResult result = PersonAppoInfoResult.builder()
                .idnumber(natCheckedPerson.getCard_number())
                .idtype(card)
                .name(natCheckedPerson.getPerson_name())
                .gender(natCheckedPerson.getGender())
                .phone(natCheckedPerson.getTelephone())
                .birthday(natCheckedPerson.getBirthday())
                .zjdz(natCheckedPerson.getOriginAddress())
                .xjdz(natCheckedPerson.getAddress())
                .gzdw(natCheckedPerson.getCompany())
                .zyDm(natCheckedPerson.getCareerCode())
                .zyMc(natCheckedPerson.getCareer())
                .rqflDm(natCheckedPerson.getPersonClassificationCode())
                .rqflMc(natCheckedPerson.getPersonClassification())
                .zjShenDm(natCheckedPerson.getOriginProvinceCode())
                .zjShenMc(natCheckedPerson.getOriginProvinceName())
                .zjShiMc(natCheckedPerson.getOriginCityCode())
                .zjShiDm(natCheckedPerson.getOriginCityName())
                .zjQxDm(natCheckedPerson.getOriginAreaCode())
                .zjQxDm(natCheckedPerson.getOriginAreaName())
                .zjXxDz(natCheckedPerson.getOriginAddress())
                .xjdShenMc(natCheckedPerson.getProvinceCode())
                .xjdShenDm(natCheckedPerson.getProvinceName())
                .xjdShiMc(natCheckedPerson.getCityCode())
                .xjdShiDm(natCheckedPerson.getCityName())
                .xjdQxMc(natCheckedPerson.getAreaCode())
                .xjdQxMc(natCheckedPerson.getAreaName())
                .xjdXxDz(natCheckedPerson.getAddress()).build();
        return RespResult.ok(result);
    }

    /**
     * ?????? -- ???????????????????????????????????????
     * @param vaccinationInfo
     * @return
     */
    @Override
    public ResponseEntity<?> pushVaccinationInfo(VaccinationInfo vaccinationInfo) {
        vaccinationInfo.setId(ObjectId.get().toString());
        log.info("VaccineThirdAccessServiceImpl.pushVaccinationInfo ?????????????????????????????????????????????????????????{}", vaccinationInfo);
        vaccinationInfo = vaccineThirdAccessRepository.saveVaccinationInfo(vaccinationInfo);  //nat_vaccination_record
        if (ObjectUtil.isEmpty(vaccinationInfo)) {
            return ThirdRespResult.fail(RESULT_ERROR);
        }

        Query query = Query.query(Criteria.where(CHECKED_PERSON_CARD_NUMBER).is(vaccinationInfo.getCardNo()));
        NatVaccineRelation natVaccineRelation = natVaccineRelationRepository.findOne(query);  //nat_vaccine_relation
        log.info("VaccineThirdAccessServiceImpl.pushVaccinationInfo ????????????????????????????????? nat_vaccine_relation ???????????????{}", natVaccineRelation);
        if (ObjectUtil.isNotEmpty(natVaccineRelation)) {
            if (StringUtils.isNotEmpty(natVaccineRelation.getSecondVaccinationDate())) {
                return ThirdRespResult.fail(PARAM_ERROR, "??????????????????");
            }
            natVaccineRelation.setVaccinationStatus(VaccinationStatusEnum.SECOND.getCode());
            natVaccineRelation.setSecondVaccinationDate(vaccinationInfo.getInocDate());
            natVaccineRelation.setInstId(vaccinationInfo.getDepaCode()); // ????????????????????? ??????????????? id
            natVaccineRelation.setVaccineCode(vaccinationInfo.getInocCorpCode());
            natVaccineRelation.setVaccineBatchId(vaccinationInfo.getInocBachNo());
            natVaccineRelation.setManufacturer(vaccinationInfo.getInocCorpCode()); // ?????????????????????????????? ?????????????????????
            natVaccineRelation.setUpdateTime(DateUtils.getTime());
            Query updateQuery = Query.query(Criteria.where(CHECKED_PERSON_CARD_NUMBER).is(vaccinationInfo.getCardNo()));
            Update update = ToolUtil.beanToUpdate(natVaccineRelation);
            UpdateResult updateResult = natVaccineRelationRepository.updateOne(updateQuery, update); //nat_vaccine_relation
            log.info("?????? nat_vaccine_relation ?????????{}", updateResult);
            if (1L == updateResult.getModifiedCount()) {
                return ThirdRespResult.ok();
            }
        }
        return ThirdRespResult.ok();
    }

}




