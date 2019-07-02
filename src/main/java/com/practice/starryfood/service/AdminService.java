package com.practice.starryfood.service;

import com.practice.starryfood.bean.Admin;

public interface AdminService {
    // 添加管理员
    int addAdmin(String adminId, String adminName, String password,String createUsr) throws Exception;

    // 删除管理员（物理删除）
    int deleteAdmin(String uuid,String updateUser) throws Exception;

    // 更新管理员
    int updateAdmin(String uuid, String adminId, String adminName, String password,String updateUser) throws Exception;

    // 查找管理员
    Admin getAdminByuuid(String uuid) throws Exception;

    Admin getAdminByAdminId(String adminId) throws Exception;

    // 管理员登录
    void login(String adminId, String password) throws Exception;
}
