package com.example.jsondemo.entity;

/**
 * @author wh
 * @description
 * @date 2019/4/29
 */
public class User {
    String userName;
    String userSex;
    Integer userId;

    public User(String userName, String userSex, Integer userId) {
        this.userName = userName;
        this.userSex = userSex;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public Integer getUserId() {
        return userId;
    }

    public User() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userId=" + userId +
                '}';
    }
}
