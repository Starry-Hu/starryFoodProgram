package com.practice.starryfood.enums;

public enum ExceptionEnum {
    // 管理员相关
    ADMIN_ADD_FAIL(202,"用户添加失败"),
    ADMIN_ADD_EXIST(203,"该账户名已存在！"),
    ADMIN_DELETE_NOT_EXIST(212,"删除失败！该管理员不存在"),
    ADMIN_DELETE_FAIL(213,"删除失败！"),
    ADMIN_UPDATE_NOT_EXIST(222,"更新失败！该管理员不存在"),
    ADMIN_UPDATE_FAIL(222,"用户更新失败"),
    ADMIN_SEARCH_NOT_EXIST(232,"查找失败！该用户不存在"),
    ADMIN_LOGIN_NOT_EXIST(242,"登陆失败！该用户不存在"),
    ADMIN_LOGIN_PSW_ERROR(243,"登录失败！账户或密码错误！"),


    // 用户相关
    CUSTOMER_ADD_FAIL(302,"用户添加失败"),
    CUSTOMER_ADD_EXIST(303,"该账户名已存在！"),
    CUSTOMER_DELETE_NOT_EXIST(312,"删除失败！该用户不存在"),
    CUSTOMER_DELETE_FAIL(313,"删除失败！"),
    CUSTOMER_UPDATE_NOT_EXIST(322,"更新失败！该用户不存在"),
    CUSTOMER_UPDATE_FAIL(322,"用户更新失败"),
    CUSTOMER_SEARCH_NOT_EXIST(332,"查找失败！该用户不存在"),
    CUSTOMER_LOGIN_NOT_EXIST(342,"登陆失败！该用户不存在"),
    CUSTOMER_LOGIN_PSW_ERROR(343,"登录失败！账户或密码错误！"),
    CUSTOMER_REGISTER_EXIST(352,"注册失败！该用户名已存在！"),
    CUSTOMER_REGISTER_FAIL(353,"注册失败！"),


    // 菜品相关
    FOOD_ADD_FAIL(402,"菜品添加失败"),
    FOOD_DELETE_NOT_EXIST(412,"删除失败！菜品不存在"),
    FOOD_DELETE_FAIL(413,"菜品删除失败"),
    FOOD_UPDATE_NOT_EXIST(422,"更新失败！菜品不存在"),
    FOOD_UPDATE_FAIL(423,"菜品更新失败"),
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
