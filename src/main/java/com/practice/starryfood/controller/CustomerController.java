package com.practice.starryfood.controller;

import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    BaseResponse login(String id,String password) throws Exception{
        // 检查内容是否填写完全
        if (id == null || password == null || id.trim().equals("") || password.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.login(id,password);
        return ajaxSucc(null,ResultEnum.CUSTOMER_LOGIN_SUCCESS);
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
