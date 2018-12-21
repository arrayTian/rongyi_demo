package com.rongyi.demo.exception;

import com.rongyi.demo.result.CodeMsg;

import java.util.Map;

/**
 * @Author:xth
 * @Date:2018/12/21 13：55
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private CodeMsg cm;

    public GlobalException(CodeMsg cm) {
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }

}
