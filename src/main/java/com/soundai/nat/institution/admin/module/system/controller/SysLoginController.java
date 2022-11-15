package com.soundai.nat.institution.admin.module.system.controller;

import com.alibaba.fastjson.JSONObject;
import com.soundai.nat.institution.admin.framework.constant.Constants;
import com.soundai.nat.institution.admin.framework.security.LoginBody;
import com.soundai.nat.institution.admin.framework.security.LoginUser;
import com.soundai.nat.institution.admin.framework.security.LoinParam;
import com.soundai.nat.institution.admin.framework.security.service.SysLoginService;
import com.soundai.nat.institution.admin.framework.security.service.TokenService;
import com.soundai.nat.institution.admin.framework.utils.redis.RedisCache;
import com.soundai.nat.institution.admin.framework.web.domain.RespResult;
import com.soundai.nat.institution.admin.framework.web.domain.RespStatus;
import com.soundai.nat.institution.admin.framework.web.domain.TokenRespResult;
import com.soundai.nat.institution.admin.module.common.util.AESUtils;
import com.soundai.nat.institution.admin.module.common.util.DESUtils;
import com.soundai.nat.institution.admin.module.system.domain.SysUser;
import com.soundai.nat.institution.admin.module.system.service.ISysUserService;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentSearchParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 登录验证
 *
 * @author soundai
 */
@Api(tags = "登录验证控制器")
@Slf4j
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    /**
     * 登录方法
     *
     * @param
     * @return 结果
     */
    @ApiOperation("登录")
    @ApiImplicitParam(name = "loginBody", value = "LoginBody", dataTypeClass = AppointmentSearchParam.class, paramType = "body")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppointmentSearchParam appointmentSearchParam) throws Exception {
        // 生成令牌
        String saiDecrypt = AESUtils.decrypt(appointmentSearchParam.getSid());
        if(null==saiDecrypt){
            RespResult.fail(RespStatus.DECODE_ERROR,"解密异常");
        }
        LoinParam loginBody = JSONObject.parseObject(saiDecrypt, LoinParam.class);
        SysUser user = userService.selectUserByUserName(loginBody.getAppkey());
        LoginUser loginUser = loginService.login(loginBody,user);
        String token = tokenService.createToken(loginUser);
        JSONObject tokenInfo = new JSONObject();
        tokenInfo.put(Constants.TOKEN, token);
        return TokenRespResult.ok(tokenInfo);
    }
}
