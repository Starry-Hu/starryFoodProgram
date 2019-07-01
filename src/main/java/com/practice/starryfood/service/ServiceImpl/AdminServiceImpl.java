package com.practice.starryfood.service.ServiceImpl;

import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.bean.AdminExample;
import com.practice.starryfood.dao.AdminMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.service.AdminService;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project starryfood
 * @ClassName AdminServiceImpl
 * @Author StarryHu
 * @Description 管理员业务层
 * @Date 2019/7/1 20:28
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     * 添加管理员 (相当于注册功能)
     * @param adminId 管理员账号
     * @param adminName 管理员名称
     * @param password 账户密码
     * @return
     * @throws Exception
     */
    public int addAdmin(String adminId, String adminName, String password) throws Exception {
        // 设置查询条件
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminIdEqualTo(adminId);
        List<Admin> data = adminMapper.selectByExample(adminExample);
        // 如果查出来的数据不为空，则抛出账户已存在异常
        if (data.size() != 0) throw new SAException(ExceptionEnum.ADMIN_EXIST);

        Admin admin = new Admin();
        admin.setUuid(IDGenerator.generator());
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setPassword(password);

        int n = adminMapper.insert(admin);
        // 添加成功
        if (n > 0) {
            return n;
        }
        throw new SAException(ExceptionEnum.ADMIN_ADD_FAIL);
    }

    /**
     * 删除管理员
     * @param uuid 管理员的uuid
     * @return
     * @throws Exception
     */
    public int deleteAdmin(String uuid) throws Exception {
        int n = adminMapper.deleteByPrimaryKey(uuid);
        // 删除成功
        if (n > 0)
        {
            return n;
        }
        throw new SAException(ExceptionEnum.ADMIN_NOT_EXIST);
    }

    /**
     * 更新管理员信息
     * @param adminId 管理员账号
     * @param adminName 管理员名称
     * @param password 管理员密码
     * @return
     * @throws Exception
     */
    public int updateAdmin(String uuid, String adminId, String adminName, String password) throws Exception {
        Admin admin = new Admin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setPassword(password);

        int n = adminMapper.updateByPrimaryKey(admin);
        // 更新成功
        if (n > 0){
            return n;
        }
        throw new SAException(ExceptionEnum.ADMIN_UPDATE_FAIL);
    }

    /**
     * 根据uuid获取管理员信息
     * @param uuid
     * @return
     * @throws Exception
     */
    public Admin getAdminByuuid(String uuid) throws Exception {
        Admin admin = adminMapper.selectByPrimaryKey(uuid);
        // 管理员不存在
        if (admin == null) {
            throw new SAException(ExceptionEnum.ADMIN_NOT_EXIST);
        }
        return admin;
    }

    /**
     * 根据账户名查找管理员
     * @param adminId 管理员账户（唯一性）
     * @return
     * @throws Exception
     */
    public Admin getAdminByAdminId(String adminId) throws Exception {
        // 设置查询条件
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminIdEqualTo(adminId);
        List<Admin> data = adminMapper.selectByExample(adminExample);
        // 如果查出来的数据为空，则抛出不存在异常
        if (data.size() == 0) throw new SAException(ExceptionEnum.ADMIN_NOT_EXIST);
        // 否则 返回第一个数据
        return data.get(0);
    }

    /**
     * 管理员登录
     * @param adminId 管理员账号
     * @param password 密码
     * @throws Exception
     */
    public void login(String adminId, String password) throws Exception {
        // 设置查询条件
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminIdEqualTo(adminId);
        List<Admin> data = adminMapper.selectByExample(adminExample);
        // 如果查出来的数据为空，则抛出不存在异常
        if (data.size() == 0) throw new SAException(ExceptionEnum.ADMIN_NOT_EXIST);

        // 将第一个数组取出来作为管理员对象
        Admin admin = data.get(0);
        // 密码不正确时抛的异常
        if (!password.equals(admin.getPassword()))  throw new SAException(ExceptionEnum.ADMIN_PSW_ERROR);
        // 如果正确则顺利返回
    }
}
