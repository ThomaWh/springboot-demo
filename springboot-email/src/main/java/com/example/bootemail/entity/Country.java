package com.example.bootemail.entity;

/**
 * @author wh
 * @description 国家地区实体类
 * @date 2019/5/15
 */
public class Country {
    private String enName;
    private String code;

    public Country(String enName, String code) {
        this.enName = enName;
        this.code = code;
    }

    public Country() {
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEnName() {
        return enName;
    }

    public String getCode() {
        return code;
    }
}
