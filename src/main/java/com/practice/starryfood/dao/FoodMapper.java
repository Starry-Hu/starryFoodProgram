package com.practice.starryfood.dao;

import com.practice.starryfood.bean.Food;
import com.practice.starryfood.bean.FoodExample;
import com.practice.starryfood.bean.FoodWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodMapper {
    long countByExample(FoodExample example);

    int deleteByExample(FoodExample example);

    int deleteByPrimaryKey(String id);

    int insert(FoodWithBLOBs record);

    int insertSelective(FoodWithBLOBs record);

    List<FoodWithBLOBs> selectByExampleWithBLOBs(FoodExample example);

    List<Food> selectByExample(FoodExample example);

    FoodWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FoodWithBLOBs record, @Param("example") FoodExample example);

    int updateByExampleWithBLOBs(@Param("record") FoodWithBLOBs record, @Param("example") FoodExample example);

    int updateByExample(@Param("record") Food record, @Param("example") FoodExample example);

    int updateByPrimaryKeySelective(FoodWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(FoodWithBLOBs record);

    int updateByPrimaryKey(Food record);
}