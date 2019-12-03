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
    ADMIN_ADD_SUCCESS(201,"添加管理员成功"),
    ADMIN_DELETE_SUCCESS(211,"删除管理员成功"),
    ADMIN_UPDATE_SUCCESS(221,"更新管理员信息成功"),
    ADMIN_SEARCH_SUCCESS(231,"查找管理员成功"),
    ADMIN_LOGIN_SUCCESS(241,"登录成功"),

    ADMIN_EDITPSW_PERSON_SUCCESS(251,"个人密码修改成功！"),

    ADMIN_VERIFY_FAIL(242,"验证码错误"),
    // --- 修改密码 ---
    ADMIN_NOT_SAME_PSWTWO(259,"两次输入密码不一致！"),
    ADMIN_INFO_NOT_FULL(299,"信息填写不完全"),


    // 顾客相关
    CUSTOMER_ADD_SUCCESS(301,"添加顾客成功"),
    CUSTOMER_DELETE_SUCCESS(311,"删除顾客成功"),
    CUSTOMER_UPDATE_SUCCESS(321,"更新顾客信息成功"),
    CUSTOMER_SEARCH_SUCCESS(331,"查找顾客成功"),
    CUSTOMER_LOGIN_SUCCESS(341,"登录成功"),
    CUSTOMER_REGISTER_SUCCESS(351,"注册成功"),
    CUSTOMER_RESTORE_SUCCESS(361,"还原成功"),

    CUSTOMER_NOT_LOGINED(397,"顾客未登录！请先登录！"),
    CUSTOMER_NOT_SAME_PSWTWO(398,"两次输入密码不一致！"),
    CUSTOMER_INFO_NOT_FULL(399,"信息填写不完全"),

    // 菜品相关
    FOOD_ADD_SUCCESS(401,"添加菜品成功"),
    FOOD_DELETE_SUCCESS(411,"删除菜品成功"),
    FOOD_UPDATE_SUCCESS(421,"更新菜品信息成功"),
    FOOD_SEARCH_SUCCESS(431,"查找成功"),
    FOOD_INFO_NOT_FULL(499,"信息填写不完全"),

    // 菜品种类相关
    FOOD_KIND_ADD_SUCCESS(501,"添加菜品种类成功"),
    FOOD_KIND_DELETE_SUCCESS(511,"删除菜品种类成功"),
    FOOD_KIND_UPDATE_SUCCESS(521,"更新菜品种类信息成功"),
    FOOD_KIND_SEARCH_SUCCESS(531,"查找菜品种类成功"),
    FOOD_KIND_INFO_NOT_FULL(599,"信息填写不完全"),

    // 购物车-菜品相关
    CART_ADD_FOOD_SUCCESS(601,"菜品添加到购物车成功"),
    CART_DELETE_FOOD_SUCCESS(611,"菜品从购物车删除成功"),
    CART_MARK_ORDER_SUCCESS(621,"下单成功"),
    CART_INFO_NOT_FULL(699,"信息填写不完全"),

    // 订单相关
    ORDER_SEARCH_SUCCESS(631,"订单查询成功"),
    ORDER_DELETE_SUCCESS(641,"订单删除成功"),
    ORDER_INFO_NOT_FULL(689,"信息填写不完全"),
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
