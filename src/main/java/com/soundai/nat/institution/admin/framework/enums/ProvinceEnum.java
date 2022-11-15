package com.soundai.nat.institution.admin.framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jefferson Li
 * @title ProvinceEnum
 * @description 行政省枚举
 * @date 2021/3/23 22:19
 */
@Getter
@AllArgsConstructor
public enum ProvinceEnum {

    YUNNAN("530000000000", "云南省", "YUNNAN","34c0f8379a11af8b4b4e1624bc5b7744"),
    BEIJING("110000000000", "北京市", "BEIJING","0394f680c5145afb9645ea4a515498d4"),
    ;

    private String provinceCode;
    private String provinceName;
    private String provinceAlphabetic;
    private String md5Code;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceAlphabetic() {
        return provinceAlphabetic;
    }

    public void setProvinceAlphabetic(String provinceAlphabetic) {
        this.provinceAlphabetic = provinceAlphabetic;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setMd5Code(String md5Code) {
        this.md5Code = md5Code;
    }

    public static String getAlphabeticByMd5Code(String md5Code){
        for(ProvinceEnum province:ProvinceEnum.values()){
            if(md5Code.equals(province.getMd5Code())){
                return province.getProvinceAlphabetic();
            }
        }
        return null;
    }
}
