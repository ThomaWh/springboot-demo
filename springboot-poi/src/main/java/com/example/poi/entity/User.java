package com.example.poi.entity;

/**
 * @author wh
 * @description
 * @date 2019/5/9
 */
public class User {
    private String userName;
    private String userSex;
    private String userAddress;
    private String userAge;
    private String userProfesseion;
    private String userHobby;

    public String getUserName() {
        return userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserAge() {
        return userAge;
    }

    public String getUserProfesseion() {
        return userProfesseion;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public void setUserProfesseion(String userProfesseion) {
        this.userProfesseion = userProfesseion;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }

    public User(String userName, String userSex, String userAddress, String userAge, String userProfesseion, String userHobby) {
        this.userName = userName;
        this.userSex = userSex;
        this.userAddress = userAddress;
        this.userAge = userAge;
        this.userProfesseion = userProfesseion;
        this.userHobby = userHobby;
    }

    public User() {

    }
}
