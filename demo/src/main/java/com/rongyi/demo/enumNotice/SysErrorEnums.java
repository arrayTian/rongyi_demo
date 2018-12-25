package com.rongyi.demo.enumNotice;

public enum SysErrorEnums implements IErrorCode  {

    FALSE("50001","失败"),
    SUCCESSFUL("100","成功"),
    /**参数为空*/
    EMPTY_PARAME("500A10","参数为空"),
    /**参数错误*/
    ERROR_PARAME_DATE("500A50","日期格式参数错误"),
    ERROR_PARAME("500A20","参数错误"),
    EMPTY_PARAME_USERID("500A30","用户id为空"),
    EMPTY_PARAME_USER("500A40","请先登录"),
    EMPTY_PARAME_MAIL("500A60","此邮箱已经被注册");
    private String errorCode;
    private String errorMessage;

    private SysErrorEnums(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
