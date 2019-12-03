package com.practice.starryfood.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.bean.CustomerExample;
import com.practice.starryfood.dao.CustomerMapper;
import com.practice.starryfood.daoExtend.OrderExtendMapper;
import com.practice.starryfood.daoExtend.OrderFoodExtendMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.pojo.OrderExtend;
import com.practice.starryfood.pojo.OrderFoodExtend;
import com.practice.starryfood.service.OrderService;
import com.practice.starryfood.util.DateStamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project starryfood
 * @ClassName OrderServiceImpl
 * @Author StarryHu
 * @Description 订单类的业务逻辑层
 * @Date 2019/12/3 9:45
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderExtendMapper orderExtendMapper;
    @Autowired
    OrderFoodExtendMapper orderFoodExtendMapper;
    @Autowired
    CustomerMapper customerMapper;

    // ----------------------------------------------  简洁版，不带相应菜品信息，用于列表展示  ------------------------------------------------
    /**
     * @Description: 根据顾客id账号 获取某顾客的全部订单信息(带分页)【简洁查找】
     * @Param: [customerUuid]
     * @return: java.util.List<com.practice.starryfood.pojo.OrderExtend>
     * @Author: StarryHu
     * @Date: 2019/12/2
     */
    public PageInfo<OrderExtend> getByCustomerIdSimple(String customerId, int pageNum, int pageSize) throws Exception {
        // 判断该顾客是否存在，同时获取该顾客对应的customerUuid
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustomerIdEqualTo(customerId);
        List<Customer> customerList = customerMapper.selectByExample(customerExample);
        if (customerList == null || customerList.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }
        String customerUuid = customerList.get(0).getCustomerUuid();

        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取到该顾客的所有订单号（使用OrderExtend对象，方便之后填充信息）
        List<OrderExtend> orderExtendList = orderExtendMapper.getAllOrderByCustomerUuid(customerUuid);

        if (orderExtendList == null) throw new SAException(ExceptionEnum.ORDER_EMPTY);
        if (orderExtendList.size() == 0) throw new SAException(ExceptionEnum.ORDER_EMPTY);

        // ----- simple仅需要处理时间戳，不需要添加菜品信息 ------
        for (OrderExtend orderExtend : orderExtendList) {
            // 处理时间戳 需要判空
            dealOrderTimeStamp(orderExtend);
        }

        // 封装成分页对象
        PageInfo<OrderExtend> pageInfo = new PageInfo<>(orderExtendList);
        return pageInfo;
    }

    /**
     * @Description: 根据条件查询全部订单详细信息（-1为全部订单信息，0为未处理订单，1为制作中订单，2为等待支付订单，3为已完成订单）
     *               同时通过isDetail判断是否为详细查询，是则还需将每个种类的菜品添加进去
     * @Param: []
     * @return: java.util.List<com.practice.starryfood.pojo.OrderExtend>
     * @Author: StarryHu
     * @Date: 2019/12/3
     */
    public PageInfo<OrderExtend> getOrders(int searchCondition, int pageNum, int pageSize, boolean isDetail) throws Exception {
        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取查询到的对象
        List<OrderExtend> orderExtendList = null;
        // 根据条件查询选择相应的查找方法
        if (searchCondition == -1) {  // 查询全部订单
            orderExtendList = orderExtendMapper.getAllOrders();
        } else if (searchCondition == 0) { // 查询未处理订单
            orderExtendList = orderExtendMapper.getUndoOrders();
        } else if (searchCondition == 1) { // 查询制作中订单
            orderExtendList = orderExtendMapper.getMakingOrders();
        } else if (searchCondition == 2) { // 查询等待支付订单
            orderExtendList = orderExtendMapper.getWaitPayOrders();
        } else if (searchCondition == 3) { // 查询已完成订单
            orderExtendList = orderExtendMapper.getDoneOrders();
        }

        if (orderExtendList == null) throw new SAException(ExceptionEnum.ORDER_EMPTY);
        if (orderExtendList.size() == 0) throw new SAException(ExceptionEnum.ORDER_EMPTY);

        // 添加对应的菜品信息
        for (OrderExtend orderExtend : orderExtendList) {
            // 详细查找 - 用订单号去查询该订单的菜品购买情况，填充到OrderFoodExtend数组中
            if (isDetail){
                List<OrderFoodExtend> orderFoodExtendList = orderFoodExtendMapper.getFoodByOrderId(orderExtend.getOrderId());
                orderExtend.setOrderFoodExtendList(orderFoodExtendList);
            }
            // 处理时间戳 需要判空
            dealOrderTimeStamp(orderExtend);
        }

        // 封装成分页对象
        PageInfo<OrderExtend> pageInfo = new PageInfo<>(orderExtendList);
        return pageInfo;
    }



    /**
     * @Description: 根据顾客的uuid 获取某顾客的全部订单信息(带分页)【详细查找】
     * @Param: [customerUuid]
     * @return: java.util.List<com.practice.starryfood.pojo.OrderExtend>
     * @Author: StarryHu
     * @Date: 2019/12/2
     */
    public PageInfo<OrderExtend> getByCustomerUuidDetail(String customerUuid, int pageNum, int pageSize) throws Exception {
        // 检查该顾客是否存在
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        if (customer == null || customer.getIsDel() == 1) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }

        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取到该顾客的所有订单号（使用OrderExtend对象，方便之后填充信息）
        List<OrderExtend> orderExtendList = orderExtendMapper.getAllOrderByCustomerUuid(customerUuid);

        if (orderExtendList == null) throw new SAException(ExceptionEnum.ORDER_EMPTY);
        if (orderExtendList.size() == 0) throw new SAException(ExceptionEnum.ORDER_EMPTY);

        for (OrderExtend orderExtend : orderExtendList) {
            // 用订单号去查询该订单的菜品购买情况，填充到OrderFoodExtend数组中
            List<OrderFoodExtend> orderFoodExtendList = orderFoodExtendMapper.getFoodByOrderId(orderExtend.getOrderId());
            orderExtend.setOrderFoodExtendList(orderFoodExtendList);

            // 处理时间戳 需要判空
            dealOrderTimeStamp(orderExtend);
        }

        // 封装成分页对象
        PageInfo<OrderExtend> pageInfo = new PageInfo<>(orderExtendList);
        return pageInfo;
    }


    // ----------------------------------------- 内部使用方法 -------------------------------------------
    /**
    * @Description: 处理订单的时间戳
    * @Param: [orderExtend]
    * @return: void
    * @Author: StarryHu
    * @Date: 2019/12/3
    */
    private void dealOrderTimeStamp(OrderExtend orderExtend){
        // 处理时间戳 需要判空
        if (null != orderExtend.getOrderCreateTime()) {
            String createTimeString = DateStamp.stampToDate(orderExtend.getOrderCreateTime());
            orderExtend.setCreateTimeString(createTimeString);
        }
        if (null != orderExtend.getOrderUpdateTime()) {
            String updateTimeString = DateStamp.stampToDate(orderExtend.getOrderUpdateTime());
            orderExtend.setUpdateTimeString(updateTimeString);
        }
    }
}
