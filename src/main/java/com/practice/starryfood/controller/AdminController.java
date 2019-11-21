package com.practice.starryfood.controller;

import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.service.AdminService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
     * @param adminPassword 密码
     * @param session
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    BaseResponse login(String adminId, String adminPassword,String verifyCode, HttpSession session) throws Exception{
        // 检查内容是否填写完全
        if (adminId == null || adminPassword == null || verifyCode == null ||
                adminId.trim().equals("") || adminPassword.trim().equals("") || verifyCode.equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 检查验证码是否正确（都小写比较）
        if(!verifyCode.toLowerCase().equals(session.getAttribute("verify-code"))){
            return ajaxFail(ResultEnum.ADMIN_VERIFY_FAIL);
        }

        session.setMaxInactiveInterval(3600);
        Admin admin = adminService.login(adminId,adminPassword);
        session.setAttribute("adminUuid", admin.getAdminUuid());
        session.setAttribute("adminId", admin.getAdminId());
        session.setAttribute("adminName",admin.getAdminName());
        return ajaxSucc(null,ResultEnum.ADMIN_LOGIN_SUCCESS);
    }

    /**
     * 获取当前登录的管理员信息
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/getLoginedAdmin")
    public BaseResponse getLoginedAdmin(HttpSession session) throws Exception{
        Map<String, String> resultMap = new HashMap<>();

        String id = (String) session.getAttribute("adminUuid");
        String adminName = (String) session.getAttribute("adminName");
        String adminId = (String) session.getAttribute("adminId");

        if (adminName != null) {
            resultMap.put("adminUuid", id);
            resultMap.put("adminId", adminId);
            resultMap.put("adminName", adminName);
            return ajaxSucc(resultMap, ResultEnum.SUCCESS);
        }
        return ajaxFail(ResultEnum.FAIL);
    }

    /**
     * 修改个人密码(管理员修改自己的)
     * @param adminUuid 管理员id  uuid
     * @param oldPassword 输入的旧密码
     * @param newPassword1 第一次输入的新密码
     * @param newPassword2 第二次输入的新密码
     * @param updateUser 更新者
     * @return
     * @throws Exception
     */
    @PostMapping("/editMyPassword")
    public BaseResponse editMyPassword(String adminUuid,String oldPassword, String newPassword1,
                                       String newPassword2,HttpSession session,String updateUser) throws Exception {
        // 检测信息是否完整
        if (adminUuid == null || newPassword1 == null || newPassword2 == null || adminUuid.trim().equals("") ||
                newPassword1.trim().equals("") || newPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 两次输入密码不一样
        if (!newPassword1.equals(newPassword2)) {
            return ajaxFail(ResultEnum.ADMIN_NOT_SAME_PSWTWO);
        }
        adminService.editPersonPsw(adminUuid,oldPassword,newPassword1);
        return ajaxSucc(null,ResultEnum.ADMIN_EDITPSW_PERSON_SUCCESS);
    }


    /**
     * 退出当前登陆  清除session
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/logout")
    public BaseResponse adminLogout(HttpSession session) throws Exception{
        // 清除session
        //session.invalidate();
        session.removeAttribute("adminUuid");
        session.removeAttribute("adminName");
        session.removeAttribute("adminId");
        return ajaxSucc(null, ResultEnum.SUCCESS);
    }

    /**
     * 添加管理员信息
     * @param adminId 管理员账户
     * @param adminName 管理员名称
     * @param adminPassword 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    BaseResponse add(String adminId, String adminName, String adminPassword,String createUser) throws Exception{
        // 检查内容是否填写完全
        if (adminId == null || adminPassword == null || adminId.trim().equals("") || adminPassword.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        adminService.addAdmin(adminId,adminName,adminPassword,createUser);
        return ajaxSucc(null,ResultEnum.ADMIN_ADD_SUCCESS);
    }

    /**
     * 删除管理员(逻辑删除)
     * @param adminUuid 管理员uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    BaseResponse delete(String adminUuid,String updateUser) throws  Exception{
        // 检查内容是否填写完全
        if (adminUuid == null || adminUuid.trim().equals("")){
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        adminService.deleteAdmin(adminUuid,updateUser);
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
