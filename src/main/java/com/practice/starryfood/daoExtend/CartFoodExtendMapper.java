package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.CartFoodExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartFoodExtendMapper {
    // 获取某购物车全部菜品信息
    List<CartFoodExtend> getFoodsFromCart(String cartId);
    // 获取某购物车中某类菜品信息
    CartFoodExtend getFoodFromCartByFoodId(@Param("cartId") String cartId,
                                        @Param("foodId") String foodId);
}
