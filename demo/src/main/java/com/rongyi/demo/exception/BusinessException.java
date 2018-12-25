package com.rongyi.demo.exception;

import com.rongyi.demo.enumNotice.IErrorCode;

import java.util.Map;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private IErrorCode iErrorCode;
    private String errorCode;
    private String errorMessage;
    private Map<String, Object> errorData;

    public BusinessException(IErrorCode iErrorCode) {
        super();
        this.iErrorCode = iErrorCode;
        this.errorCode = iErrorCode.getErrorCode();
        this.errorMessage = iErrorCode.getErrorMessage();
    }

    //其他get、set、构造方法
}
