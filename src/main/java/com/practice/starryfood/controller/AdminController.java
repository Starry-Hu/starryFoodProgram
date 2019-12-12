package com.practice.starryfood.controller;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.AdminExtend;
import com.practice.starryfood.pojo.OrderExtend;
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
    public BaseResponse login(String adminId, String adminPassword,String verifyCode, HttpSession session) throws Exception{
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
    * @Description: 修改个人密码(管理员修改自己的)
    * @Param: [adminUuid, oldPassword, newPassword1, newPassword2]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/4
    */
    @PostMapping("/editMyPassword")
    public BaseResponse editMyPassword(String adminUuid,String oldPassword, String newPassword1,
                                       String newPassword2) throws Exception {
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
    * @Description: 添加管理员信息
    * @Param: [adminId, adminName, adminPassword1, adminPassword2, createUser]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/3
    */
    @PostMapping("/add")
    public BaseResponse add(String adminId, String adminName, String adminPassword1,String adminPassword2,HttpSession session) throws Exception{
        // 检查内容是否填写完全
        if (adminId == null || adminName == null|| adminPassword1 == null || adminPassword2 == null
                || adminId.trim().equals("") || adminName.trim().equals("") || adminPassword1.trim().equals("") || adminPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 检查两次密码是否一致
        if (!adminPassword1.equals(adminPassword2)) return ajaxFail(ResultEnum.ADMIN_NOT_SAME_PSWTWO);

        // 获取当前登录的管理员
        String createUser = (String) session.getAttribute("adminUuid");

        adminService.addAdmin(adminId,adminName,adminPassword1,createUser);
        return ajaxSucc(null,ResultEnum.ADMIN_ADD_SUCCESS);
    }

    /**
    * @Description: 删除管理员(逻辑删除)
    * @Param: [adminUuid, updateUser]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/3
    */
    @GetMapping("/delete")
    public BaseResponse delete(String adminUuid,HttpSession session) throws  Exception{
        // 检查内容是否填写完全
        if (adminUuid == null || adminUuid.trim().equals("")){
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");

        adminService.deleteAdmin(adminUuid,updateUser);
        return ajaxSucc(null,ResultEnum.ADMIN_DELETE_SUCCESS);
    }

    /** 
    * @Description: 恢复已删除管理员 
    * @Param: [adminUuid, session] 
    * @return: com.practice.starryfood.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2019/12/4 
    */ 
    @GetMapping("/restoreDeleteAdmin")
    public BaseResponse restoreDeleteAdmin(String adminUuid,HttpSession session) throws  Exception{
        // 检查内容是否填写完全
        if (adminUuid == null || adminUuid.trim().equals("")){
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");

        adminService.restoreDeleteAdmin(adminUuid,updateUser);
        return ajaxSucc(null,ResultEnum.ADMIN_RESTORE_SUCCESS);
    }
    /***
    * @Description: 更新管理员（根据uuid）
    * @Param: [adminUuid, adminName, adminPassword1, adminPassword2, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/3
    */
    @PostMapping("/update")
    public BaseResponse update(String adminUuid, String adminName, String adminPassword1,String adminPassword2,HttpSession session) throws Exception{
        // 检查内容是否填写完全
        if (adminUuid == null || adminPassword1 == null || adminPassword2 == null
                || adminUuid.trim().equals("") || adminPassword1.trim().equals("") || adminPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 检查两次填写的密码是否一致
        if (!adminPassword1.equals(adminPassword2)) return ajaxFail(ResultEnum.ADMIN_NOT_SAME_PSWTWO);

        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");

        adminService.updateAdmin(adminUuid,adminName,adminPassword1,updateUser);
        return ajaxSucc(null,ResultEnum.ADMIN_UPDATE_SUCCESS);
    }

    /** 
    * @Description: 更新管理员名称
    * @Param: [adminUuid, adminName, session] 
    * @return: com.practice.starryfood.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2019/12/4 
    */ 
    @PostMapping("/updateName")
    public BaseResponse updateName(String adminUuid, String adminName,HttpSession session) throws Exception{
        // 检查内容是否填写完全
        if (adminUuid == null || adminName == null || adminUuid.trim().equals("") || adminName.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }

        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");

        adminService.updateAdminName(adminUuid,adminName,updateUser);
        return ajaxSucc(null,ResultEnum.ADMIN_UPDATE_SUCCESS);
    }
    
    // ------------------------------------ 查询管理员信息 ---------------------------------
    /**
     * 根据管理员账户名获取管理员对象
     * @param adminId 管理员账户名
     * @return
     * @throws Exception
     */
    @GetMapping("/getByAdminId")
    public BaseResponse getAdminByAdminId(String adminId) throws  Exception{
        // 检查内容是否填写完全
        if (adminId == null || adminId.trim().equals("")){
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        Admin admin = adminService.getAdminByAdminId(adminId);
        return ajaxSucc(admin,ResultEnum.ADMIN_SEARCH_SUCCESS);
    }

    /** 
    * @Description: 获取全部管理员 
    * @Param: [pageNum, pageSize] 
    * @return: com.practice.starryfood.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2019/12/3 
    */
    @GetMapping("/getAllAdmins")
    public BaseResponse getAllAdmins(Integer pageNum, Integer pageSize) throws  Exception{
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        PageInfo<AdminExtend> pageInfo = adminService.getAllAdmins(pageNum,pageSize);
        return ajaxSucc(pageInfo, ResultEnum.ADMIN_SEARCH_SUCCESS);
    }

    /**
     * @Description: 获取已删除管理员
     * @Param: [pageNum, pageSize]
     * @return: com.practice.starryfood.util.BaseResponse
     * @Author: StarryHu
     * @Date: 2019/12/4
     */
    @GetMapping("/getIsDeleteAdmins")
    public BaseResponse getIsDeleteAdmins(Integer pageNum, Integer pageSize) throws  Exception{
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        PageInfo<AdminExtend> pageInfo = adminService.getIsDeleteAdmins(pageNum,pageSize);
        return ajaxSucc(pageInfo, ResultEnum.ADMIN_SEARCH_SUCCESS);
    }
}
