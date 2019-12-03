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
     * @Param: []
     * @return: com.practice.starryfood.util.BaseResponse
     * @Author: StarryHu
     * @Date: 2019/12/3
     */
    @GetMapping("/getOrders")
    public BaseResponse getOrders(Integer searchCondition, Integer pageNum, Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        // 未传条件参数时默认当成-1查找全部订单信息
        if (searchCondition == null){
            searchCondition = -1;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getOrders(searchCondition, pageNum,pageSize);
        return ajaxSucc(pageInfo, ResultEnum.ORDER_SEARCH_SUCCESS);
    }

    /***
    * @Description: 根据顾客账号id获取其对应的全部订单信息
    * @Param: [customerId, pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/3
    */
    @GetMapping("/getByCustomerId")
    public BaseResponse getByCustomerId(String customerId, Integer pageNum, Integer pageSize) throws Exception {
        if (customerId == null || customerId.trim().equals("")){
            return ajaxFail(ResultEnum.CUSTOMER_INFO_NOT_FULL);
        }
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }

        PageInfo<OrderExtend> pageInfo = orderService.getByCustomerId(customerId, pageNum,pageSize);
        return ajaxSucc(pageInfo, ResultEnum.ORDER_SEARCH_SUCCESS);
    }
}
