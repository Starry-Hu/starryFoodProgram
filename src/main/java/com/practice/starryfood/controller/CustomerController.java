package com.practice.starryfood.controller;

import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.CartFoodExtend;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.util.BaseResponse;
import com.practice.starryfood.util.OnlineUserListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
     * @param customerId 用户账户id
     * @param customerName 用户名
     * @param customerPassword 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    BaseResponse register(String customerId, String customerName, String customerPassword) throws Exception {
        // 检查内容是否填写完全
        if (customerId == null || customerName == null || customerPassword == null ||
                customerId.trim().equals("") || customerName.trim().equals("") || customerPassword.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.register(customerId, customerName, customerPassword);
        return ajaxSucc(null, ResultEnum.CUSTOMER_REGISTER_SUCCESS);
    }

    /**
     * 用户登录
     *
     * @param customerId      用户账户id
     * @param customerPassword 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    BaseResponse login(String customerId, String customerPassword, HttpSession session) throws Exception {
        // 检查内容是否填写完全
        if (customerId == null || customerPassword == null || customerId.trim().equals("") || customerPassword.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 设置session过期时间为1小时,并保存相应的顾客用户信息
        session.setMaxInactiveInterval(3600);

        Customer customer = customerService.login(customerId, customerPassword);
        session.setAttribute("customerUuid", customer.getCustomerUuid());
        session.setAttribute("customerId", customer.getCustomerId());
        session.setAttribute("customerName", customer.getCustomerName());

        return ajaxSucc(null, ResultEnum.CUSTOMER_LOGIN_SUCCESS);
    }

    /**
     * 获取当前登录的用户信息
     *
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/getLoginedCustomer")
    public BaseResponse getLoginedCustomer(HttpSession session) throws Exception {
        Map<String, String> resultMap = new HashMap<>();

        String customerUuid = (String) session.getAttribute("customerUuid");
        String customerName = (String) session.getAttribute("customerName");
        String customerId = (String) session.getAttribute("customerId");

        if (customerName != null) {
            resultMap.put("customerUuid", customerUuid);
            resultMap.put("customerId", customerId);
            resultMap.put("customerName", customerName);
            return ajaxSucc(resultMap, ResultEnum.SUCCESS);
        }
        return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
    }

    /**
     * 退出当前登陆  清除session
     *
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/logout")
    public BaseResponse customerLogout(HttpSession session) throws Exception {
        // 清除session
        session.removeAttribute("customerUuid");
        session.removeAttribute("customerName");
        session.removeAttribute("customerId");
        session.invalidate();
        return ajaxSucc(null, ResultEnum.SUCCESS);
    }

    /**
    * @Description:  修改用户个人信息/密码
    * @Param: [customerUuid, customerName, oldPassword, newPassword1, newPassword2, session, updateUser]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @PostMapping("/editMyInfo")
    public BaseResponse editMyInfo(String customerUuid, String customerName, String oldPassword, String newPassword1,
                                       String newPassword2, HttpSession session, String updateUser) throws Exception {
        // 检测信息是否完整
        if (customerUuid == null || customerName == null || newPassword1 == null || newPassword2 == null ||
                customerUuid.trim().equals("") || customerName.trim().equals("") ||
                newPassword1.trim().equals("") || newPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 两次输入密码不一样
        if (!newPassword1.equals(newPassword2)) {
            return ajaxFail(ResultEnum.CUSTOMER_NOT_SAME_PSWTWO);
        }
        customerService.editPersonInfo(customerUuid, customerName,oldPassword, newPassword1);
        return ajaxSucc(null, ResultEnum.CUSTOMER_UPDATE_SUCCESS);
    }

    /**
     * 删除用户
     *
     * @param customerUuid 用户uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    public BaseResponse delete(String customerUuid) throws Exception {
        // 检查内容是否填写完全
        if (customerUuid == null || customerUuid.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.deleteCustomer(customerUuid);
        return ajaxSucc(null, ResultEnum.CUSTOMER_DELETE_SUCCESS);
    }

    /**
     * 根据用户账户customerId查找用户
     *
     * @param customerId
     * @return
     * @throws Exception
     */
    @GetMapping("/getByCustomerId")
    public BaseResponse search(String customerId) throws Exception {
        // 检查内容是否填写完全
        if (customerId == null || customerId.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        Customer customer = customerService.getCustomerByCustomerId(customerId);
        return ajaxSucc(customer, ResultEnum.CUSTOMER_SEARCH_SUCCESS);
    }

    // ---------------------- 顾客购物车菜品相关（都是指当前用户而言的） ---------------------
    /***
     * 获取当前登录用户的购物车信息
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/logined/getCart")
    public BaseResponse getCart(HttpSession session) throws Exception {
        String customerUuid = (String) session.getAttribute("customerUuid");
        if (customerUuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);

        List<CartFoodExtend> data = customerService.getCustomerCart(customerUuid);
        return ajaxSucc(data, ResultEnum.SUCCESS);
    }

    /***
     * 添加菜品到当前登录顾客的购物车中
     * @param session
     * @param foodId
     * @param foodNum
     * @return
     * @throws Exception
     */
    @PostMapping("/logined/addToCart")
    public BaseResponse addFoodToCart(HttpSession session, String foodId, Integer foodNum) throws Exception {
        // 获取当前登录顾客
        String customerUuid = (String) session.getAttribute("customerUuid");
        if (customerUuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 判断添加菜品的id信息是否填写
        if (foodId == null || foodNum == null || foodId.trim().equals(""))
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);

        customerService.addFoodToCart(customerUuid, foodId, foodNum);
        return ajaxSucc(null, ResultEnum.CART_ADD_FOOD_SUCCESS);
    }

    /***
     * 当前登录用户 从购物车中删除菜品
     * @param session
     * @param foodId
     * @param foodNum
     * @return
     * @throws Exception
     */
    @PostMapping("/logined/deleteFromCart")
    public BaseResponse deleteFoodFromCart(HttpSession session, String foodId, Integer foodNum) throws Exception {
        // 获取当前登录顾客
        String customerUuid = (String) session.getAttribute("customerUuid");
        if (customerUuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 判断删除菜品的id信息是否填写
        if (foodId == null || foodNum == null || foodId.trim().equals(""))
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);
        customerService.deleteFoodFromCart(customerUuid, foodId, foodNum);
        return ajaxSucc(null, ResultEnum.CART_DELETE_FOOD_SUCCESS);
    }


    /**
     * 根据foodId从当前用户的购物车里面取出信息返回
     *
     * @param session
     * @param foodIdList
     * @return
     * @throws Exception
     */
    @PostMapping("/logined/getInfoFromCart")
    public BaseResponse getInfoFromCart(HttpSession session, @RequestParam(value = "foodIdList") List<String> foodIdList) throws Exception {
        // 获取当前登录顾客
        String customerUuid = (String) session.getAttribute("customerUuid");
        if (customerUuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 查看下单的菜品是否为空
        if (foodIdList == null || foodIdList.size() == 0)
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);
        List<CartFoodExtend> data = customerService.getInfoFromCart(customerUuid, foodIdList);
        return ajaxSucc(data, ResultEnum.FOOD_SEARCH_SUCCESS);
    }

    /**
     * 当前登录用户下单
     *
     * @param session
     * @param foodIdList
     * @return
     */
    @PostMapping("/logined/makeOrder")
    public BaseResponse makeOrder(HttpSession session, @RequestParam(value = "foodIdList") List<String> foodIdList) throws Exception {
        // 获取当前登录顾客
        String customerUuid = (String) session.getAttribute("customerUuid");
        if (customerUuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 查看下单的菜品是否为空
        if (foodIdList == null || foodIdList.size() == 0)
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);
        customerService.makeOrder(customerUuid, foodIdList);
        return ajaxSucc(null, ResultEnum.CART_MARK_ORDER_SUCCESS);
    }



    // ---------------------------------------------------------------------
    /***
    * @Description:  获取系统在线用户人数
    * @Param: [httpServletRequest, httpServletResponse]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/19
    */
    @GetMapping("/getOnlineCount")
    public BaseResponse getOnlineCount() throws Exception {
        // 获取当前人数
        return ajaxSucc( OnlineUserListener.online,ResultEnum.SUCCESS);
    }
}
