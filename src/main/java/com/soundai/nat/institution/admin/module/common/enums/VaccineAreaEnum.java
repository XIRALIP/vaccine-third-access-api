package com.soundai.nat.institution.admin.module.common.enums;


import com.soundai.nat.institution.admin.framework.utils.StringUtils;

public enum VaccineAreaEnum {
    VACCINE_APPO_NUM_TODAY("VACCINE_APPO_NUM_TODAY", "今日预约数", "", 1),
    VACCINE_APPO_NUM("VACCINE_APPO_NUM", "累计预约数", "", 2),
    VACCINATED_NUM_TODAY("VACCINATED_NUM_TODAY", "今日留观数", "", 3),
    VACCINATED_NUM("VACCINATED_NUM", "累计留观数", "", 4),
    UNVACCINATED_NUM_TODAY("UNVACCINATED_NUM_TODAY", "今日未接种数", "", 5),
    UNVACCINATED_NUM("UNVACCINATED_NUM", "累计未接种数", "", 6),
    VACCINE_APPO_NUM_TOMO("VACCINE_APPO_NUM_TOMO", "明日预约数", "", 7),
    VACCINE_APPO_NUM_SIX("VACCINE_APPO_NUM_SIX", "未来近六天预约数", "", 8);

    private final String code;
    private final String type;
    private final String value;
    private final Integer order;

    VaccineAreaEnum(String code, String type, String value, Integer order) {
        this.code = code;
        this.type = type;
        this.value = value;
        this.order = order;
    }

    public static VaccineAreaEnum findDataEnumByCode(String code) {
        if (StringUtils.isEmpty(code)) {
            return null;
        }
        for (VaccineAreaEnum dataEnum : VaccineAreaEnum.values()) {
            if (dataEnum.getCode().equals(code)) {
                return dataEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Integer getOrder() {
        return order;
    }


}
