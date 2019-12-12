package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.pojo.OrderExtend;

public interface OrderService {
    // 【后台使用，简洁版，用于列表展示】获取某顾客的全部订单信息（顾客id账号）[带分页]
    PageInfo<OrderExtend> getByCustomerIdSimple(String customerId, int pageNum, int pageSize) throws Exception;

    // 【根据isDetail来判断是否详细查找】根据条件查询订单信息（-1为全部订单信息，0为未处理订单，1为制作中订单，2为等待支付订单，3为已完成订单）
    PageInfo<OrderExtend> getOrders(int orderCondition, int pageNum, int pageSize,boolean isDetail) throws Exception;

    // 【顾客自用，详细版，带菜品信息】获取某顾客的全部订单信息（顾客uuid）[带分页]
    PageInfo<OrderExtend> getByCustomerUuidDetail(String customerUuid, int pageNum, int pageSize) throws Exception;

    // 根据订单号获取某订单详细信息
    OrderExtend getByOrderId(String orderId) throws Exception;

    // ----------------------------------- 删除 -----------------------------------
    // 删除某订单(逻辑删除)
    int delete(String orderId,String updateUser) throws Exception;

    // 获取已删除的订单（列表显示）
    PageInfo<OrderExtend> getIsDelOrders(int pageNum, int pageSize) throws Exception;

    // 获取某顾客已删除的订单（列表显示）
    PageInfo<OrderExtend> getIsDelOrderByCustomerId(String customerId, int pageNum, int pageSize) throws Exception;

    // 更新订单状态
    int updateOrderCondition(String orderId, int orderCondition, String updateUser) throws Exception;
}
