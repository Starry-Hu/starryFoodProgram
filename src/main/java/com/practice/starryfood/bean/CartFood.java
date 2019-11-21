package com.practice.starryfood.bean;

import java.math.BigDecimal;

public class CartFood {
    private String cartFoodUuid;

    private String cartId;

    private String foodId;

    private Integer foodNum;

    private BigDecimal foodOneTotalPrice;

    public String getCartFoodUuid() {
        return cartFoodUuid;
    }

    public void setCartFoodUuid(String cartFoodUuid) {
        this.cartFoodUuid = cartFoodUuid;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Integer getFoodNum() {
        return foodNum;
    }

    public void setFoodNum(Integer foodNum) {
        this.foodNum = foodNum;
    }

    public BigDecimal getFoodOneTotalPrice() {
        return foodOneTotalPrice;
    }

    public void setFoodOneTotalPrice(BigDecimal foodOneTotalPrice) {
        this.foodOneTotalPrice = foodOneTotalPrice;
    }
}