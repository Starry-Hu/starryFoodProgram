package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.Food;

/**
 * @Project starryfood
 * @ClassName FoodExtend
 * @Author StarryHu
 * @Description 菜品扩展类
 * @Date 2019/7/2 11:05
 */
public class FoodExtend extends Food {
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
