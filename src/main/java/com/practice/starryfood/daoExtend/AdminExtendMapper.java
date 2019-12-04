package com.practice.starryfood.daoExtend;

import com.practice.starryfood.pojo.AdminExtend;

import java.util.List;

public interface AdminExtendMapper {
    // 获取全部管理员
    List<AdminExtend> getAllAdmins();

    // 获取已删除管理员
    List<AdminExtend> getIsDeleteAdmins();
}
