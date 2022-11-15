package com.soundai.nat.institution.admin.module.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: changjiarui
 * @Description: 疫苗预约类型枚举
 */
@Getter
@AllArgsConstructor
public enum VaccineAppoStatusEnum {

    APPO(1, "已预约" ),
    REGISTERED(2, "已登记"),
    VACCINATED_FINSH (3, "接种完成"),
    NOT_VACCINATED (4, "未接种"),
    CANCEL(5, "已取消");

    private Integer status;
    private String msg;


    public static String getMsgByCode(Integer status) {

        for (VaccineAppoStatusEnum statusEnum : values()) {

            if (statusEnum.getStatus().equals(status)) {
                return statusEnum.getMsg();
            }

        }
        return "";
    }

}
