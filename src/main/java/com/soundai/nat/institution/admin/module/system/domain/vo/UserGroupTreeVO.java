package com.soundai.nat.institution.admin.module.system.domain.vo;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

@Data
public class UserGroupTreeVO {

    private String label;

    private String id;

    private String parentGroupId;

    private JSONArray children;

}
