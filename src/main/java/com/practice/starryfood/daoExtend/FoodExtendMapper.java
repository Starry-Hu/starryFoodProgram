package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.FoodExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodExtendMapper {
    // 根据菜品id获取菜品信息
    FoodExtend getFoodById(String fid);
    // 获取全部菜品
    List<FoodExtend> getAllFoods();
}
