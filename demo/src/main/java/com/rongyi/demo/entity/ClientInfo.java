package com.rongyi.demo.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class ClientInfo {
    int id;
    int userId;
    String clientMail;
    String clientPhone;
    String clientName;
    String clientSex;
    @JSONField(format = "yyyy-MM")
    Date clientBirthdayDate;
    String clientNationality;
    String clientAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getClientMail() {
        return clientMail;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    public Date getClientBirthdayDate() {
        return clientBirthdayDate;
    }

    public void setClientBirthdayDate(Date clientBirthdayDate) {
        this.clientBirthdayDate = clientBirthdayDate;
    }

    public String getClientNationality() {
        return clientNationality;
    }

    public void setClientNationality(String clientNationality) {
        this.clientNationality = clientNationality;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", clientMail='" + clientMail + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientSex='" + clientSex + '\'' +
                ", clientBirthdayDate='" + clientBirthdayDate + '\'' +
                ", clientNationality='" + clientNationality + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                '}';
    }
}
