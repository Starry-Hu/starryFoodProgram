package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.pojo.FoodExtend;

import java.math.BigDecimal;

public interface FoodService {
    int addFood(String fname, BigDecimal price, String measurement,
                String introduce, String img, String createUser) throws Exception;

    int deleteFood(String id, String updateUser) throws Exception;

    int updateFood(String fid, String fname, BigDecimal price, String measurement,
               String introduce, String img, String updateUser) throws Exception;

    // 根据id获取菜品信息
    FoodExtend getFoodById(String fid) throws Exception;
    // 获取全部菜品，带分页
    PageInfo<FoodExtend> getAllFoods(int pageNum, int pageSize) throws Exception;
}
