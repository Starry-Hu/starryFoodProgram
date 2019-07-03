package com.practice.starryfood.dao;

import com.practice.starryfood.bean.CartFood;
import com.practice.starryfood.bean.CartFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartFoodMapper {
    long countByExample(CartFoodExample example);

    int deleteByExample(CartFoodExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(CartFood record);

    int insertSelective(CartFood record);

    List<CartFood> selectByExample(CartFoodExample example);

    CartFood selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") CartFood record, @Param("example") CartFoodExample example);

    int updateByExample(@Param("record") CartFood record, @Param("example") CartFoodExample example);

    int updateByPrimaryKeySelective(CartFood record);

    int updateByPrimaryKey(CartFood record);
}