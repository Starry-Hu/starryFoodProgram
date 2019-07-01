package com.practice.starryfood.service.ServiceImpl;

import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.bean.Customer;
import com.practice.starryfood.bean.CustomerExample;
import com.practice.starryfood.dao.AdminMapper;
import com.practice.starryfood.dao.CustomerMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.service.CustomerService;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    /**
     * 添加用户
     *
     * @param id       用户账户名
     * @param name     用户名
     * @param password 密码
     * @return
     * @throws Exception
     */
    public int addCustomer(String id, String name, String password) throws Exception {
        Customer customer = new Customer();
        customer.setUuid(IDGenerator.generator());
        customer.setId(id);
        customer.setName(name);
        customer.setPassword(password);

        int n = customerMapper.insert(customer);
        // 添加成功
        if (n > 0) {
            return n;
        }
        throw new SAException(ExceptionEnum.CUSTOMER_ADD_FAIL);
    }

    /**
     * 删除用户
     *
     * @param uuid 用户uuid
     * @return
     * @throws Exception
     */
    public int deleteCustomer(String uuid) throws Exception {
        int n = customerMapper.deleteByPrimaryKey(uuid);
        if (n > 0) {
            return n;
        }
        throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
    }

    /***
     * @Description: 添加用户
     * @Param: [uuid, id, name, password]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/7/1
     */
    public int updateCustomer(String uuid, String id, String name, String password) throws Exception {
        Customer customer = new Customer();
        customer.setUuid(uuid);
        customer.setId(id);
        customer.setName(name);
        customer.setPassword(password);

        int n = customerMapper.updateByPrimaryKey(customer);
        if (n > 0) {
            return n;
        }
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
        if (customer == null) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        return customer;
    }

    /***
     * 通过用户账号查找用户
     * @param id 用户账号id
     * @return
     * @throws Exception
     */
    public Customer getCustomerByCId(String id) throws Exception {
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdEqualTo(id);

        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        return data.get(0);
    }

    /****
    * @Description: 用户登陆
    * @Param: [id, password] 用户账号名，密码
    * @return: void
    * @Author: StarryHu
    * @Date: 2019/7/1
    */
    public void login(String id, String password) throws Exception {
        // 采用Example查询
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdEqualTo(id);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_NOT_EXIST);
        }
        // 获取到用户对象
        Customer customer = data.get(0);
        // 判断密码是否正确
        if (!password.equals(customer.getPassword())){
            throw new SAException(ExceptionEnum.CUSTOMER_PSW_ERROR);
        }
        // 如果正确则正常退出
    }

    /***
     * 用户自行注册
     * @param id 账户名
     * @param name 名称
     * @param password 密码
     * @throws Exception
     */
    public int register(String id, String name, String password) throws Exception {
        // 采用Example查询 - 是否有同账户名对象
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdEqualTo(id);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() != 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_EXIST);
        }
        // 进行注册
        Customer customer = new Customer();
        customer.setUuid(IDGenerator.generator());
        customer.setId(id);
        customer.setName(name);
        customer.setPassword(password);

        int n = customerMapper.insert(customer);
        // 添加成功
        if (n > 0) {
            return n;
        }
        throw new SAException(ExceptionEnum.CUSTOMER_REGISTER_FAIL);
    }
}
