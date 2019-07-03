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
    private String fname;
    // 食品单价
    private BigDecimal price;
    // 计量单位
    private String measurement;
    // 图片路径
    private String img;
    // 是否删除
    private int isDel;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public String getImg() {
        return img;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
