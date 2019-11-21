package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Food {
    private String foodId;

    private String foodName;

    private BigDecimal foodPrice;

    private String foodMeasurement;

    private String foodImg;

    private Integer foodHasSold;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private Integer isDel;

    private String foodIntroduce;

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

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

    public Integer getFoodHasSold() {
        return foodHasSold;
    }

    public void setFoodHasSold(Integer foodHasSold) {
        this.foodHasSold = foodHasSold;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getFoodIntroduce() {
        return foodIntroduce;
    }

    public void setFoodIntroduce(String foodIntroduce) {
        this.foodIntroduce = foodIntroduce;
    }
}