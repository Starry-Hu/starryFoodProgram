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
import sun.util.resources.cldr.ts.CurrencyNames_ts;

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
        // 设置查询条件，查找同账户名是否存在
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdEqualTo(id);
        List<Customer> data = customerMapper.selectByExample(customerExample);
        // 对查出来的数据进行判断，看同名账户是否存在
        if (data.size() == 0) throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        Customer test = data.get(0);
        if (test != null && test.getIsDel() == 0) throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
        Customer customer = new Customer();
        Date date = new Date();
        customer.setUuid(IDGenerator.generator());
        customer.setId(id);
        customer.setName(name);
        customer.setPassword(password);
        customer.setCreateTime(date);
        customer.setIsDel(0);

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
        if (test == null || test.getIsDel() == 1) throw new SAException(ExceptionEnum.ADMIN_DELETE_NOT_EXIST);

        int n = customerMapper.deleteByPrimaryKey(uuid);
        if (n > 0) return n;

        throw new SAException(ExceptionEnum.CUSTOMER_DELETE_FAIL);
    }

    /***
     * @Description: 添加用户
     * @Param: [uuid, id, name, password]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/7/1
     */
    public int updateCustomer(String uuid, String id, String name, String password) throws Exception {
        Customer test = customerMapper.selectByPrimaryKey(uuid);
        if (test == null || test.getIsDel() == 1) throw new SAException(ExceptionEnum.CUSTOMER_UPDATE_NOT_EXIST);
        Customer customer = new Customer();
        Date date = new Date();
        customer.setUuid(uuid);
        customer.setId(id);
        customer.setName(name);
        customer.setPassword(password);
        customer.setUpdateTime(date);
        customer.setIsDel(0);

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
        if (customer == null || customer.getIsDel() == 1) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
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

        // 判断用户是否存在
        List<Customer> data = customerMapper.selectByExample(customerExample);
        if (data.size() == 0) {
            throw new SAException(ExceptionEnum.CUSTOMER_SEARCH_NOT_EXIST);
        }
        Customer customer = data.get(0);
        if (customer == null || customer.getIsDel() == 1)
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
    public Customer login(String id, String password) throws Exception {
        // 采用Example查询
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdEqualTo(id);
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
            throw new SAException(ExceptionEnum.CUSTOMER_ADD_EXIST);
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
        if (customer == null || customer.getIsDel() == 1)
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

}
