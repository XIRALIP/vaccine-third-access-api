package com.soundai.nat.institution.admin.module.common.util;

import com.soundai.nat.institution.admin.module.common.enums.IdCardEnum;

/**
 * @author SunnyBoy_CF
 * @version 1.0.0
 * @ClassName CardTypeUtils.java
 * @Description TODO
 * @createTime 2021年01月11日 17:36:00
 */
public class CardTypeUtils {
    public static boolean checkCardType(String cardNumberType){
        return IdCardEnum.ID_CARD.getName().equals(cardNumberType)
                || IdCardEnum.PASSPORT.getName().equals(cardNumberType)
                || IdCardEnum.OFFICER_ID.getName().equals(cardNumberType)
                || IdCardEnum.HONG_KONG_MACAU_AND_TAIWAN_PASS.getName().equals(cardNumberType);
    }

    public static void main(String[] args) {
        boolean cardType = CardTypeUtils.checkCardType("身份证");
        System.out.println("证件类型是否合法：" + cardType);
    }
}
