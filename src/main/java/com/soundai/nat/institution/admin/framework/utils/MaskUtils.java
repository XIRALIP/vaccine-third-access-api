package com.soundai.nat.institution.admin.framework.utils;

import org.apache.commons.lang.StringUtils;

public class MaskUtils {
    // 身份证脱敏 （前2后2）
    public static String idMask(String idCardNum)
    {
        if (org.apache.commons.lang3.StringUtils.isBlank(idCardNum)){
            return idCardNum;
        }
        if (idCardNum.length() > 4) {
            return idCardNum.replaceAll("(?<=\\w{2})\\w(?=\\w{2})", "*");
        } else {
            return idCardNum;
        }
    }

    //手机号脱敏 （前2后2）
    public static String telephoneMask(String phoneNumber) {
        if(org.apache.commons.lang.StringUtils.isEmpty(phoneNumber)){
            return phoneNumber;
        }
        if (phoneNumber.length() > 4) {
            return phoneNumber.replaceAll("(?<=\\w{2})\\w(?=\\w{2})", "*");
        } else {
            return phoneNumber;
        }
    }

    //姓名脱敏（只保留姓）
    public static String nameMask(String str) {
        if (org.apache.commons.lang.StringUtils.isBlank(str)) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        String name = org.apache.commons.lang.StringUtils.left(str, 1);
        return org.apache.commons.lang.StringUtils.rightPad(name, StringUtils.length(str), "*");
    }

    // 所有字符脱敏
    public static String allMask(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(str, 0), StringUtils.length(str), "*");
    }
}
