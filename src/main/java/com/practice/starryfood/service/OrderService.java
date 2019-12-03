package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.pojo.OrderExtend;

public interface OrderService {
    // 根据条件查询订单信息（-1为全部订单信息，0为未处理订单，1为制作中订单，2为等待支付订单，3为已完成订单）
    PageInfo<OrderExtend> getOrders(int orderCondition, int pageNum, int pageSize) throws Exception;

    // 获取某顾客的全部订单信息（顾客uuid）[带分页]
    PageInfo<OrderExtend> getByCustomerUuid(String customerUuid, int pageNum, int pageSize) throws Exception;

    // 获取某顾客的全部订单信息（顾客id账号）[带分页]
    PageInfo<OrderExtend> getByCustomerId(String customerId, int pageNum, int pageSize) throws Exception;
}
