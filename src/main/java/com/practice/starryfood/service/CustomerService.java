package com.practice.starryfood.service;

import com.practice.starryfood.bean.Customer;

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
}
