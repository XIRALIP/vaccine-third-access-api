package com.soundai.nat.institution.admin.module.resident.entity;

import com.soundai.nat.institution.admin.framework.web.page.CommonDomain;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AreaInfoVO extends CommonDomain {
    private String areaCode;
    private String areaName;
    private String parentCode;
    private String areaAddress;
    private String contactorTelephone;
    private String areaContactor;
    private Integer areaType;
    private List<String> areaCodes;
    private Integer skip;
    private Integer communityType; //社区类型 1：固定社区 2：临时社区
    private String communityName;
    private String communityCode;
    private List<String> parentIds;
}
