package com.soundai.nat.institution.admin.framework.web.domain;


public enum RespStatus {


    /**
     * 定义5位错误码，第1位区分模块，第2、3位区分功能菜单，第4、5位自定义错误序号
     * 第1位模块划分规则：1（登录、账号、角色、权限）；2（首页）；3（核酸检测管理）；4（请求类公共）；5（系统类公共）；6（设备管理）;7（应急采样单位管理）
     * 303xx采样点
     * 304检测点
     */

    //成功
    RS_OK(200, "成功"),

    RS_UNAUTHORIZED(40100, "未授权"),
    RS_REPEAT_SUBMIT(40105, "重复提交"),
    RS_USER_LOCK(40108,"您的账号已被锁定,请联系管理员"),
    RS_FORBIDDEN(40104,"没有权限，请联系管理员授权"),
    RS_ACCOUNT_FAIL(40105,"账号错误"),
    RS_FORBIDDEN_NOFOUND(40106,"用户不存在"),


    RS_INTERNAL_ERROR(500,"系统异常"),
    PARAM_ERROR(50100,"参数错误"),
    DECODE_ERROR(50010,"解密异常"),
    RESULT_ERROR(50012,"无数据"),
    RS_PATH_NOT_EXIST(50013,"路径不存在，请检查路径是否正确"),
    RS_CAPTCHA_FAIL(50014,"验证码不正确"),
    RS_VALIDATED_BIND(50015,"验证异常")
    ;



    RespStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public RespStatus setMsg(String msg) {
        this.msg = msg;
        return this;
    }


}
