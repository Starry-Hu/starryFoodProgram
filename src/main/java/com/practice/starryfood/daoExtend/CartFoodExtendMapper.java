package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.CartFoodExtend;

import java.util.List;

public interface CartFoodExtendMapper {
    // 获取某购物车菜品信息
    List<CartFoodExtend> getFoodsFromCart(String cartList_id);
}
