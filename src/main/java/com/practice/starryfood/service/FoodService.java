package com.practice.starryfood.service;

import com.practice.starryfood.bean.Food;

import java.math.BigDecimal;
import java.util.List;

public interface FoodService {
    // 添加菜品
    int addFood(String name, BigDecimal price, String measurement, String introduce, String img, String createUser) throws Exception;

    // 删除菜品（逻辑删除 - 防止订单中菜品空指针异常）
    int deleteFood(String id, String updateUser) throws Exception;

    // 更新菜品
    int updateFood(String id, String name, BigDecimal price, String measurement, String introduce, String img, String updateUser) throws Exception;

    // 查找菜品
    int getFoodByName() throws Exception;

    // 获取全部菜品，带分页
    List<Food> getAllFoods(int pageNum, int pageSize) throws Exception;
}
