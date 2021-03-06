package com.rongyi.demo.entity;

public class User {
    private Integer id;
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
    private String method;
    private String userSalt;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userNumb='" + userNumb + '\'' +
                ", userbirthDate='" + userbirthDate + '\'' +
                ", userNationality='" + userNationality + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", idCardAddress='" + idCardAddress + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", method='" + method + '\'' +
                ", userSalt='" + userSalt + '\'' +
                '}';
    }

    public User(Integer id, String userName, String userPhone, String userMail, String userSex, String userNumb, String userbirthDate, String userNationality, String userAddress, String idCardAddress, String userPassword, String method, String userSalt) {
        this.id = id;
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
        this.method = method;
        this.userSalt = userSalt;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserNumb() {
        return userNumb;
    }

    public void setUserNumb(String userNumb) {
        this.userNumb = userNumb;
    }

    public String getUserbirthDate() {
        return userbirthDate;
    }

    public void setUserbirthDate(String userbirthDate) {
        this.userbirthDate = userbirthDate;
    }

    public String getUserNationality() {
        return userNationality;
    }

    public void setUserNationality(String userNationality) {
        this.userNationality = userNationality;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getIdCardAddress() {
        return idCardAddress;
    }

    public void setIdCardAddress(String idCardAddress) {
        this.idCardAddress = idCardAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }
}
