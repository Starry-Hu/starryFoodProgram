package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.FoodKind;

/**
 * @Project starryfood
 * @ClassName FoodKindExtend
 * @Author StarryHu
 * @Description 菜品种类扩展类
 * @Date 2019/12/2 16:32
 */
public class FoodKindExtend extends FoodKind {
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
