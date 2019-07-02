package com.practice.starryfood.bean;

import java.util.Date;

public class Order {
    private String id;

    private Date paytime;

    private Date succtime;

    private Integer isDel;

    private Date createTime;

    private Date updateTime;

    private String createCustomer;

    private String dealAdmin;

    private Integer condition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getSucctime() {
        return succtime;
    }

    public void setSucctime(Date succtime) {
        this.succtime = succtime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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

    public String getCreateCustomer() {
        return createCustomer;
    }

    public void setCreateCustomer(String createCustomer) {
        this.createCustomer = createCustomer;
    }

    public String getDealAdmin() {
        return dealAdmin;
    }

    public void setDealAdmin(String dealAdmin) {
        this.dealAdmin = dealAdmin;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }
}