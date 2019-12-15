package com.practice.starryfood.controller;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.CartFoodExtend;
import com.practice.starryfood.pojo.CustomerExtend;
import com.practice.starryfood.pojo.FoodExtend;
import com.practice.starryfood.pojo.OrderExtend;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.service.OrderService;
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
    @Autowired
    private OrderService orderService;

    // ----------------------------------------- 顾客的注册、登录、退出、修改个人信息 -------------------------------------------
    /**
    * @Description:  注册顾客 （顾客使用的接口）
    * @Param: [customerId, customerName, customerPassword]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
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
    * @Description: 顾客登录
    * @Param: [customerId, customerPassword, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @PostMapping("/login")
    BaseResponse login(String customerId, String customerPassword, HttpSession session) throws Exception {
        // 检查内容是否填写完全
        if (customerId == null || customerPassword == null || customerId.trim().equals("") || customerPassword.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 设置session过期时间为1小时,并保存相应的顾客顾客信息
        session.setMaxInactiveInterval(3600);

        Customer customer = customerService.login(customerId, customerPassword);
        session.setAttribute("customerUuid", customer.getCustomerUuid());
        session.setAttribute("customerId", customer.getCustomerId());
        session.setAttribute("customerName", customer.getCustomerName());

        return ajaxSucc(null, ResultEnum.CUSTOMER_LOGIN_SUCCESS);
    }

    /**
     * 获取当前登录的顾客信息
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
    * @Description:  修改顾客个人信息/密码
    * @Param: [customerUuid, customerName, oldPassword, newPassword1, newPassword2]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @PostMapping("/editMyInfo")
    public BaseResponse editMyInfo(String customerUuid, String customerName, String oldPassword, String newPassword1,
                                       String newPassword2) throws Exception {
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

    // ---------------------------------------------   管理员对顾客的增删改  -------------------------------------------
    /** 
    * @Description: 管理员添加用户 
    * @Param: [customerId, customerName, customerPassword] 
    * @return: com.practice.starryfood.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2019/11/21 
    */ 
    @PostMapping("/add")
    BaseResponse add(String customerId, String customerName, String customerPassword1, String customerPassword2) throws Exception {
        // 检查内容是否填写完全
        if (customerId == null || customerName == null || customerPassword1 == null || customerPassword2 == null ||
                customerId.trim().equals("") || customerName.trim().equals("")
                || customerPassword1.trim().equals("") || customerPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }

        // 检查两次密码是否正确
        if (!customerPassword1.equals(customerPassword2))
            return ajaxFail(ResultEnum.CUSTOMER_NOT_SAME_PSWTWO);

        customerService.register(customerId, customerName, customerPassword1);
        return ajaxSucc(null, ResultEnum.CUSTOMER_REGISTER_SUCCESS);
    }

    /**
    * @Description: 管理员删除顾客 （逻辑删除）
    * @Param: [customerUuid]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
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

    @PostMapping("/update")
    public BaseResponse update(String customerUuid,String customerName, String newPassword1,
                               String newPassword2) throws Exception {
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
        // 更新
        customerService.updateCustomer(customerUuid,customerName,newPassword1);
        return ajaxSucc(null, ResultEnum.CUSTOMER_UPDATE_SUCCESS);
    }
    /**
     * 根据顾客账户customerId查找顾客
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

    /**
    * @Description: 获取全部顾客（带分页）
    * @Param: [pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/22
    */
    @GetMapping("/getAllCustomer")
    public BaseResponse getAllCustomer(Integer pageNum,Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        // 进行查找
        PageInfo<CustomerExtend> pageInfo =  customerService.getAllCustomer(pageNum,pageSize);
        return ajaxSucc(pageInfo,ResultEnum.CUSTOMER_SEARCH_SUCCESS);
    }

    /**
    * @Description: 获取全部已删除的用户列表（带分页）
    * @Param: [pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/22
    */
    @GetMapping("/getAllDeleteCustomer")
    public BaseResponse getAllDeleteCustomer(Integer pageNum,Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        // 进行查找
        PageInfo<CustomerExtend> pageInfo =  customerService.getAllDeleteCustomer(pageNum,pageSize);
        return ajaxSucc(pageInfo,ResultEnum.CUSTOMER_SEARCH_SUCCESS);
    }

    /**
    * @Description: 将已删除的顾客还原
    * @Param: [customerUuid]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/22
    */
    @GetMapping("/restoreDeleteCustomer")
    public BaseResponse restoreDeleteCustomer(String customerUuid) throws Exception {
        if (customerUuid == null || customerUuid.trim().equals(""))
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        customerService.restoreDeleteCustomer(customerUuid);
        return ajaxSucc(null,ResultEnum.CUSTOMER_RESTORE_SUCCESS);
    }
    // -------------------------------------- 顾客购物车菜品相关（都是指当前顾客而言的） -----------------------------
    /***
     * 获取当前登录顾客的购物车信息
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

    /**
    * @Description: 添加菜品到当前登录顾客的购物车中
    * @Param: [session, foodId, foodNum]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/15
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

    /**
    * @Description:  当前登录顾客 从购物车中删除菜品
    * @Param: [session, foodId, foodNum]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/15
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
     * 根据foodId从当前顾客的购物车里面取出信息返回
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
     * 当前登录顾客下单
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
        customerService.makeOrder(foodIdList,session);
        return ajaxSucc(null, ResultEnum.CART_MARK_ORDER_SUCCESS);
    }


    /**
    * @Description: 获取当前登录顾客的全部订单信息
    * @Param: [session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    @GetMapping("/logined/getAllOrder")
    public BaseResponse getAllOrder(HttpSession session,Integer pageNum, Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        // 获取当前登录顾客
        String customerUuid = (String) session.getAttribute("customerUuid");
        if (customerUuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);

        // 获取该顾客的全部订单信息数组（包括每个订单的菜品信息）
        PageInfo<OrderExtend> pageInfo = orderService.getByCustomerUuidDetail(customerUuid,pageNum,pageSize);

        return ajaxSucc(pageInfo, ResultEnum.ORDER_SEARCH_SUCCESS);
    }

    // ---------------------------------------------------------------------
    /***
    * @Description:  获取系统在线顾客人数
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
