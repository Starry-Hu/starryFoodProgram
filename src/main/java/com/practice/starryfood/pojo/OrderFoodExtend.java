package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.OrderFood;

import java.math.BigDecimal;

/**
 * @Project starryfood
 * @ClassName OrderFoodExtend
 * @Author StarryHu
 * @Description 订单-菜品的扩展类
 * @Date 2019/12/2 8:48
 */
public class OrderFoodExtend extends OrderFood {
    // 食品名称
    private String foodName;
    // 食品单价
    private BigDecimal foodPrice;
    // 计量单位
    private String foodMeasurement;
    // 图片路径
    private String foodImg;

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
}
