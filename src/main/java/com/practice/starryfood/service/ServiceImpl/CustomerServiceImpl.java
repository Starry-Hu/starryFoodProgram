package com.practice.starryfood.service.ServiceImpl;

import com.practice.starryfood.bean.*;
import com.practice.starryfood.dao.*;
import com.practice.starryfood.daoExtend.CartFoodExtendMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.pojo.CartFoodExtend;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.ts.CurrencyNames_ts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Project starryfood
 * @ClassName CustomerServiceImpl
 * @Author StarryHu
 * @Description 管理员业务层的实现
 * @Date 2019/7/1 20:51
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private CartFoodMapper cartFoodMapper;
    @Autowired
    private CartFoodExtendMapper cartFoodExtendMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private OrderMapper orderMapper;


    /**
     * 添加用户
     *
     * @param cid      用户账户名
     * @param cname    用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    public int addCustomer(String cid, String cname, String password) throws Exception {
        // 设置查询条件，查找同账户名是否存在
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCidEqualTo(cid);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        // 对查出来的数据进行判断，看同名账户是否存在
        if (data.size() == 0) throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        Customer test = data.get(0);
        if (test != null && test.getIsdel() == 0) throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        Customer customer = new Customer();
        Date date = new Date();
        customer.setUuid(IDGenerator.generator());
        customer.setCid(cid);
        customer.setCname(cname);
        customer.setCartid(IDGenerator.generator());
        customer.setPassword(password);
        customer.setCreatetime(date);
        customer.setIsdel(0);

        int n = customerMapper.insert(customer);
        // 添加成功
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_ADD_FAIL);
    }

    /**
     * 删除用户（逻辑删除）
     *
     * @param uuid 用户uuid
     * @return
     * @throws Exception
     */
    public int deleteCustomer(String uuid) throws Exception {
        Customer test = customerMapper.selectByPrimaryKey(uuid);
        if (test == null || test.getIsdel() == 1) throw new SAException(ExceptionEnum.ADMIN_DELETE_NOT_EXIST);
        int n = customerMapper.deleteByPrimaryKey(uuid);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_DELETE_FAIL);
    }

    /***
     * @Description: 添加用户
     * @Param: [uuid, cid, name, password]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/7/1
     */
    public int updateCustomer(String uuid, String cid, String cname, String password) throws Exception {
        Customer test = customerMapper.selectByPrimaryKey(uuid);
        if (test == null || test.getIsdel() == 1) throw new SAException(ExceptionEnum.CUSTOMER_UPDATE_NOT_EXIST);
        Customer customer = new Customer();
        Date date = new Date();
        customer.setUuid(uuid);
        customer.setCid(cid);
        customer.setCname(cname);
        customer.setPassword(password);
        customer.setUpdatetime(date);
        customer.setIsdel(0);

        int n = customerMapper.updateByPrimaryKey(customer);
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_UPDATE_FAIL);
    }

    /***
     * 通过uuid查找用户
     * @param uuid 用户uuid
     * @return
     * @throws Exception
     */
    public Customer getCustomerByuuid(String uuid) throws Exception {
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        if (customer == null || customer.getIsdel() == 1) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }
        return customer;
    }

    /***
     * 通过用户账号查找用户
     * @param cid 用户账号id
     * @return
     * @throws Exception
     */
    public Customer getCustomerByCId(String cid) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCidEqualTo(cid);

        // 判断用户是否存在
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }
        Customer customer = data.get(0);
        if (customer == null || customer.getIsdel() == 1)
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);

        return customer;
    }


    /****
     * @Description: 用户登陆
     * @Param: [id, password] 用户账号名，密码
     * @return: void
     * @Author: StarryHu
     * @Date: 2019/7/1
     */
    public Customer login(String cid, String password) throws Exception {
        // 采用Example查询
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCidEqualTo(cid);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_LOGIN_NOT_EXIST);
        }
        // 获取到用户对象
        Customer customer = data.get(0);
        // 判断密码是否正确
        if (!password.equals(customer.getPassword())) {
            throw new SAException(ExceptionEnum.CUSTOMER_LOGIN_PSW_ERROR);
        }
        // 如果正确返回顾客对象
        return customer;
    }

    /***
     * 用户自行注册
     * @param cid 账户名
     * @param cname 名称
     * @param password 密码
     * @throws Exception
     */
    public int register(String cid, String cname, String password) throws Exception {
        // 采用Example查询 - 是否有同账户名对象
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andCidEqualTo(cid);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() != 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        }
        // 进行注册
        Customer customer = new Customer();
        customer.setUuid(IDGenerator.generator());
        customer.setCid(cid);
        customer.setCname(cname);
        customer.setPassword(password);
        customer.setCartid(IDGenerator.generator());

        int n = customerMapper.insert(customer);
        // 添加成功
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.CUSTOMER_REGISTER_FAIL);
    }

    /***
     * 修改个人密码
     * @param uuid
     * @param oldPassword
     * @param newPassword1
     * @return
     */
    public int editPersonPsw(String uuid, String oldPassword, String newPassword1) {
        // 查找对象看是否存在
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        if (customer == null || customer.getIsdel() == 1)
            throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_NOT_EXIST);
        // 判断原密码是否输入正确
        if (!oldPassword.equals(customer.getPassword()))
            throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_OLDPSW_ERROR);
        // 判断新旧密码是否一致，如果一致则不需要修改
        if (newPassword1.equals(customer.getPassword()))
            throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_SAME_WITH_OLD);
        // 进行密码修改
        customer.setPassword(newPassword1);
        int n = customerMapper.updateByPrimaryKey(customer);
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_EDITPSW_FAIL);
    }

    // ------------------------- 对购物车进行操作 --------------------------

    /***
     * 添加菜品到顾客的购物车中
     * @param uuid 顾客uuid
     * @param foodId 菜品id
     * @param foodNum 菜品数量
     * @return
     * @throws Exception
     */
    public int addFoodToCart(String uuid, String foodId, int foodNum) throws Exception {
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        String cartId = customer.getCartid();
        // 根据顾客的购物车号(非主键uuid)查询购物车-菜品表，得到对应用户购物车的对应菜品那一条信息
        CartFoodExample cartFoodExample = new CartFoodExample();
        cartFoodExample.createCriteria().andCartidEqualTo(cartId).andFoodidEqualTo(foodId);
        List<CartFood> cartFoodList = cartFoodMapper.selectByExample(cartFoodExample);
        // 如果该用户购物车里面没有该商品信息，则创建一个购物车用于记录该商品信息
        CartFood cartFood;
        if (cartFoodList == null || cartFoodList.size() == 0) {
            cartFood = new CartFood();
            cartFood.setUuid(IDGenerator.generator());
            cartFood.setCartid(cartId);
        }else{
            cartFood = cartFoodList.get(0);
        }
        Food food = foodMapper.selectByPrimaryKey(foodId);
        cartFood.setFoodid(foodId);
        cartFood.setFoodnum(foodNum);
        // 计算该类商品的总价
        cartFood.setFoodonetotalprice(food.getPrice().multiply(new BigDecimal(foodNum)));

        // 如果原来没有该信息，则插入到购物车-菜品表
        if (cartFoodList == null || cartFoodList.size() == 0) {
            int n = cartFoodMapper.insert(cartFood);
            if (n > 0) return n;
            // 如果插入失败则返回添加菜品到购物车失败
            throw new SAException(ExceptionEnum.CART_ADD_FOOD_FAIL);
        }else{
            int n = cartFoodMapper.updateByPrimaryKey(cartFood);
            if (n > 0) return n;
            // 如果插入失败则返回添加菜品到购物车失败
            throw new SAException(ExceptionEnum.CART_ADD_FOOD_FAIL);
        }
    }

    /***
     * 从购物车中删除菜品
     * @param uuid
     * @param foodId
     * @param foodNum
     * @return
     * @throws Exception
     */
    public int deleteFoodFromCart(String uuid, String foodId, int foodNum) throws Exception {
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        String cartId = customer.getCartid();
        // 根据顾客的购物车号和菜品号查询购物车-菜品表
        CartFoodExample cartFoodExample = new CartFoodExample();
        cartFoodExample.createCriteria().andCartidEqualTo(cartId).andFoodidEqualTo(foodId);
        List<CartFood> list = cartFoodMapper.selectByExample(cartFoodExample);
        // 如果对应信息为空，则抛出异常
        if (list.size() == 0) {
            throw new SAException(ExceptionEnum.CART_DELETE_FOOD_EMPTY);
        }
        CartFood cartFood = list.get(0);
        // 判断此时菜品数量是否为0，如果是0则删除记录
        if (foodNum == 0) {
            int n1= cartFoodMapper.deleteByExample(cartFoodExample);
            if (n1 > 0) return n1;
            throw new SAException(ExceptionEnum.CART_DELETE_FOOD_FAIL);
        }

        // 如果不为0，则进行数量--
        Food food = foodMapper.selectByPrimaryKey(foodId);
        cartFood.setFoodnum(foodNum);
        cartFood.setFoodonetotalprice(food.getPrice().multiply(new BigDecimal(foodNum)));
        // 进行数据更新
        int n2 = cartFoodMapper.updateByPrimaryKey(cartFood);
        if (n2 > 0) return n2;
        throw new SAException(ExceptionEnum.CART_DELETE_FOOD_FAIL);
    }

    /***
     * 从购物车里面查找菜品数组的信息
     * @param uuid 用户uuid
     * @param foodIdList
     * @return
     * @throws Exception
     */
    public List<CartFoodExtend> getInfoFromCart(String uuid, List<String> foodIdList) throws Exception{
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        String cartId = customer.getCartid();

        List<CartFoodExtend> list = new ArrayList<>();
        // 循环遍历每种foodId,，得到他们在购物车中的信息
        for(String foodId: foodIdList){
            CartFoodExtend cartFoodExtend = cartFoodExtendMapper.getFoodFromCartByFid(cartId,foodId);
            // 如果查出来的不为空，则添加到数组中
            if (cartFoodExtend != null){
                list.add(cartFoodExtend);
            }
        }
        return list;
    }

    /***
     * 下单
     * @param uuid
     * @param foodIdList
     * @return
     * @throws Exception
     */
    public BigDecimal makeOrder(String uuid, List<String> foodIdList) throws Exception {
        // 查询顾客对象
        Customer customer = customerMapper.selectByPrimaryKey(uuid);
        String cartId = customer.getCartid();
        BigDecimal sum = new BigDecimal(0.0);
        // 创建订单对象
        Date date = new Date();
        Order order = new Order();
        order.setId(IDGenerator.generator());
        // 订单的0状态为等待接单状态
        order.setCondition(0);
        order.setCreatetime(date);
        // 根据顾客的购物车号和菜品号遍历购物车-菜品表
        for(String foodId :foodIdList){
            // 查询到购物车中的菜品记录
            CartFoodExample cartFoodExample = new CartFoodExample();
            cartFoodExample.createCriteria().andCartidEqualTo(cartId).andFoodidEqualTo(foodId);
            List<CartFood> list = cartFoodMapper.selectByExample(cartFoodExample);
            CartFood cartFood = list.get(0);
            // 添加到总价中
            sum.add(cartFood.getFoodonetotalprice());
            // 添加到订单中(菜品 - 订单关系)
            OrderFood orderFood = new OrderFood();
            orderFood.setUuid(IDGenerator.generator());
            orderFood.setOrderid(order.getId());
            orderFood.setFoodid(cartFood.getFoodid());
            orderFood.setFoodnum(cartFood.getFoodnum());
            orderFood.setFoodonetotalprice(cartFood.getFoodonetotalprice());

            // 删除信息
            int n = cartFoodMapper.deleteByExample(cartFoodExample);
            if (n <=0 ) throw new SAException(ExceptionEnum.CART_PAY_FOOD_FAIL);
        }
        // 返回总价
        return sum;
    }

    /**** 
    * @Description: 获取用户购物车信息 
    * @Param: [cuuid] 
    * @return: java.util.List<com.practice.starryfood.pojo.CartFoodExtend> 
    * @Author: StarryHu
    * @Date: 2019/7/9 
    */ 
    public List<CartFoodExtend> getCustomerCart(String cuuid) throws Exception{
        Customer customer = customerMapper.selectByPrimaryKey(cuuid);
        String cartList = customer.getCartid();
        // 如果客户的购物车不存在，则建立一个
        if (cartList== null){
            customer.setCartid(IDGenerator.generator());
        }
        // 从购物车-菜品中根据购物车id得到相应信息
        List<CartFoodExtend> list = cartFoodExtendMapper.getFoodsFromCart(cartList);
        return list;
    }
}