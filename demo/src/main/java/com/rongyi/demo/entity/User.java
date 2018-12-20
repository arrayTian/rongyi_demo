package com.rongyi.demo.entity;

/**
 * @Author:xth
 * @Date:2018/12/20 16：32
 */
public class User {
    private String userName;
    private String userPhone;
    private String userMail;
    private String userSex;
    private String userNumb;
    private String userbirthDate;
    private String userNationality;
    private String userAddress;
    private String idCardAddress;
    private String userPassword;
    private String userSalt;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userNumb='" + userNumb + '\'' +
                ", userbirthDate='" + userbirthDate + '\'' +
                ", userNationality='" + userNationality + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", idCardAddress='" + idCardAddress + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSalt='" + userSalt + '\'' +
                '}';
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public User(String userName, String userPhone, String userMail, String userSex, String userNumb, String userbirthDate, String userNationality, String userAddress, String idCardAddress, String userPassword, String userSalt) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.userMail = userMail;
        this.userSex = userSex;
        this.userNumb = userNumb;
        this.userbirthDate = userbirthDate;
        this.userNationality = userNationality;
        this.userAddress = userAddress;
        this.idCardAddress = idCardAddress;
        this.userPassword = userPassword;
        this.userSalt = userSalt;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserNumb() {
        return userNumb;
    }

    public String getUserbirthDate() {
        return userbirthDate;
    }

    public String getUserNationality() {
        return userNationality;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getIdCardAddress() {
        return idCardAddress;
    }

    public User() {
    }


}
