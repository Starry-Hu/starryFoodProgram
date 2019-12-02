package com.practice.starryfood.bean;

import java.util.Date;

public class FoodKind {
    private String foodKindId;

    private String foodKindName;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private Integer isDel;

    public String getFoodKindId() {
        return foodKindId;
    }

    public void setFoodKindId(String foodKindId) {
        this.foodKindId = foodKindId;
    }

    public String getFoodKindName() {
        return foodKindName;
    }

    public void setFoodKindName(String foodKindName) {
        this.foodKindName = foodKindName;
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
}