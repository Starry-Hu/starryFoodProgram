package com.practice.starryfood.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.*;
import com.practice.starryfood.dao.*;
import com.practice.starryfood.daoExtend.CartFoodExtendMapper;
import com.practice.starryfood.daoExtend.CustomerExtendMapper;
import com.practice.starryfood.daoExtend.OrderExtendMapper;
import com.practice.starryfood.daoExtend.OrderFoodExtendMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.pojo.*;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.util.DateStamp;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Project starryfood
 * @ClassName CustomerServiceImpl
 * @Author StarryHu
 * @Description 顾客业务层的实现
 * @Date 2019/7/1 20:51
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CustomerExtendMapper customerExtendMapper;
    @Autowired
    private CartFoodMapper cartFoodMapper;
    @Autowired
    private CartFoodExtendMapper cartFoodExtendMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderExtendMapper orderExtendMapper;
    @Autowired
    private OrderFoodMapper orderFoodMapper;
    @Autowired
    private OrderFoodExtendMapper orderFoodExtendMapper;

    /**
     * @Description: 添加顾客
     * @Param: [customerId, customerName, password]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/11/21
     */
    public int addCustomer(String customerId, String customerName, String password) throws Exception {
        // 设置查询条件，查找同账户名是否存在
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustomerIdEqualTo(customerId);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        // 对查出来的数据进行判断，看同名账户是否存在
        if (data.size() == 0) throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        Customer test = data.get(0);
        if (test != null && test.getIsDel() == 0) throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);

        // 添加到表中
        Customer customer = new Customer();
        Date date = new Date();
        customer.setCustomerUuid(IDGenerator.generator());
        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setCustomerCartId(IDGenerator.generator());
        customer.setCustomerPassword(password);
        customer.setCreateTime(date);
        customer.setIsDel(0);

        int n = customerMapper.insert(customer);
        // 添加成功
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_ADD_FAIL);
    }

    /**
    * @Description:  删除顾客（逻辑删除）
    * @Param: [customerUuid] 顾客uuid
    * @return: int
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    public int deleteCustomer(String customerUuid) throws Exception {
        Customer test = customerMapper.selectByPrimaryKey(customerUuid);
        if (test == null || test.getIsDel() == 1) throw new SAException(ExceptionEnum.CUSTOMER_DELETE_NOT_EXIST);

        Date date = new Date();
        test.setUpdateTime(date);
        test.setIsDel(1); // 逻辑删除
        int n = customerMapper.updateByPrimaryKeySelective(test);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_DELETE_FAIL);
    }

    /***
     * @Description: 更新顾客信息(管理员使用)
     * @Param: [customerUuid, customerId, customerName, customerPassword]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/7/1
     */
    public int updateCustomer(String customerUuid, String customerName, String customerPassword) throws Exception {
        Customer test = customerMapper.selectByPrimaryKey(customerUuid);
        if (test == null || test.getIsDel() == 1) throw new SAException(ExceptionEnum.CUSTOMER_UPDATE_NOT_EXIST);
        Customer customer = new Customer();
        Date date = new Date();
        customer.setCustomerUuid(customerUuid);
        customer.setCustomerName(customerName);
        customer.setCustomerPassword(customerPassword);
        customer.setUpdateTime(date);
        customer.setIsDel(0);

        int n = customerMapper.updateByPrimaryKeySelective(customer);
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_UPDATE_FAIL);
    }

    /***
     * 通过uuid查找顾客
     * @param customerUuid 顾客uuid
     * @return
     * @throws Exception
     */
    public Customer getCustomerByUuid(String customerUuid) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        if (customer == null || customer.getIsDel() == 1) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }
        return customer;
    }

    /***
     * 通过顾客账号查找顾客
     * @param customerId 顾客账号id
     * @return
     * @throws Exception
     */
    public Customer getCustomerByCustomerId(String customerId) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustomerIdEqualTo(customerId);

        // 判断顾客是否存在
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }
        Customer customer = data.get(0);
        if (customer == null || customer.getIsDel() == 1)
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);

        return customer;
    }

    /**
     * @Description: 查询全部顾客信息（带分页）
     * @Param: [pageNum, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.practice.starryfood.pojo.CustomerExtend>
     * @Author: StarryHu
     * @Date: 2019/11/22
     */
    public PageInfo<CustomerExtend> getAllCustomer(Integer pageNum, Integer pageSize) throws Exception {
        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取查询到的对象
        List<CustomerExtend> customerExtendList = customerExtendMapper.getAllCustomer();
        //如果查到的数据为空，则抛出异常
        if (customerExtendList.size() == 0) throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);

        // 逐个处理时间戳 需要判空
        for (CustomerExtend customerExtend : customerExtendList) {
            if (null != customerExtend.getCreateTime()) {
                String createTimeString = DateStamp.stampToDate(customerExtend.getCreateTime());
                customerExtend.setCreateTimeString(createTimeString);
            }
            if (null != customerExtend.getUpdateTime()) {
                String updateTimeString = DateStamp.stampToDate(customerExtend.getUpdateTime());
                customerExtend.setUpdateTimeString(updateTimeString);
            }
        }

        // 封装成分页对象
        PageInfo<CustomerExtend> pageInfo = new PageInfo<>(customerExtendList);
        return pageInfo;
    }

    /**
     * @Description: 获取全部已删除的用户（带分页）
     * @Param: [pageSize, pageNum]
     * @return: com.github.pagehelper.PageInfo<com.practice.starryfood.pojo.CustomerExtend>
     * @Author: StarryHu
     * @Date: 2019/11/22
     */
    public PageInfo<CustomerExtend> getAllDeleteCustomer(Integer pageNum, Integer pageSize) throws Exception {
        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取查询到的对象
        List<CustomerExtend> customerExtendList = customerExtendMapper.getAllDeleteCustomer();
        //如果查到的数据为空，则抛出异常
        if (customerExtendList.size() == 0) throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);

        // 逐个处理时间戳 需要判空
        for (CustomerExtend customerExtend : customerExtendList) {
            if (customerExtend.getCreateTime() != null) {
                String createTimeString = DateStamp.stampToDate(customerExtend.getCreateTime());
                customerExtend.setCreateTimeString(createTimeString);
            }
            if (customerExtend.getUpdateTime() != null) {
                String updateTimeString = DateStamp.stampToDate(customerExtend.getUpdateTime());
                customerExtend.setUpdateTimeString(updateTimeString);
            }
        }

        // 封装成分页对象
        PageInfo<CustomerExtend> pageInfo = new PageInfo<>(customerExtendList);
        return pageInfo;
    }

    /**
     * @Description: 恢复已删除的顾客（管理员使用）
     * @Param: [customerUuid]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/1
     */
    public int restoreDeleteCustomer(String customerUuid) throws Exception {
        // 查询该删除用户是否存在,若用户不存在或者已恢复删除，则弹出提示
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        if (customer == null) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        } else if (customer.getIsDel() == 0) {// 已经恢复
            throw new SAException(ExceptionEnum.CUSTOMER_IS_RESTORE_NOW);
        }
        // 恢复删除，并记录时间
        customer.setIsDel(0);
        Date date = new Date();
        customer.setUpdateTime(date);
        int n = customerMapper.updateByPrimaryKeySelective(customer);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_RESTORE_FAIL);
    }

    /****
     * @Description: 顾客登陆
     * @Param: [customerId, customerPassword] 顾客账号名，密码
     * @return: void
     * @Author: StarryHu
     * @Date: 2019/7/1
     */
    public Customer login(String customerId, String customerPassword) throws Exception {
        // 采用Example查询
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustomerIdEqualTo(customerId);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_LOGIN_NOT_EXIST);
        }
        // 获取到顾客对象
        Customer customer = data.get(0);
        // 判断密码是否正确
        if (!customerPassword.equals(customer.getCustomerPassword())) {
            throw new SAException(ExceptionEnum.CUSTOMER_LOGIN_PSW_ERROR);
        }
        // 如果正确返回顾客对象
        return customer;
    }

    /***
     * 顾客自行注册
     * @param customerId 账户名
     * @param customerName 名称
     * @param customerPassword 密码
     * @throws Exception
     */
    public int register(String customerId, String customerName, String customerPassword) throws Exception {
        // 采用Example查询 - 是否有同账户名对象
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCustomerIdEqualTo(customerId);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() != 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        }
        // 进行注册
        Date date = new Date();
        Customer customer = new Customer();
        customer.setCustomerUuid(IDGenerator.generator());
        customer.setCustomerId(customerId);
        customer.setCustomerName(customerName);
        customer.setCustomerPassword(customerPassword);
        customer.setCustomerCartId(IDGenerator.generator());
        customer.setCreateTime(date);
        customer.setIsDel(0);

        int n = customerMapper.insert(customer);
        // 添加成功
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_REGISTER_FAIL);
    }

    /***
     * 修改个人信息（账户名不可修改）
     * @param customerUuid
     * @param oldPassword
     * @param newPassword1
     * @return
     */
    public int editPersonInfo(String customerUuid, String customerName, String oldPassword, String newPassword1) {
        // 查找对象看是否存在
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        if (customer == null || customer.getIsDel() == 1)
            throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_NOT_EXIST);
        // 判断原密码是否输入正确
        if (!oldPassword.equals(customer.getCustomerPassword()))
            throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_OLDPSW_ERROR);
        // 判断新旧密码是否一致，如果一致则不需要修改
        if (newPassword1.equals(customer.getCustomerPassword()))
            throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_SAME_WITH_OLD);
        // 进行密码修改
        customer.setCustomerPassword(newPassword1);
        // 进行顾客名修改(先判断是否和原来的相等)
        if (!customerName.equals(customer.getCustomerName())) {
            customer.setCustomerName(customerName);
        }
        // 记录修改时间
        Date date = new Date();
        customer.setUpdateTime(date);

        int n = customerMapper.updateByPrimaryKeySelective(customer);
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_FAIL);
    }

    // ------------------------- 对购物车进行操作 --------------------------

    /***
     * 添加菜品到顾客的购物车中
     * @param customerUuid 顾客uuid
     * @param foodId 菜品id
     * @param foodNum 菜品数量
     * @return
     * @throws Exception
     */
    public int addFoodToCart(String customerUuid, String foodId, int foodNum) throws Exception {
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        String cartId = customer.getCustomerCartId();
        // 根据顾客的购物车号(非主键uuid)查询购物车-菜品表，得到对应顾客购物车的对应菜品那一条信息
        CartFoodExample cartFoodExample = new CartFoodExample();
        cartFoodExample.createCriteria().andCartIdEqualTo(cartId).andFoodIdEqualTo(foodId);
        List<CartFood> cartFoodList = cartFoodMapper.selectByExample(cartFoodExample);
        // 如果该顾客购物车里面没有该商品信息，则创建一个购物车用于记录该商品信息
        CartFood cartFood;
        if (cartFoodList == null || cartFoodList.size() == 0) {
            cartFood = new CartFood();
            cartFood.setCartFoodUuid(IDGenerator.generator());
            cartFood.setCartId(cartId);
        } else {
            cartFood = cartFoodList.get(0);
        }
        Food food = foodMapper.selectByPrimaryKey(foodId);
        cartFood.setFoodId(foodId);
        cartFood.setFoodNum(foodNum);
        // 计算该类商品的总价
        cartFood.setFoodOneTotalPrice(food.getFoodPrice().multiply(new BigDecimal(foodNum)));

        // 如果原来没有该信息，则插入到购物车-菜品表
        if (cartFoodList == null || cartFoodList.size() == 0) {
            int n = cartFoodMapper.insert(cartFood);
            if (n > 0) return n;
            // 如果插入失败则返回添加菜品到购物车失败
            throw new SAException(ExceptionEnum.CART_ADD_FOOD_FAIL);
        } else {
            int n = cartFoodMapper.updateByPrimaryKeySelective(cartFood);
            if (n > 0) return n;
            // 如果插入失败则返回添加菜品到购物车失败
            throw new SAException(ExceptionEnum.CART_ADD_FOOD_FAIL);
        }
    }

    /**
     * @Description: 从购物车中删除菜品
     * @Param: [uuid, foodId, foodNum]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/1
     */
    public int deleteFoodFromCart(String uuid, String foodId, int foodNum) throws Exception {
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        String cartId = customer.getCustomerCartId();
        // 根据顾客的购物车号和菜品号查询购物车-菜品表
        CartFoodExample cartFoodExample = new CartFoodExample();
        cartFoodExample.createCriteria().andCartIdEqualTo(cartId).andFoodIdEqualTo(foodId);
        List<CartFood> list = cartFoodMapper.selectByExample(cartFoodExample);
        // 如果对应信息为空，则抛出异常
        if (list.size() == 0) {
            throw new SAException(ExceptionEnum.CART_DELETE_FOOD_EMPTY);
        }
        CartFood cartFood = list.get(0);
        // 判断此时菜品数量是否为0，如果是0则删除记录
        if (foodNum == 0) {
            int n1 = cartFoodMapper.deleteByExample(cartFoodExample);
            if (n1 > 0) return n1;
            throw new SAException(ExceptionEnum.CART_DELETE_FOOD_FAIL);
        }

        // 如果不为0，则进行数量--
        Food food = foodMapper.selectByPrimaryKey(foodId);
        cartFood.setFoodNum(foodNum);
        cartFood.setFoodOneTotalPrice(food.getFoodPrice().multiply(new BigDecimal(foodNum)));
        // 进行数据更新
        int n2 = cartFoodMapper.updateByPrimaryKeySelective(cartFood);
        if (n2 > 0) return n2;
        throw new SAException(ExceptionEnum.CART_DELETE_FOOD_FAIL);
    }

    /**
     * @Description: 从购物车里面查找菜品数组的信息
     * @Param: [customerUuid, foodIdList]
     * @return: java.util.List<com.practice.starryfood.pojo.CartFoodExtend>
     * @Author: StarryHu
     * @Date: 2019/12/1
     */
    public List<CartFoodExtend> getInfoFromCart(String customerUuid, List<String> foodIdList) throws Exception {
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        String cartId = customer.getCustomerCartId();

        List<CartFoodExtend> list = new ArrayList<>();
        // 循环遍历每种foodId,，得到他们在购物车中的信息
        for (String foodId : foodIdList) {
            CartFoodExtend cartFoodExtend = cartFoodExtendMapper.getFoodFromCartByFoodId(cartId, foodId);
            // 如果查出来的不为空，则添加到数组中
            if (cartFoodExtend != null) {
                list.add(cartFoodExtend);
            }
        }
        return list;
    }

    /**
     * @Description: 下单
     * @Param: [customerUuid, foodIdList]
     * @return: java.math.BigDecimal
     * @Author: StarryHu
     * @Date: 2019/12/1
     */
    public int makeOrder(List<String> foodIdList, HttpSession session) throws Exception {
        // 查询顾客对象（根据session取出顾客uuid）
        String customerUuid = (String) session.getAttribute("customerUuid");
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        String cartId = customer.getCustomerCartId();
        BigDecimal sum = new BigDecimal(0.0);// 计算订单的总价
        // 创建订单对象
        Date date = new Date();
        Order order = new Order();
        order.setOrderId(IDGenerator.generator());
        order.setOrderCondition(0);// 订单的0状态为等待接单状态
        order.setOrderCreateTime(date);
        order.setOrderCreateCustomer(customerUuid);
        order.setIsDel(0);

        // 记录每次插入数据库的返回信息
        int n1 ;
        int n2 = 0;
        int n3 = 0;

        // 根据顾客的购物车号和菜品号遍历购物车-菜品表
        for (String foodId : foodIdList) {
            // 查询到购物车中的菜品记录
            CartFoodExample cartFoodExample = new CartFoodExample();
            cartFoodExample.createCriteria().andCartIdEqualTo(cartId).andFoodIdEqualTo(foodId);
            List<CartFood> list = cartFoodMapper.selectByExample(cartFoodExample);
            CartFood cartFood = list.get(0);
            // 添加到本次订单的总价中
            sum = sum.add(cartFood.getFoodOneTotalPrice());
            // 添加到订单中(菜品 - 订单关系)
            OrderFood orderFood = new OrderFood();
            orderFood.setOrderFoodUuid(IDGenerator.generator());
            orderFood.setOrderId(order.getOrderId());
            orderFood.setFoodId(cartFood.getFoodId());
            orderFood.setFoodNum(cartFood.getFoodNum());
            orderFood.setFoodOneTotalPrice(cartFood.getFoodOneTotalPrice());

            //  --- 将订单-菜品对象添加到数据库中 ---
            order.setOrderSumPrice(sum);
            n2 = orderFoodMapper.insert(orderFood);
            // --- 同时清空对应的购物车信息 ---
            n3 = cartFoodMapper.deleteByExample(cartFoodExample);
        }
        // 将订单对象添加到数据库中
        n1 = orderMapper.insert(order);
        if (n1 <= 0 || n2 <= 0 || n3 <= 0) throw new SAException(ExceptionEnum.CART_PAY_FOOD_FAIL);
        return n1 + n2 + n3;
    }

    /**** 
     * @Description: 获取顾客购物车信息
     * @Param: [customerUuid]
     * @return: java.util.List<com.practice.starryfood.pojo.CartFoodExtend>
     * @Author: StarryHu
     * @Date: 2019/7/9
     */
    public List<CartFoodExtend> getCustomerCart(String customerUuid) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(customerUuid);
        String cartId = customer.getCustomerCartId();
        // 如果客户的购物车不存在，则建立一个
        if (cartId == null) {
            customer.setCustomerCartId(IDGenerator.generator());
        }
        // 从购物车-菜品中根据购物车id得到相应信息
        List<CartFoodExtend> list = cartFoodExtendMapper.getFoodsFromCart(cartId);
        return list;
    }


}