package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.pojo.CartFoodExtend;
import com.practice.starryfood.pojo.CustomerExtend;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {
    // 添加顾客
    int addCustomer(String customerId, String name, String password) throws Exception;

    // 删除顾客
    int deleteCustomer(String customerUuid) throws Exception;

    // 更新顾客
    int updateCustomer(String customerUuid, String customerName, String customerPassword) throws Exception;

    // 查找顾客(uuid/账户id)
    Customer getCustomerByUuid(String customerUuid) throws Exception;

    Customer getCustomerByCustomerId(String customerId) throws Exception;

    // 查找所有顾客（带分页）
    PageInfo<CustomerExtend> getAllCustomer(Integer pageNum, Integer pageSize) throws Exception;

    // 查找所有已删除的顾客（带分页）
    PageInfo<CustomerExtend> getAllDeleteCustomer(Integer pageSize, Integer pageNum) throws Exception;

    // 将某个已删除的用户恢复
    int restoreDeleteCustomer(String customerUuid) throws Exception;

    // --------------------------- 顾客对自己账户的相关操作 ---------------------
    // 登录
    Customer login(String customerId, String password) throws Exception;

    // 注册
    int register(String customerId, String customerName, String password) throws Exception;

    // 修改个人信息
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

    // 获取顾客的购物车信息
    List<CartFoodExtend> getCustomerCart(String customerUuid) throws Exception;
}
