package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.FoodExtend;

import java.util.List;

public interface FoodExtendMapper {
    // 获取全部菜品
    List<FoodExtend> getAllFoods();
}
