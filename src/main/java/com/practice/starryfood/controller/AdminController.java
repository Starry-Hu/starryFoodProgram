package com.practice.starryfood.controller;

import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.dao.AdminMapper;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.service.AdminService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Project starryfood
 * @ClassName AdminController
 * @Author StarryHu
 * @Description 管理员接口相关
 * @Date 2019/7/1 21:41
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BaseController{
    @Autowired
    private AdminService adminService;

    /***
     * 登录
     * @param adminId 管理员账号
     * @param password 密码
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    BaseResponse login(String adminId, String password, HttpSession session) throws Exception{
        // 检查内容是否填写完全
        if (adminId == null || password == null || adminId.trim().equals("") || password.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        adminService.login(adminId,password);
        return ajaxSucc(null,ResultEnum.ADMIN_LOGIN_SUCCESS);
    }

    /**
     * 添加管理员信息
     * @param adminId 管理员账户
     * @param adminName 管理员名称
     * @param password 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    BaseResponse add(String adminId, String adminName, String password) throws Exception{
        // 检查内容是否填写完全
        if (adminId == null || password == null || adminId.trim().equals("") || password.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        adminService.addAdmin(adminId,adminName,password);
        return ajaxSucc(null,ResultEnum.ADMIN_ADD_SUCCESS);
    }

    /**
     * 删除管理员
     * @param uuid 管理员uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    BaseResponse delete(String uuid) throws  Exception{
        // 检查内容是否填写完全
        if (uuid == null || uuid.trim().equals("")){
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        adminService.deleteAdmin(uuid);
        return ajaxSucc(null,ResultEnum.ADMIN_DELETE_SUCCESS);
    }

    /**
     * 根据管理员账户名获取管理员对象
     * @param adminId 管理员账户名
     * @return
     * @throws Exception
     */
    @GetMapping("/getByAdminId")
    BaseResponse getAdminByAdminId(String adminId) throws  Exception{
        // 检查内容是否填写完全
        if (adminId == null || adminId.trim().equals("")){
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        Admin admin = adminService.getAdminByAdminId(adminId);
        return ajaxSucc(admin,ResultEnum.ADMIN_SEARCH_SUCCESS);
    }

}
