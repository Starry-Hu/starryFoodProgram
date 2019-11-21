package com.practice.starryfood.dao;

import com.practice.starryfood.bean.OrderFood;
import com.practice.starryfood.bean.OrderFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFoodMapper {
    long countByExample(OrderFoodExample example);

    int deleteByExample(OrderFoodExample example);

    int deleteByPrimaryKey(String orderFoodUuid);

    int insert(OrderFood record);

    int insertSelective(OrderFood record);

    List<OrderFood> selectByExample(OrderFoodExample example);

    OrderFood selectByPrimaryKey(String orderFoodUuid);

    int updateByExampleSelective(@Param("record") OrderFood record, @Param("example") OrderFoodExample example);

    int updateByExample(@Param("record") OrderFood record, @Param("example") OrderFoodExample example);

    int updateByPrimaryKeySelective(OrderFood record);

    int updateByPrimaryKey(OrderFood record);
}