package com.practice.starryfood.controller;

import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.service.CustomerService;
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
 * @ClassName CustomerController
 * @Author StarryHu
 * @Description 顾客接口相关
 * @Date 2019/7/1 22:06
 */
@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;

    /***
     * 注册用户 （用户使用的接口）
     * @param id 用户账户id
     * @param name 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    BaseResponse register(String id,String name,String password) throws Exception{
        // 检查内容是否填写完全
        if (id == null || name == null ||password == null ||
                id.trim().equals("") || name.trim().equals("") ||password.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.register(id,name,password);
        return ajaxSucc(null,ResultEnum.CUSTOMER_REGISTER_SUCCESS);
    }

    /**
     * 用户登录
     * @param id 用户账户id
     * @param password 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    BaseResponse login(String id,String password,HttpSession session) throws Exception{
        // 检查内容是否填写完全
        if (id == null || password == null || id.trim().equals("") || password.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 设置session过期时间为永久,并保存相应的顾客用户信息
        session.setMaxInactiveInterval(-1);

        Customer customer = customerService.login(id,password);
        session.setAttribute("cuuid", customer.getUuid());
        session.setAttribute("cid", customer.getId());
        session.setAttribute("customerName",customer.getName());
        return ajaxSucc(null,ResultEnum.CUSTOMER_LOGIN_SUCCESS);
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

        String uuid = (String) session.getAttribute("cuuid");
        String name = (String) session.getAttribute("cname");
        String id = (String) session.getAttribute("cid");

        if (name != null) {
            resultMap.put("cuuid", id);
            resultMap.put("cid", id);
            resultMap.put("cname", name);
            return ajaxSucc(resultMap, ResultEnum.SUCCESS);
        }
        return ajaxFail(ResultEnum.FAIL);
    }

    /**
     * 修改个人密码
     * @param uuid 管理员id  uuid
     * @param oldPassword 输入的旧密码
     * @param newPassword1 第一次输入的新密码
     * @param newPassword2 第二次输入的新密码
     * @param updateUser 更新者
     * @return
     * @throws Exception
     */
    @PostMapping("/editMyPassword")
    public BaseResponse editMyPassword(String uuid,String oldPassword, String newPassword1,
                                       String newPassword2,HttpSession session,String updateUser) throws Exception {
        // 检测信息是否完整
        if (uuid == null || newPassword1 == null || newPassword2 == null || uuid.trim().equals("") ||
                newPassword1.trim().equals("") || newPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 两次输入密码不一样
        if (!newPassword1.equals(newPassword2)) {
            return ajaxFail(ResultEnum.ADMIN_NOT_SAME_PSWTWO);
        }
        customerService.editPersonPsw(uuid,oldPassword,newPassword1);
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
        session.removeAttribute("aid");
        session.removeAttribute("adminName");
        session.removeAttribute("adminId");
        return ajaxSucc(null, ResultEnum.SUCCESS);
    }

    /**
     * 删除用户
     * @param uuid 用户uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    BaseResponse delete(String uuid) throws Exception{
        // 检查内容是否填写完全
        if (uuid == null || uuid.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.deleteCustomer(uuid);
        return ajaxSucc(null,ResultEnum.CUSTOMER_DELETE_SUCCESS);
    }

    /**
     * 根据用户账户id查找用户
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/getByCId")
    BaseResponse search(String id) throws Exception{
        // 检查内容是否填写完全
        if (id == null || id.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        Customer customer = customerService.getCustomerByCId(id);
        return ajaxSucc(customer,ResultEnum.CUSTOMER_DELETE_SUCCESS);
    }
}
