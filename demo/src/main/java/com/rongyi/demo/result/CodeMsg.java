package com.rongyi.demo.result;

/**
 * @Author:xth
 * @Date:2018/12/21 15：18
 */
public class CodeMsg {

    private int resultCode;
    private String resultMessage;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(5003, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(5002, "参数校验异常：%s");
    //登录模块 5002XX
    public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session不存在或者已经失效");
    public static CodeMsg EXIST_ERROR = new CodeMsg(5001, "用户已经注册");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "登录密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(500212, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(500213, "手机号格式错误");
    public static CodeMsg MOBILE_NOT_EXIST = new CodeMsg(500214, "手机号不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "密码错误");


    private CodeMsg() {
    }

    private CodeMsg(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int code) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String msg) {
        this.resultMessage = resultMessage;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.resultCode;
        String message = String.format(this.resultMessage, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [resultCode=" + resultCode + ", resultMessage=" + resultMessage + "]";
    }


}
