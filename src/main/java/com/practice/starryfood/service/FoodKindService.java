package com.practice.starryfood.service;

import com.practice.starryfood.pojo.FoodKindExtend;

import java.util.List;

public interface FoodKindService {
    // 添加菜品种类
    int addFoodKind(String foodKindName, String createUser) throws Exception;

    // 删除菜品种类（逻辑删除）
    int deleteFoodKind(String foodKindId, String updateUser) throws Exception;

    // 更新菜品种类
    int updateFoodKind(String foodKindId,String foodKindName, String updateUser) throws Exception;

    // 获取全部菜品种类
    List<FoodKindExtend> getAllFoodKinds() throws Exception;
}
