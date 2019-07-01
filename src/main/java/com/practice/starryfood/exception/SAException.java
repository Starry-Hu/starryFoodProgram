package com.practice.starryfood.exception;

import com.practice.starryfood.enums.ExceptionEnum;

/***
* @Description: starryfood系统自定义异常
* @Author: StarryHu
* @Date: 2019/7/1
*/
public class SAException extends RuntimeException {

    private Integer code;
    private String msg;

    public SAException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
