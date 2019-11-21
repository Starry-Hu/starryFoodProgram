package com.practice.starryfood.service;

import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.pojo.CartFoodExtend;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    // 添加用户
    int addCustomer(String customerId, String name, String password) throws Exception;

    // 删除用户
    int deleteCustomer(String customerUuid) throws Exception;

    // 更新用户
    int updateCustomer(String customerUuid, String customerId, String customerName, String customerPassword) throws Exception;

    // 查找用户(uuid/账户id)
    Customer getCustomerByuuid(String customerUuid) throws Exception;

    Customer getCustomerByCustomerId(String customerId) throws Exception;

    // 登录
    Customer login(String customerId, String password) throws Exception;

    // 注册
    int register(String customerId, String customerName, String password) throws Exception;

    int editPersonInfo(String customerUuid, String customerName,String oldPassword, String newPassword1);

    // --------------------------- 商品购物车相关 ---------------------
    // 添加菜品到购物车中
    int addFoodToCart(String customerUuid, String foodId, int foodNum) throws Exception;

    // 从购物车中删除菜品
    int deleteFoodFromCart(String customerUuid, String foodId, int foodNum) throws Exception;

    // 从购物车里面查找菜品数组的信息
    List<CartFoodExtend> getInfoFromCart(String customerUuid, List<String> foodIdList) throws Exception;

    // 下单
    BigDecimal makeOrder(String customerUuid, List<String> foodIdList) throws Exception;

    // 获取用户的购物车信息
    List<CartFoodExtend> getCustomerCart(String customerUuid) throws Exception;
}
