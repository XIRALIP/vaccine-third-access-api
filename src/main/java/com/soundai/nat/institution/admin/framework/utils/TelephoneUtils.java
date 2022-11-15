package com.soundai.nat.institution.admin.framework.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: changjiarui
 * @description:
 */
public class TelephoneUtils {

    /**
     * 验证电话号码是否合法
     * @param phoneNum
     * @return
     */
    public static boolean CheckMobilePhoneNum(String phoneNum) {
        if (StringUtils.isBlank(phoneNum)) return false;
        String regex = "^(1[3-9]\\d{9}$)";
        if (phoneNum.length() == 11) {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phoneNum);
            if (m.matches()) {
                return true;
            }
        }
        if (isPhone(phoneNum)) {
            return true;
        }
        return false;
    }

    public static boolean isPhone(String str) {
        Pattern p1 = null, p2 = null;
        Matcher m = null;
        boolean isPhone = false;
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$"); // 验证带区号的
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的
        if (str.length() > 9) {
            m = p1.matcher(str);
            isPhone = m.matches();
        } else {
            m = p2.matcher(str);
            isPhone = m.matches();
        }
        return isPhone;
    }
}
