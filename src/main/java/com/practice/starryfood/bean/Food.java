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

    private Date createtime;

    private Date updatetime;

    private String createuser;

    private String updateuser;

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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
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