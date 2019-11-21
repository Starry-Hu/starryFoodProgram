package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.CartFoodExtend;
import com.practice.starryfood.pojo.CustomerExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerExtendMapper {
    // 获取全部顾客信息（未删除的）
    List<CustomerExtend> getAllCustomer();

    // 获取全部已删除的顾客信息
    List<CustomerExtend> getAllDeleteCustomer();
}
