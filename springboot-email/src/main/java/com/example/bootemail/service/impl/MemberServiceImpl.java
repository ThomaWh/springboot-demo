package com.example.bootemail.service.impl;

import com.example.bootemail.mapper.MemberMapper;
import com.example.bootemail.model.Member;
import com.example.bootemail.rabbitmq.MemberRegisterSender;
import com.example.bootemail.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wh
 * @description 会员服务层
 * @date 2019/5/6
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberRegisterSender memberRegisterSender;

    /**
     * 会员注册
     * @param member
     * @return
     */
    @Override
    public int insertMember(Member member){
        int insert = memberMapper.insert(member);
        if(0 != insert){
            memberRegisterSender.sendRegisterSuccess(Integer.parseInt(member.getId()));
        }
        return insert;
    }
}
