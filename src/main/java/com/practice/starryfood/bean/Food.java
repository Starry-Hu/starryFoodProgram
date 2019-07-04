package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Food {
    private String fid;

    private String fname;

    private BigDecimal price;

    private String measurement;

    private String img;

    private Integer hassold;

    private Date createtime;

    private Date updatetime;

    private String createuser;

    private String updateuser;

    private Integer isdel;

    private String introduce;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

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

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getHassold() {
        return hassold;
    }

    public void setHassold(Integer hassold) {
        this.hassold = hassold;
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

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}