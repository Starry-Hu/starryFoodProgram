package com.practice.starryfood.enums;

public enum ExceptionEnum {
    // 管理员相关
    ADMIN_ADD_FAIL(202,"管理员添加失败"),
    ADMIN_ADD_EXIST(203,"添加失败！该管理员账户已存在！"),
    ADMIN_DELETE_NOT_EXIST(212,"删除失败！该管理员不存在"),
    ADMIN_DELETE_FAIL(213,"删除失败！"),
    ADMIN_UPDATE_NOT_EXIST(222,"更新失败！该管理员不存在"),
    ADMIN_UPDATE_FAIL(222,"顾客更新失败"),
    ADMIN_SEARCH_NOT_EXIST(232,"查找失败！该管理员不存在"),
    ADMIN_LOGIN_NOT_EXIST(242,"登陆失败！该管理员不存在"),
    ADMIN_LOGIN_PSW_ERROR(243,"登录失败！账户或密码错误！"),
    ADMIN_EDITPSW_NOT_EXIST(252,"修改密码失败！该管理员不存在！"),
    ADMIN_EDITPSW_OLDPSW_ERROR(253, "原密码错误！"),
    ADMIN_EDITPSW_SAME_WITH_OLD(254,"新旧密码一致！无变化！"),
    ADMIN_EDITPSW_FAIL(255,"修改密码失败！"),
    ADMIN_IS_RESTORE_NOW(266,"该管理员已还原！"),
    ADMIN_RESTORE_FAIL(267,"该管理员还原失败！"),

    // 顾客相关
    CUSTOMER_ADD_FAIL(302,"顾客添加失败"),
    CUSTOMER_ADD_EXIST(303,"该账户名已存在！"),
    CUSTOMER_DELETE_NOT_EXIST(312,"删除失败！该顾客不存在"),
    CUSTOMER_DELETE_FAIL(313,"删除失败！"),
    CUSTOMER_UPDATE_NOT_EXIST(322,"更新失败！该顾客不存在"),
    CUSTOMER_UPDATE_FAIL(322,"顾客更新失败"),
    CUSTOMER_SEARCH_NOT_EXIST(332,"查找失败！该顾客不存在"),
    CUSTOMER_LOGIN_NOT_EXIST(342,"登陆失败！该顾客不存在"),
    CUSTOMER_LOGIN_PSW_ERROR(343,"登录失败！账户或密码错误！"),
    CUSTOMER_REGISTER_EXIST(352,"注册失败！该顾客名已存在！"),
    CUSTOMER_REGISTER_FAIL(353,"注册失败！"),
    CUSTOMER_EDITPSW_NOT_EXIST(362,"修改密码失败！该顾客不存在！"),
    CUSTOMER_EDITPSW_OLDPSW_ERROR(363, "原密码错误！"),
    CUSTOMER_EDITPSW_SAME_WITH_OLD(364,"新旧密码一致！无变化！"),
    CUSTOMER_EDITPSW_FAIL(365,"修改密码失败！"),
    CUSTOMER_IS_RESTORE_NOW(366,"该顾客已还原！"),
    CUSTOMER_RESTORE_FAIL(367,"该顾客还原失败！"),


    // 菜品相关
    FOOD_ADD_FAIL(402,"菜品添加失败"),
    FOOD_DELETE_NOT_EXIST(412,"删除失败！菜品不存在"),
    FOOD_DELETE_FAIL(413,"菜品删除失败"),
    FOOD_UPDATE_NOT_EXIST(422,"更新失败！菜品不存在"),
    FOOD_UPDATE_FAIL(423,"菜品更新失败"),
    FOOD_SEARCH_NULL(432,"查找失败！菜品为空！无内容"),

    // 菜品种类相关
    FOOD_KIND_ADD_FAIL(502,"菜品种类添加失败"),
    FOOD_KIND_DELETE_NOT_EXIST(512,"菜品种类不存在！删除失败"),
    FOOD_KIND_DELETE_CASCADE(522,"该菜品种类下仍有相关菜品！请先删除相关菜品再进行种类的删除！"),
    FOOD_KIND_DELETE_FAIL(532,"菜品种类删除失败"),
    FOOD_KIND_UPDATE_NOT_EXIST(542,"更新失败！菜品种类不存在"),
    FOOD_KIND_UPDATE_FAIL(552,"菜品种类更新失败"),
    FOOD_KIND_SEARCH_NOT_EXIST(562,"查找失败！菜品种类不存在"),

    // 购物车相关
    CART_ADD_FOOD_FAIL(602,"添加菜品到购物车失败！"),
    CART_DELETE_FOOD_EMPTY(612,"购物车中删除菜品失败！该菜品在购物车中已空！"),
    CART_DELETE_FOOD_FAIL(613,"购物车中删除菜品失败！"),
    CART_PAY_FOOD_FAIL(623,"下单失败"),
    CART_EMPTY(632,"购物车为空！"),

    // 订单相关
    ORDER_DELETE_FAIL(722,"删除订单失败！"),
    ORDER_UPDATE_FAIL(723,"更新订单失败！"),
    ORDER_NOT_EXIST(732,"该订单不存在！"),
    ORDER_SEARCH_ERROR(742,"订单查询条件出错！"),
    ORDER_EMPTY(752,"订单列表为空！"),
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
