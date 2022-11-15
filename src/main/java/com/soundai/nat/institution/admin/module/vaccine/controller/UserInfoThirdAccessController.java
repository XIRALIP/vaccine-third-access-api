package com.soundai.nat.institution.admin.module.vaccine.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.soundai.nat.institution.admin.framework.web.domain.RespResult;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.module.common.util.AESUtils;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentSearchParam;
import com.soundai.nat.institution.admin.module.vaccine.domain.UserInfoParam;
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
@Api(tags = "疫苗三方接入控制器")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoThirdAccessController {

    @Autowired
    private VaccineThirdAccessService service;

    @ApiOperation("查询个人信息记录")
    @ApiImplicitParam(name = "queryPersonAppoInfo", value = "appointmentSearchParam", dataTypeClass = String.class, paramType = "body")
    @PostMapping("/queryPersonAppoInfo")
    public ResponseEntity<?> appointmentSearch(@RequestBody AppointmentSearchParam appointmentSearchParam) throws Exception {
        String decrypt = AESUtils.decrypt(appointmentSearchParam.getSid());
        UserInfoParam userInfoParam = JSONObject.parseObject(decrypt, UserInfoParam.class);
        if(null==userInfoParam){
            RespResult.fail(RespStatus.DECODE_ERROR,"解密异常");
        }
        log.info("查询个人信息记录：{}",userInfoParam);
        return service.queryPersonAppoInfo(userInfoParam);
    }
}
