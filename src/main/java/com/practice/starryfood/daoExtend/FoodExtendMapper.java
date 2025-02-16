package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.FoodExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodExtendMapper {
    // 根据菜品id获取菜品信息
    FoodExtend getFoodById(String foodId);
    // 获取全部菜品
    List<FoodExtend> getAllFoods();
    // 获取指定种类下的全部菜品
    List<FoodExtend> getFoodsByOneKind(String foodKindId);
    // 根据菜品名称模糊查找菜品信息
    List<FoodExtend> getFoodsByNameLike(String keyName);
}
