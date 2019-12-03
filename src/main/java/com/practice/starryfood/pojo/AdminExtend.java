package com.practice.starryfood.pojo;

import com.practice.starryfood.bean.Admin;

/**
 * @Project starryfood
 * @ClassName AdminExtend
 * @Author StarryHu
 * @Description 管理员扩展类
 * @Date 2019/12/3 22:59
 */
public class AdminExtend extends Admin {
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
