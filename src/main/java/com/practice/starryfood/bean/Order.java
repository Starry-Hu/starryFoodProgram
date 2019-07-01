package com.practice.starryfood.bean;

import java.util.Date;

public class Order {
    private String id;

    private Date paytime;

    private Date succtime;

    private String customer;

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

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}