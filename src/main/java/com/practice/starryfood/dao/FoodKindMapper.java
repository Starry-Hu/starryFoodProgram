package com.practice.starryfood.dao;

import com.practice.starryfood.bean.FoodKind;
import com.practice.starryfood.bean.FoodKindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodKindMapper {
    long countByExample(FoodKindExample example);

    int deleteByExample(FoodKindExample example);

    int deleteByPrimaryKey(String foodKindId);

    int insert(FoodKind record);

    int insertSelective(FoodKind record);

    List<FoodKind> selectByExample(FoodKindExample example);

    FoodKind selectByPrimaryKey(String foodKindId);

    int updateByExampleSelective(@Param("record") FoodKind record, @Param("example") FoodKindExample example);

    int updateByExample(@Param("record") FoodKind record, @Param("example") FoodKindExample example);

    int updateByPrimaryKeySelective(FoodKind record);

    int updateByPrimaryKey(FoodKind record);
}