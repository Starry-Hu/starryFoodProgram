package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.OrderExtend;

import java.util.List;

public interface OrderExtendMapper {
    // 根据顾客uuid获取其所有订单信息
    List<OrderExtend> getAllOrderByCustomerUuid(String customerUuid);

    // 获取所有订单信息
    List<OrderExtend> getAllOrders();

    // 获取未处理订单信息(0)
    List<OrderExtend> getUndoOrders();

    // 获取制作中订单信息(1)
    List<OrderExtend> getMakingOrders();

    // 获取等待支付订单信息(2)
    List<OrderExtend> getWaitPayOrders();

    // 获取已完成订单信息(3)
    List<OrderExtend> getDoneOrders();

    // 获取已删除订单
    List<OrderExtend> getIsDelOrders();

    // 获取某顾客的已删除订单
    List<OrderExtend> getIsDelOrderByCustomerId(String customerId);

    // 获取某一订单
    OrderExtend getByOrderId(String orderId);
}
