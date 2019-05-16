package com.example.bootemail.mapper;

/**
 * @author wh
 * @description
 * @date 2019/5/15
 */
public interface CountryMapper {
    /**
     *
     * 1级层面设置国家的英文名
     * @param enName
     * @return
     */
    int updateName(String code,String enname);

}
