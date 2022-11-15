package com.soundai.nat.institution.admin.framework.utils;

public enum Messages {
    NOTNULL("not.null", "* 必须填写"),
    JCAPTCHAEXPIRE("user.jcaptcha.expire", "验证码已失效"),
    JCAPTCHAERROR("user.jcaptcha.error", "验证码错误"),
    USERNOTEXISTS("user.not.exists", "用户不存在/密码错误"),
    USERPASSWORDNOTMATCH("user.password.not.match", "用户不存在/密码错误"),
    USERPASSWORDRETRYLIMITCOUNT("user.password.retry.limit.count", "密码输入错误{0}次"),
    USERPASSWORDRETRYLIMITEXCEED("user.password.retry.limit.exceed", "密码输入错误{0}次，帐户锁定10分钟"),
    USERPASSWORDDELETE("user.password.delete", "对不起，您的账号已被删除"),
    USERBLOCKED("user.blocked", "用户已封禁，请联系管理员"),
    ROLEBLOCKED("role.blocked", "角色已封禁，请联系管理员"),
    USERLOGOUTSUCCESS("user.logout.success", "退出成功"),
    LENGTHNOTVALID("length.not.valid", "长度必须在{min}到{max}个字符之间"),
    USERUSERNAMENOTVALID("user.username.not.valid", "* 2到20个汉字、字母、数字或下划线组成，且必须以非数字开头"),
    USERPASSWORDNOTVALID("user.password.not.valid", "* 5-50个字符"),
    USEREMAILNOTVALID("user.email.not.valid", "邮箱格式错误"),
    USERMOBILEPHONENUMBERNOTVALID("user.mobile.phone.number.not.valid", "手机号格式错误"),
    USERLOGINSUCCESS("user.login.success", "登录成功"),
    USERNOTFOUND("user.notfound", "请重新登录"),
    USERFORCELOGOUT("user.forcelogout", "管理员强制退出，请重新登录"),
    USERUNKNOWNERROR("user.unknown.error", "未知错误，请重新登录"),
    UPLOADEXCEEDMAXSIZE("upload.exceed.maxSize", "上传的文件大小超出限制的文件大小！<br/>允许的文件最大大小是：{0}MB！"),
    UPLOADFILENAMEEXCEEDLENGTH("upload.filename.exceed.length", "上传的文件名最长{0}个字符"),
    NOPERMISSION("no.permission", "您没有数据的权限，请联系管理员添加权限 [{0}]");
    private String code;
    private String message;

    private Messages(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // 普通方法
    public static String getMessage(String code) {
        for (Messages c : Messages.values()) {
            if (c.code == code) {
                return c.message;
            }
        }
        return null;
    }
}
