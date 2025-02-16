package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.pojo.FoodExtend;
import com.practice.starryfood.pojo.FoodKindExtend;

import java.math.BigDecimal;

public interface FoodService {
    // 添加菜品
    int addFood(String foodName, String foodKindId, BigDecimal foodPrice, String foodMeasurement,
                String foodIntroduce, String foodImg, String createUser) throws Exception;

    // 删除菜品
    int deleteFood(String foodId, String updateUser) throws Exception;

    // 更新菜品
    int updateFood(String foodId, String foodKindId, String foodName, BigDecimal foodPrice, String foodMeasurement,
                   String foodIntroduce, String foodImg, String updateUser) throws Exception;

    // 根据id获取菜品信息
    FoodExtend getFoodById(String foodId) throws Exception;

    // 获取全部菜品，带分页
    PageInfo<FoodExtend> getAllFoods(int pageNum, int pageSize) throws Exception;

    // 获取带种类的全部菜品，带分页
    PageInfo<FoodKindExtend> getAllFoodsWithKind(int pageNum, int pageSize) throws Exception;

    // 获取某种类下的菜品，带分页
    PageInfo<FoodExtend> getFoodsByOneKind(String foodKindId,int pageNum, int pageSize) throws Exception;

    // 根据名称模糊查找菜品
    PageInfo<FoodExtend> getFoodsByNameLike(String keyName,int pageNum, int pageSize) throws Exception;

}
