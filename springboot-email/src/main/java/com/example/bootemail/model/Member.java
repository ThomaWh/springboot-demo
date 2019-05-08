package com.example.bootemail.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel(value = "Member")
public class Member implements Serializable {
    @ApiModelProperty(value = "会员id" , name = "" , dataType = "")
    private String id;
    @ApiModelProperty(value = "会员名称" , name = "" , dataType = "")
    private String userName;
    @ApiModelProperty(value = "会员密码" , name = "" , dataType = "")
    private String passWord;
    @ApiModelProperty(value = "会员邮箱地址" , name = "" , dataType = "")
    private String email;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}