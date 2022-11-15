package com.soundai.nat.institution.admin.module.vaccine.service;

import com.alibaba.fastjson.JSONObject;
import com.soundai.nat.institution.admin.module.common.domain.VaccinationInfo;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.domain.UserInfoParam;
import org.springframework.http.ResponseEntity;

public interface VaccineThirdAccessService {
    /**
     * 疫苗接种信息录入
     * @param appointmentInfoParam
     * @return
     */
    ResponseEntity<?> appointmentSearch(AppointmentInfoParam appointmentInfoParam);
    ResponseEntity<?> queryPersonAppoInfo(UserInfoParam userInfoParam);

    ResponseEntity<?> pushVaccinationInfo(VaccinationInfo vaccinationInfo);
}
