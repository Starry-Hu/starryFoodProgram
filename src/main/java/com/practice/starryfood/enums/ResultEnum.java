package com.practice.starryfood.enums;

/*** 
* @Description: 请求接口的返回的枚举信息
* @Param:  
* @return:  
* @Author: StarryHu
* @Date: 2019/7/1 
*/ 
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    FAIL(1,"失败"),

    // 管理员相关
    ADMIN_LOGIN_SUCCESS(201,"登录成功"),
    ADMIN_ADD_SUCCESS(202,"添加成功"),
    ADMIN_DELETE_SUCCESS(203,"删除成功"),
    ADMIN_SEARCH_SUCCESS(204,"查找成功"),
    ADMIN_INFO_NOT_FULL(221,"信息填写不完全"),

    // 用户相关
    CUSTOMER_LOGIN_SUCCESS(301,"登录成功"),
    CUSTOMER_ADD_SUCCESS(302,"添加成功"),
    CUSTOMER_REGISTER_SUCCESS(303,"注册成功"),
    CUSTOMER_DELETE_SUCCESS(304,"删除成功"),
    CUSTOMER_SEARCH_SUCCESS(305,"查找成功"),

    CUSTOMER_INFO_NOT_FULL(321,"信息填写不完全"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg){
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
