package com.example.bootemail.controller;

import com.example.bootemail.model.Member;
import com.example.bootemail.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wh
 * @description 会员类
 * @date 2019/5/6
 */
@Api(description = "会员控制层")
@RestController
@RequestMapping("/MemberController")
public class MemberController {

    @Autowired
    private MemberService memberServiceImpl;

    @PostMapping("/regsiterMember")
    @ApiOperation(value = "注册会员")
    public String regsiterMember(Member member){
        int number = memberServiceImpl.insertMember(member);
        return (number != 0) ? "注册成功,发送邮件" : "注册失败";
    }
}
