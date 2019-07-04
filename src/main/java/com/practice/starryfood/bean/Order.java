package com.practice.starryfood.bean;

import java.util.Date;

public class Order {
    private String id;

    private Integer isdel;

    private Date createtime;

    private Date updatetime;

    private String createcustomer;

    private String dealadmin;

    private Integer condition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
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

    public String getCreatecustomer() {
        return createcustomer;
    }

    public void setCreatecustomer(String createcustomer) {
        this.createcustomer = createcustomer;
    }

    public String getDealadmin() {
        return dealadmin;
    }

    public void setDealadmin(String dealadmin) {
        this.dealadmin = dealadmin;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }
}