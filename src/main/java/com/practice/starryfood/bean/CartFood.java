package com.practice.starryfood.bean;

import java.math.BigDecimal;

public class CartFood {
    private String uuid;

    private String cartlistId;

    private String foodId;

    private Integer foodNum;

    private BigDecimal foodOnetotalprice;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCartlistId() {
        return cartlistId;
    }

    public void setCartlistId(String cartlistId) {
        this.cartlistId = cartlistId;
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

    public BigDecimal getFoodOnetotalprice() {
        return foodOnetotalprice;
    }

    public void setFoodOnetotalprice(BigDecimal foodOnetotalprice) {
        this.foodOnetotalprice = foodOnetotalprice;
    }
}