package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.Order;

import java.util.List;

/**
 * @Project starryfood
 * @ClassName OrderExtend
 * @Author StarryHu
 * @Description 订单的扩展类（用于获取订单信息）
 * @Date 2019/12/2 9:04
 */
public class OrderExtend extends Order {
    // 订单创建时间的字符串（时间戳转）
    private String createTimeString;
    // 订单更新时间的字符串（时间戳转）
    private String updateTimeString;
    // 订单状态字符串
    private String orderConditionString;
    // 该订单的食品信息（使用扩展食品类 记录更全面的信息）
    List<OrderFoodExtend> orderFoodExtendList;

    public String getCreateTimeString() {
        return createTimeString;
    }

    public void setCreateTimeString(String createTimeString) {
        this.createTimeString = createTimeString;
    }

    public String getUpdateTimeString() {
        return updateTimeString;
    }

    public String getOrderConditionString() {
        return orderConditionString;
    }

    public void setOrderConditionString(String orderConditionString) {
        this.orderConditionString = orderConditionString;
    }

    public void setUpdateTimeString(String updateTimeString) {
        this.updateTimeString = updateTimeString;
    }

    public List<OrderFoodExtend> getOrderFoodExtendList() {
        return orderFoodExtendList;
    }

    public void setOrderFoodExtendList(List<OrderFoodExtend> orderFoodExtendList) {
        this.orderFoodExtendList = orderFoodExtendList;
    }

}
