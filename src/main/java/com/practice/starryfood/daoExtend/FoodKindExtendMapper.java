package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.FoodKindExtend;

import java.util.List;

public interface FoodKindExtendMapper {
    // 获取全部菜品种类
    List<FoodKindExtend> getAllFoodKinds();
}
