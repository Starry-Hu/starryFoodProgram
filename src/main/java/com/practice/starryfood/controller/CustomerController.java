package com.practice.starryfood.controller;

import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.CartFoodExtend;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @param cid 用户账户id
     * @param name 用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/register")
    BaseResponse register(String cid, String name, String password) throws Exception {
        // 检查内容是否填写完全
        if (cid == null || name == null || password == null ||
                cid.trim().equals("") || name.trim().equals("") || password.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.register(cid, name, password);
        return ajaxSucc(null, ResultEnum.CUSTOMER_REGISTER_SUCCESS);
    }

    /**
     * 用户登录
     *
     * @param cid      用户账户id
     * @param password 密码
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    BaseResponse login(String cid, String password, HttpSession session) throws Exception {
        // 检查内容是否填写完全
        if (cid == null || password == null || cid.trim().equals("") || password.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 设置session过期时间为永久,并保存相应的顾客用户信息
        session.setMaxInactiveInterval(-1);

        Customer customer = customerService.login(cid, password);
        session.setAttribute("cuuid", customer.getUuid());
        session.setAttribute("cid", customer.getCid());
        session.setAttribute("customerName", customer.getCname());
        return ajaxSucc(null, ResultEnum.CUSTOMER_LOGIN_SUCCESS);
    }

    /**
     * 获取当前登录的管理员信息
     *
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/getLoginedAdmin")
    public BaseResponse getLoginedAdmin(HttpSession session) throws Exception {
        Map<String, String> resultMap = new HashMap<>();

        String uuid = (String) session.getAttribute("cuuid");
        String name = (String) session.getAttribute("cname");
        String cid = (String) session.getAttribute("cid");

        if (name != null) {
            resultMap.put("cuuid", cid);
            resultMap.put("cid", cid);
            resultMap.put("cname", name);
            return ajaxSucc(resultMap, ResultEnum.SUCCESS);
        }
        return ajaxFail(ResultEnum.FAIL);
    }

    /**
     * 修改个人密码
     *
     * @param uuid         管理员id  uuid
     * @param oldPassword  输入的旧密码
     * @param newPassword1 第一次输入的新密码
     * @param newPassword2 第二次输入的新密码
     * @param updateUser   更新者
     * @return
     * @throws Exception
     */
    @PostMapping("/editMyPassword")
    public BaseResponse editMyPassword(String uuid, String oldPassword, String newPassword1,
                                       String newPassword2, HttpSession session, String updateUser) throws Exception {
        // 检测信息是否完整
        if (uuid == null || newPassword1 == null || newPassword2 == null || uuid.trim().equals("") ||
                newPassword1.trim().equals("") || newPassword2.trim().equals("")) {
            return ajaxFail(ResultEnum.ADMIN_INFO_NOT_FULL);
        }
        // 两次输入密码不一样
        if (!newPassword1.equals(newPassword2)) {
            return ajaxFail(ResultEnum.ADMIN_NOT_SAME_PSWTWO);
        }
        customerService.editPersonPsw(uuid, oldPassword, newPassword1);
        return ajaxSucc(null, ResultEnum.ADMIN_EDITPSW_PERSON_SUCCESS);
    }


    /**
     * 退出当前登陆  清除session
     *
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/logout")
    public BaseResponse adminLogout(HttpSession session) throws Exception {
        // 清除session
        //session.invalidate();
        session.removeAttribute("cuuid");
        session.removeAttribute("cname");
        session.removeAttribute("cid");
        return ajaxSucc(null, ResultEnum.SUCCESS);
    }

    /**
     * 删除用户
     *
     * @param uuid 用户uuid
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    public BaseResponse delete(String uuid) throws Exception {
        // 检查内容是否填写完全
        if (uuid == null || uuid.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        customerService.deleteCustomer(uuid);
        return ajaxSucc(null, ResultEnum.CUSTOMER_DELETE_SUCCESS);
    }

    /**
     * 根据用户账户cid查找用户
     *
     * @param cid
     * @return
     * @throws Exception
     */
    @GetMapping("/getByCId")
    public BaseResponse search(String cid) throws Exception {
        // 检查内容是否填写完全
        if (cid == null || cid.trim().equals("")) {
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        Customer customer = customerService.getCustomerByCId(cid);
        return ajaxSucc(customer, ResultEnum.CUSTOMER_DELETE_SUCCESS);
    }

    // ---------------------- 顾客购物车菜品相关 ---------------------

    /***
     * 添加菜品到当前登录顾客的购物车中
     * @param session
     * @param foodId
     * @param foodNum
     * @return
     * @throws Exception
     */
    @PostMapping("/addToCart")
    public BaseResponse addFoodToCart(HttpSession session, String foodId, Integer foodNum) throws Exception {
        // 获取当前登录顾客
        String cuuid = (String) session.getAttribute("cuuid");
        if (cuuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 判断添加菜品的id信息是否填写
        if (foodId == null || foodNum == null || foodId.trim().equals(""))
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);

        customerService.addFoodToCart(cuuid, foodId, foodNum);
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
    @PostMapping("/deleteFromCart")
    public BaseResponse deleteFoodFromCart(HttpSession session, String foodId, Integer foodNum) throws Exception {
        // 获取当前登录顾客
        String cuuid = (String) session.getAttribute("cuuid");
        if (cuuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 判断删除菜品的id信息是否填写
        if (foodId == null || foodNum == null || foodId.trim().equals(""))
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);
        customerService.deleteFoodFromCart(cuuid, foodId, foodNum);
        return ajaxSucc(null, ResultEnum.CART_DELETE_FOOD_SUCCESS);
    }


    /**
     * 根据foodId从购物车里面取出信息返回
     *
     * @param session
     * @param foodIdList
     * @return
     * @throws Exception
     */
    @PostMapping("/getInfoFromCart")
    public BaseResponse getInfoFromCart(HttpSession session, @RequestParam(value ="foodIdList") List<String> foodIdList) throws Exception {
        // 获取当前登录顾客
        String cuuid = (String) session.getAttribute("cuuid");
        if (cuuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 查看下单的菜品是否为空
        if (foodIdList == null || foodIdList.size() == 0)
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);
        List<CartFoodExtend> data = customerService.getInfoFromCart(cuuid, foodIdList);
        return ajaxSucc(data,ResultEnum.FOOD_SEARCH_SUCCESS);
    }

    /**
     * 当前登录用户下单
     *
     * @param session
     * @param foodIdList
     * @return
     */
    @PostMapping("/makeOrder")
    public BaseResponse makeOrder(HttpSession session, @RequestParam(value ="foodIdList") List<String> foodIdList) throws Exception {
        // 获取当前登录顾客
        String cuuid = (String) session.getAttribute("cuuid");
        if (cuuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);
        // 查看下单的菜品是否为空
        if (foodIdList == null || foodIdList.size() == 0)
            return ajaxFail(ResultEnum.CART_INFO_NOT_FULL);
        customerService.makeOrder(cuuid, foodIdList);
        return ajaxSucc(null, ResultEnum.CART_MARK_ORDER_SUCCESS);
    }

    /***
     * 获取当前登录用户的购物车信息
     * @param session
     * @return
     * @throws Exception
     */
    @GetMapping("/getCartLogined")
    public BaseResponse getCartLogined(HttpSession session) throws Exception {
        String cuuid = (String) session.getAttribute("cuuid");
        if (cuuid == null) return ajaxFail(ResultEnum.CUSTOMER_NOT_LOGINED);

        List<CartFoodExtend> data = customerService.getCustomerCart(cuuid);
        return ajaxSucc(data, ResultEnum.SUCCESS);
    }
}
