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
 * @description: 采样点业务接口实现类
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
            return RespResult.fail(PARAM_ERROR,"证件号错误");
        }
        if (StringUtils.isEmpty(appointmentInfoParam.getCardType())) {
            return RespResult.fail(PARAM_ERROR,"证件类型错误");
        }
        NatVaccineRegister natVaccineRegister =vaccineThirdAccessRepository.appointmentSearch(appointmentInfoParam);
        if(null==natVaccineRegister){
            return RespResult.fail(RESULT_ERROR,"无预约数据");
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
                .infoID(natVaccineRegister.getId())  //预约信息id
                .depaCode(natVaccineRegister.getInstId())  //单位编码
                .depaName(natVaccineRegister.getSamInstName())//单位名称
                .name(natVaccineRegister.getCheckedPersonName()) //姓名
                .gender(natVaccineRegister.getGender()) //性别
                .phone(natVaccineRegister.getCheckedPersonTelephone()) //手机号码
                .idnumber(natVaccineRegister.getCheckedPersonCardNumber()) //证件号
                .reseDate(natVaccineRegister.getAppoDate()) //预约日期
                .reseBeginTime(appoPeriodStart) //预约开始日期
                .reseEndTime(appoPeriodEnd) //预约结束日期
                .reseCreateTime(natVaccineRegister.getCreateTime()) //预约创建时间
                .reseState(status).build(); //todo 预约状态（0-已预约，1-已取号，2-已取消，3-已过期, 4-已完成）
//        appointmentResults.add(appointmentResult);
        return RespResult.ok(appointmentResult);
    }

    @Override
    public ResponseEntity<?> queryPersonAppoInfo(UserInfoParam userInfoParam) {
        if (StringUtils.isEmpty(userInfoParam.getCardNo())) {
            return RespResult.fail(PARAM_ERROR,"证件号错误");
        }
        if (StringUtils.isEmpty(userInfoParam.getCardType())) {
            return RespResult.fail(PARAM_ERROR,"证件类型错误");
        }
        NatPerson natCheckedPerson = vaccineThirdAccessRepository.queryPersonAppoInfo(userInfoParam);
        if(null==natCheckedPerson){
            return RespResult.fail(RESULT_ERROR,"无个人数据");
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
     * 云南 -- 推送新冠接种记录业务处理层
     * @param vaccinationInfo
     * @return
     */
    @Override
    public ResponseEntity<?> pushVaccinationInfo(VaccinationInfo vaccinationInfo) {
        vaccinationInfo.setId(ObjectId.get().toString());
        log.info("VaccineThirdAccessServiceImpl.pushVaccinationInfo 接收新冠接种记录，准备入库，入参数据：{}", vaccinationInfo);
        vaccinationInfo = vaccineThirdAccessRepository.saveVaccinationInfo(vaccinationInfo);  //nat_vaccination_record
        if (ObjectUtil.isEmpty(vaccinationInfo)) {
            return ThirdRespResult.fail(RESULT_ERROR);
        }

        Query query = Query.query(Criteria.where(CHECKED_PERSON_CARD_NUMBER).is(vaccinationInfo.getCardNo()));
        NatVaccineRelation natVaccineRelation = natVaccineRelationRepository.findOne(query);  //nat_vaccine_relation
        log.info("VaccineThirdAccessServiceImpl.pushVaccinationInfo 接收新冠接种记录，查询 nat_vaccine_relation 表中数据：{}", natVaccineRelation);
        if (ObjectUtil.isNotEmpty(natVaccineRelation)) {
            if (StringUtils.isNotEmpty(natVaccineRelation.getSecondVaccinationDate())) {
                return ThirdRespResult.fail(PARAM_ERROR, "请勿重复推送");
            }
            natVaccineRelation.setVaccinationStatus(VaccinationStatusEnum.SECOND.getCode());
            natVaccineRelation.setSecondVaccinationDate(vaccinationInfo.getInocDate());
            natVaccineRelation.setInstId(vaccinationInfo.getDepaCode()); // 接种单位编码， 暂存为机构 id
            natVaccineRelation.setVaccineCode(vaccinationInfo.getInocCorpCode());
            natVaccineRelation.setVaccineBatchId(vaccinationInfo.getInocBachNo());
            natVaccineRelation.setManufacturer(vaccinationInfo.getInocCorpCode()); // 生产厂家编码，暂存为 第二次疫苗厂商
            natVaccineRelation.setUpdateTime(DateUtils.getTime());
            Query updateQuery = Query.query(Criteria.where(CHECKED_PERSON_CARD_NUMBER).is(vaccinationInfo.getCardNo()));
            Update update = ToolUtil.beanToUpdate(natVaccineRelation);
            UpdateResult updateResult = natVaccineRelationRepository.updateOne(updateQuery, update); //nat_vaccine_relation
            log.info("更新 nat_vaccine_relation 结果：{}", updateResult);
            if (1L == updateResult.getModifiedCount()) {
                return ThirdRespResult.ok();
            }
        }
        return ThirdRespResult.ok();
    }

}




