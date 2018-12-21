package com.rongyi.demo.vo;

import com.rongyi.demo.utils.ResponseCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.xml.ws.Response;

/**
 * @Author:xth
 * @Date:2018/12/21 10：14
 */
public class SignUpVo {
    @Length(min = 11, max = 11)
    public String userPhone;

    //@Pattern(="^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,20}$")
    @Pattern(regexp = "^(?=.*[0-9].*)(?=.*[A-Z].*)(?=.*[a-z].*).{6,20}$")
    @NotEmpty
    public String userPassword;

    @Email
    public String userMail;


    public String userNumber;

    public String signupMethod;

    @Override
    public String toString() {
        return "SignUpVo{" +
                "userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", signupMethod='" + signupMethod + '\'' +
                '}';
    }

    public String getSignupMethod() {
        return signupMethod;
    }

    public void setSignupMethod(String signupMethod) {
        this.signupMethod = signupMethod;
    }

    public SignUpVo(String userPhone, @NotEmpty String userPassword, @Email(message = "邮箱格式错误") String userMail, String userNumber, String signupMethod) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userNumber = userNumber;
        this.signupMethod = signupMethod;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }


    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public SignUpVo() {
    }

    public SignUpVo(String userPhone, String userPassword, String userMail) {
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userMail = userMail;
    }
}
