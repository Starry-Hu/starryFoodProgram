package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.OrderExtend;

import java.util.List;

public interface OrderExtendMapper {
    List<OrderExtend> getAllOrderByCustomerUuid(String customerUuid);
}
