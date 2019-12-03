package com.practice.starryfood.service;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.pojo.AdminExtend;

public interface AdminService {
    // 添加管理员
    int addAdmin(String adminId, String adminName, String adminPassword, String createUser) throws Exception;

    // 删除管理员（物理删除）
    int deleteAdmin(String adminUuid, String updateUser) throws Exception;

    // 更新管理员
    int updateAdmin(String adminUuid, String adminName, String adminPassword, String updateUser) throws Exception;

    // 查找管理员
    Admin getAdminByUuid(String adminUuid) throws Exception;

    Admin getAdminByAdminId(String adminId) throws Exception;

    // 获取全部管理员（带分页）
    PageInfo<AdminExtend> getAllAdmins(int pageNum, int pageSize) throws Exception;

    // 管理员登录
    Admin login(String adminId, String password) throws Exception;

    // 修改个人密码
    int editPersonPsw(String adminUuid, String oldPsw, String newPsw) throws Exception;

}
