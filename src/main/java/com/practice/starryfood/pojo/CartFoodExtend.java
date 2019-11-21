package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.CartFood;

import java.math.BigDecimal;

/**
 * @Project starryfood
 * @ClassName CartFoodExtend
 * @Author StarryHu
 * @Description 购物车-菜品扩展对象
 * @Date 2019/7/3 22:44
 */
public class CartFoodExtend extends CartFood {
    // 食品名称
    private String foodName;
    // 食品单价
    private BigDecimal foodPrice;
    // 计量单位
    private String foodMeasurement;
    // 图片路径
    private String foodImg;
    // 是否删除
    private int isDel;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public BigDecimal getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(BigDecimal foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodMeasurement() {
        return foodMeasurement;
    }

    public void setFoodMeasurement(String foodMeasurement) {
        this.foodMeasurement = foodMeasurement;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}
