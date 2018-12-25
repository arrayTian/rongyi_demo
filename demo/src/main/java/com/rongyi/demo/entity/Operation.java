package com.rongyi.demo.entity;

/**
 * @Author:weilan
 * @Date:2018/12/21 13:11
 */
public class Operation {
    private Integer userId;
    private String userIp;
    private Integer loginTimes;

    public Operation(Integer userId, String userIp, Integer loginTimes) {
        this.userId = userId;
        this.userIp = userIp;
        this.loginTimes = loginTimes;
    }

    public Operation() {
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserIp() {
        return userIp;
    }

    public Integer getLoginTimes() {
        return loginTimes;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public void setLoginTimes(Integer loginTimes) {
        this.loginTimes = loginTimes;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "userId=" + userId +
                ", userIp='" + userIp + '\'' +
                ", loginTimes=" + loginTimes +
                '}';
    }
}
