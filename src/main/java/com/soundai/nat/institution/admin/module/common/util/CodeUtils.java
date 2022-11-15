package com.soundai.nat.institution.admin.module.common.util;

import org.springframework.util.StringUtils;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName CodeUtils.java
 * @Description TODO
 * @createTime 2021年01月10日 22:16:00
 */
public class CodeUtils {
    /**
     * 生成规则临时社区编号:父级code + 3位编号（从1开始，不够前补0）
     * @param parentCode 父级code
     * @param isExistCode 已存在社区code
     * @return
     */
    public static String getNewCommunityNo(String parentCode, String isExistCode){
        //自增临时社区编码
        /*String newParentCodeNo = parentCodeNo.substring(0, parentCodeNo.length() - 3);
        int code = 0;
        int newTemporaryCommunityNo = ++code;
        return String.format(newParentCodeNo + "%06d", newTemporaryCommunityNo);*/
        String newParentCode = parentCode.substring(0, parentCode.length() - 3);
        String newCode;
        if (StringUtils.hasText(isExistCode)) {
            StringBuilder flag = new StringBuilder((Long.parseLong(isExistCode.substring(newParentCode.length())) + 1) + "");
            for (int i = flag.length(); i < 6; i++) {
                flag.insert(0, "0");
            }
            newCode = isExistCode.substring(0, newParentCode.length()) + flag;
        }else {
            newCode = newParentCode + "000001";
        }
        return newCode;
    }

    /**
     * 生成疫苗接种临时社区规则:临时社区编号:父级code + 4位编号（从1开始，不够前补0）
     * @param parentCode 父级code
     * @param isExistCode 已存在社区code
     * @return
     */
    public static String getNewVaccineCommunityNum(String parentCode, String isExistCode) {
        String newParentCode = parentCode.substring(0, parentCode.length() - 3);
        String newCode;
        if (StringUtils.hasText(isExistCode)) {
            StringBuilder flag = new StringBuilder((Long.parseLong(isExistCode.substring(newParentCode.length())) + 1) + "");
            for (int i = flag.length(); i < 7; i++) {
                flag.insert(0, "0");
            }
            newCode = isExistCode.substring(0, newParentCode.length()) + flag;
        }else {
            newCode = newParentCode + "0000001";
        }
        return newCode;
    }
}
