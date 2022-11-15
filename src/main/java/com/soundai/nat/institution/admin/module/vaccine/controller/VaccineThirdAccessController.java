package com.soundai.nat.institution.admin.module.vaccine.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.soundai.nat.institution.admin.framework.web.domain.RespResult;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.module.common.domain.VaccinationInfo;
import com.soundai.nat.institution.admin.module.common.util.AESUtils;
import com.soundai.nat.institution.admin.module.common.util.DESUtils;
import com.soundai.nat.institution.admin.module.common.util.StringUtils;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentSearchParam;
import com.soundai.nat.institution.admin.module.vaccine.service.VaccineThirdAccessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jefferson Li
 * @title VaccineConfigController
 * @description 疫苗预约号源管理控制器
 * @date 2021/2/25 17:09
 */
@Slf4j
@Api(tags = "疫苗三方接入控制器")
@RestController
public class VaccineThirdAccessController {

    @Autowired
    private VaccineThirdAccessService service;

    @ApiOperation("查询预约记录")
    @ApiImplicitParam(name = "appointmentSearchParam", value = "appointmentSearchParam", dataTypeClass = String.class, paramType = "body")
    @PostMapping("/vacation/appointmentSearch")
    public ResponseEntity<?> appointmentSearch(@RequestBody AppointmentSearchParam appointmentSearchParam) {
        String decrypt = AESUtils.decrypt(appointmentSearchParam.getSid());
        if(null==decrypt){
            RespResult.fail(RespStatus.DECODE_ERROR,"解密异常");
        }
        AppointmentInfoParam appointmentInfoParam = JSON.parseObject(decrypt, AppointmentInfoParam.class);
        log.info("查询预约记录参数：{}",appointmentInfoParam);
        return service.appointmentSearch(appointmentInfoParam);
    }

    @ApiOperation("接收新冠接种记录")
    @ApiImplicitParam(name = "pushVaccinationInfo", value = "pushVaccinationInfo", dataTypeClass = String.class, paramType = "body")
    @PostMapping("/vacation/pushVaccinationInfo")
    public ResponseEntity<?> pushVaccinationInfo(@RequestBody AppointmentSearchParam appointmentSearchParam) {
        String decrypt = AESUtils.decrypt(appointmentSearchParam.getSid());
        if(StringUtils.isEmpty(decrypt)){
            RespResult.fail(RespStatus.DECODE_ERROR,"解密异常");
        }
        VaccinationInfo vaccinationInfo = JSON.parseObject(decrypt, VaccinationInfo.class);
        log.info("接收新冠接种记录参数：{}",vaccinationInfo);
        return service.pushVaccinationInfo(vaccinationInfo);
    }
}
