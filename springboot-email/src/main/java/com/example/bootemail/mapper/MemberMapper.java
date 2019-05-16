package com.example.bootemail.mapper;

import com.example.bootemail.model.Member;


public interface MemberMapper {

    int insert(Member record);

    int insertSelective(Member record);

    Member findMemberById(int memberId);

}