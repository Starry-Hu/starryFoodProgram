package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.Customer;

/**
 * @Project starryfood
 * @ClassName CustomerExtend
 * @Author StarryHu
 * @Description 顾客类的扩展对象(用于查找对象进行显示)
 * @Date 2019/11/21 18:41
 */
public class CustomerExtend extends Customer{
    // 注意查找出之后不填充密码和购物车id（无意义）

    // 创建时间的字符串（时间戳转）
    private String createTimeString ;
    // 更新时间的字符串（时间戳转）
    private String updateTimeString;

    public String getCreateTimeString() {
        return createTimeString;
    }

    public void setCreateTimeString(String createTimeString) {
        this.createTimeString = createTimeString;
    }

    public String getUpdateTimeString() {
        return updateTimeString;
    }

    public void setUpdateTimeString(String updateTimeString) {
        this.updateTimeString = updateTimeString;
    }
}
