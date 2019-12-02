package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.OrderFoodExtend;

import java.util.List;

public interface OrderFoodExtendMapper {
    // 根据订单号获取该订单的全部菜品信息
    List<OrderFoodExtend> getFoodByOrderId(String orderId);
}
