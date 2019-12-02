package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String orderId;

    private String orderCreateCustomer;

    private Date orderCreateTime;

    private BigDecimal orderSumPrice;

    private String orderDealAdmin;

    private Date orderUpdateTime;

    private Integer orderCondition;

    private Integer isDel;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCreateCustomer() {
        return orderCreateCustomer;
    }

    public void setOrderCreateCustomer(String orderCreateCustomer) {
        this.orderCreateCustomer = orderCreateCustomer;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public BigDecimal getOrderSumPrice() {
        return orderSumPrice;
    }

    public void setOrderSumPrice(BigDecimal orderSumPrice) {
        this.orderSumPrice = orderSumPrice;
    }

    public String getOrderDealAdmin() {
        return orderDealAdmin;
    }

    public void setOrderDealAdmin(String orderDealAdmin) {
        this.orderDealAdmin = orderDealAdmin;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    public Integer getOrderCondition() {
        return orderCondition;
    }

    public void setOrderCondition(Integer orderCondition) {
        this.orderCondition = orderCondition;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}