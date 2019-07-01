package com.practice.starryfood.enums;

public enum ExceptionEnum {
    // 管理员相关
    ADMIN_ADD_FAIL(201,"管理员添加失败"),
    ADMIN_NOT_EXIST(202,"管理员不存在"),
    ADMIN_UPDATE_FAIL(203,"管理员更新失败"),
    ADMIN_PSW_ERROR(204,"账户或密码错误！"),
    ADMIN_EXIST(205,"账户已存在！"),


    // 用户相关
    CUSTOMER_ADD_FAIL(301,"用户添加失败"),
    CUSTOMER_NOT_EXIST(302,"用户不存在"),
    CUSTOMER_UPDATE_FAIL(303,"用户更新失败"),
    CUSTOMER_PSW_ERROR(304,"账户或密码错误！"),
    CUSTOMER_EXIST(305,"账户已存在！"),
    CUSTOMER_REGISTER_FAIL(306,"注册失败！"),


    ;
    private Integer code;

    private String msg;

    ExceptionEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
