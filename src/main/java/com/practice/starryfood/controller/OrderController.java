package com.practice.starryfood.controller;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.OrderExtend;
import com.practice.starryfood.service.OrderService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Project starryfood
 * @ClassName OrderController
 * @Author StarryHu
 * @Description 订单的相关接口
 * @Date 2019/12/3 10:23
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

    /**
     * @Description: 根据条件查询订单信息（-1为全部订单信息，0为未处理订单，1为制作中订单，2为等待支付订单，3为已完成订单）
     *               且为简单查找，不包括每个订单的菜品信息
     * @Param: []
     * @return: com.practice.starryfood.util.BaseResponse
     * @Author: StarryHu
     * @Date: 2019/12/3
     */
    @GetMapping("/getAllOrdersSimple")
    public BaseResponse getAllOrdersSimple(Integer searchCondition, Integer pageNum, Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        // 未传条件参数时默认当成-1查找全部订单信息
        if (searchCondition == null){
            searchCondition = -1;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getOrders(searchCondition, pageNum,pageSize,false);
        return ajaxSucc(pageInfo, ResultEnum.ORDER_SEARCH_SUCCESS);
    }

    /** 
    * @Description: 根据条件查询订单信息（-1为全部订单信息，0为未处理订单，1为制作中订单，2为等待支付订单，3为已完成订单）
     *              为细节查找，包括每个订单的菜品信息
    * @Param: [searchCondition, pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse 
    * @Author: StarryHu
    * @Date: 2019/12/3 
    */ 
    @GetMapping("/getAllOrdersDetail")
    public BaseResponse getAllOrdersDetail(Integer searchCondition, Integer pageNum, Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        // 未传条件参数时默认当成-1查找全部订单信息
        if (searchCondition == null){
            searchCondition = -1;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getOrders(searchCondition, pageNum,pageSize,false);
        return ajaxSucc(pageInfo, ResultEnum.ORDER_SEARCH_SUCCESS);
    }

    /***
    * @Description: 根据顾客账号id获取其对应的全部订单信息[仅用于显示列表，不展示菜品]
    * @Param: [customerId, pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/3
    */
    @GetMapping("/getByCustomerIdSimple")
    public BaseResponse getByCustomerIdSimple(String customerId, Integer pageNum, Integer pageSize) throws Exception {
        if (customerId == null || customerId.trim().equals("")){
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getByCustomerIdSimple(customerId, pageNum,pageSize);
        return ajaxSucc(pageInfo, ResultEnum.ORDER_SEARCH_SUCCESS);
    }


    /**
    * @Description: 根据订单号获取某一订单信息
    * @Param: [orderId]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/4
    */
    @GetMapping("/getByOrderId")
    public BaseResponse getByOrderId(String orderId) throws Exception {
        if (orderId == null || orderId.trim().equals("")){
            return ajaxFail(ResultEnum.ORDER_INFO_NOT_FULL);
        }

        OrderExtend orderExtend = orderService.getByOrderId(orderId);
        return ajaxSucc(orderExtend, ResultEnum.ORDER_SEARCH_SUCCESS);
    }



    /**
     * @Description: 获取已删除订单
     * @Param: [pageNum, pageSize]
     * @return: com.practice.starryfood.util.BaseResponse
     * @Author: StarryHu
     * @Date: 2019/12/4
     */
    @GetMapping("/getIsDelOrder")
    public BaseResponse getIsDelOrder(Integer pageNum, Integer pageSize) throws Exception{
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getIsDelOrders(pageNum,pageSize);
        return ajaxSucc(pageInfo,ResultEnum.ORDER_SEARCH_SUCCESS);
    }

    @GetMapping("/getIsDelOrderByCustomerId")
    public BaseResponse getIsDelOrderByCustomerId(String customerId,Integer pageNum, Integer pageSize) throws Exception{
        if (customerId == null || customerId.trim().equals("")) {
            return ajaxFail(ResultEnum.ORDER_INFO_NOT_FULL);

        }
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getIsDelOrderByCustomerId(customerId,pageNum,pageSize);
        return ajaxSucc(pageInfo,ResultEnum.ORDER_SEARCH_SUCCESS);
    }

    /**
    * @Description: 删除订单
    * @Param: [orderId, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/4
    */
    @GetMapping("/deleteOrder")
    public BaseResponse deleteOrder(String orderId, HttpSession session) throws Exception{
        // 查看信息是否填写完全
        if (orderId == null || orderId.trim().equals("")){
            return ajaxFail(ResultEnum.ORDER_INFO_NOT_FULL);
        }
        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");
        orderService.delete(orderId,updateUser);

        return ajaxSucc(null,ResultEnum.ORDER_DELETE_SUCCESS);
    }

}
