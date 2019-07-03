package com.practice.starryfood.service;

import com.practice.starryfood.bean.CartFood;
import com.practice.starryfood.bean.CartFoodExample;
import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.pojo.CartFoodExtend;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    // 添加用户
    int addCustomer(String id, String name, String password) throws Exception;

    // 删除用户
    int deleteCustomer(String uuid) throws Exception;

    // 更新用户
    int updateCustomer(String uuid, String id, String name, String password) throws Exception;

    // 查找用户(uuid/账户id)
    Customer getCustomerByuuid(String uuid) throws Exception;

    Customer getCustomerByCId(String id) throws Exception;

    // 登录
    Customer login(String id, String password) throws Exception;

    // 注册
    int register(String id, String name, String password) throws Exception;

    int editPersonPsw(String uuid, String oldPassword, String newPassword1);

    // --------------------------- 商品购物车相关 ---------------------
    // 添加菜品到购物车中
    int addFoodToCart(String uuid, String foodId, int foodNum) throws Exception;

    // 从购物车中删除菜品
    int deleteFoodFromCart(String uuid, String foodId, int foodNum) throws Exception;

    // 下单
    BigDecimal makeOrder(String uuid, List<String> foodIdList) throws Exception;

    // 获取用户的购物车信息
    List<CartFoodExtend> getCustomerCart(String uuid) throws Exception;
}
