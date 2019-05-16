package com.example.bootemail.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TareaCode {
    /**
     * 一级层面设置英文名
     * @param code
     * @param
     * @return
     */
    int updateEnname(@Param("code") String code , @Param("name")String name);

    /**
     * 根据一级code获取国家id
     */
    String findIdByCode(String code);

    /**
     * 根据二级code获取地区id
     */
    String findIdMyCodeTwo(@Param("code3") String code3,@Param("preId1") String preId1);
    /**
     *修改二级层面
     */
    int updateTwoEnname(@Param("codeTwo") String codeTwo , @Param("nameTwo")String nameTwo ,@Param("preId1")String preId1);

    /**
     * 修改三级层面
     */
    int updateThreeEnname(@Param("code3") String code3 , @Param("name3") String name3 , @Param("preId2") String preId2);
}
