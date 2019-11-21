package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.pojo.FoodExtend;

import java.math.BigDecimal;

public interface FoodService {
    int addFood(String foodName, BigDecimal foodPrice, String foodMeasurement,
                String foodIntroduce, String foodImg, String createUser) throws Exception;

    int deleteFood(String foodId, String updateUser) throws Exception;

    int updateFood(String foodId, String foodName, BigDecimal foodPrice, String foodMeasurement,
               String foodIntroduce, String foodImg, String updateUser) throws Exception;

    // 根据id获取菜品信息
    FoodExtend getFoodById(String foodId) throws Exception;
    // 获取全部菜品，带分页
    PageInfo<FoodExtend> getAllFoods(int pageNum, int pageSize) throws Exception;
}
