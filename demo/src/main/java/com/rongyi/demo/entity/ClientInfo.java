package com.rongyi.demo.entity;

/**
 * @Author:xth
 * @Date:2018/12/20 16：37
 */
public class ClientInfo {
    private String userId;
    private String clientPhone;
    private String clientMail;
    private String clientName;
    private String clientSex;
    private String clientBirthDate;
    private String clientNationality;
    private String clientAddress;


    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setClientMail(String clientMail) {
        this.clientMail = clientMail;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    public void setClientBirthDate(String clientBirthDate) {
        this.clientBirthDate = clientBirthDate;
    }

    public void setClientNationality(String clientNationality) {
        this.clientNationality = clientNationality;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ClientInfo(String clientPhone, String clientMail, String clientName, String clientSex, String clientBirthDate, String clientNationality, String clientAddress) {
        this.clientPhone = clientPhone;
        this.clientMail = clientMail;
        this.clientName = clientName;
        this.clientSex = clientSex;
        this.clientBirthDate = clientBirthDate;
        this.clientNationality = clientNationality;
        this.clientAddress = clientAddress;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "clientPhone='" + clientPhone + '\'' +
                ", clientMail='" + clientMail + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientSex='" + clientSex + '\'' +
                ", clientBirthDate='" + clientBirthDate + '\'' +
                ", clientNationality='" + clientNationality + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                '}';
    }

    public ClientInfo() {
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getClientMail() {
        return clientMail;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientSex() {
        return clientSex;
    }

    public String getClientBirthDate() {
        return clientBirthDate;
    }

    public String getClientNationality() {
        return clientNationality;
    }

    public String getClientAddress() {
        return clientAddress;
    }
}
