package com.rongyi.demo.result;

/**
 * @Author:xth
 * @Date:2018/12/21 15：30
 */
public class Result<T> {

    private int resultCode;
    private String resultMessage;
    private T param;

    /**
     *  成功时候的调用
     * */
    public static  <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     *  失败时候的调用
     * */
    public static  <T> Result<T> error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    private Result(T data) {
        this.param = param;
    }

    private Result(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.resultCode = codeMsg.getResultCode();
            this.resultMessage = codeMsg.getResultMessage();
        }
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
    public void setResultMsg(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    public T getParam() {
        return param;
    }
    public void setParam(T data) {
        this.param = data;
    }
}