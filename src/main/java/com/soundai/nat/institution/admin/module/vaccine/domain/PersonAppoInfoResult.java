package com.soundai.nat.institution.admin.module.vaccine.domain;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class PersonAppoInfoResult {
    private String idnumber;
    private String idtype;
    private String name;
    private String phone;
    private String gender;
    private String birthday;
    private String zjdz;
    private String xjdz;
    private String gzdw;
    private String zyDm;
    private String zyMc;
    private String rqflDm;
    private String rqflMc;
    private String zjShenDm;
    private String zjShenMc;
    private String zjShiDm;
    private String zjShiMc;
    private String zjQxDm;
    private String zjQxMc;
    private String zjXxDz;
    private String xjdShenDm;
    private String xjdShenMc;
    private String xjdShiDm;
    private String xjdShiMc;
    private String xjdQxDm;
    private String xjdQxMc;
    private String xjdXxDz;
}
