package com.soundai.nat.institution.admin.module.vaccine.domain;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class AppointmentResult {
    private String infoID;
    private String depaCode;
    private String depaName;
    private String name;
    private String gender;
    private String phone;
    private String idnumber;
    private String reseDate;
    private String reseBeginTime;
    private String reseEndTime;
    private String reseCreateTime;
    private String reseState;
}
