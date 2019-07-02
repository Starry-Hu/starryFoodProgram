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

import java.util.Date;
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
    public int addAdmin(String adminId, String adminName, String password,String createUser) throws Exception {
        // 设置查询条件
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminIdEqualTo(adminId);
        List<Admin> data = adminMapper.selectByExample(adminExample);
        // 如果查出来的数据不为空，则抛出账户已存在异常
        if (data.size() != 0) throw new SAException(ExceptionEnum.ADMIN_ADD_EXIST);
        Admin test = data.get(0);
        // 对查出来的数据进行判断，看同名账户是否存在
        if (test != null && test.getIsDel() == 0) throw new SAException(ExceptionEnum.ADMIN_ADD_EXIST);


        Admin admin = new Admin();
        Date date = new Date();
        admin.setUuid(IDGenerator.generator());
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setPassword(password);
        admin.setCreateTime(date);
        admin.setCreateUser(createUser);
        admin.setIsDel(0);

        int n = adminMapper.insert(admin);
        // 添加成功
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.ADMIN_ADD_FAIL);
    }

    /**
     * 删除管理员
     * @param uuid 管理员的uuid
     * @return
     * @throws Exception
     */
    public int deleteAdmin(String uuid,String updateUser) throws Exception {
        // 查找相应管理员，并判断是否存在，如果已不存在则抛出异常
        Admin admin = adminMapper.selectByPrimaryKey(uuid);
        if (admin == null || admin.getIsDel() == 1) throw new SAException(ExceptionEnum.ADMIN_DELETE_FAIL);
        Date date = new Date();
        admin.setIsDel(1);
        admin.setUpdateTime(date);
        admin.setUpdateUser(updateUser);
        int n = adminMapper.updateByPrimaryKey(admin);
        // 删除成功
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.ADMIN_DELETE_FAIL);
    }

    /**
     * 更新管理员信息
     * @param adminId 管理员账号
     * @param adminName 管理员名称
     * @param password 管理员密码
     * @return
     * @throws Exception
     */
    public int updateAdmin(String uuid, String adminId, String adminName,
                           String password,String updateUser) throws Exception {
        Admin admin = adminMapper.selectByPrimaryKey(uuid);
        // 根据uuid获取管理员对象，并判断是否存在
        if (admin == null || admin.getIsDel() == 1)  throw new SAException(ExceptionEnum.ADMIN_UPDATE_NOT_EXIST);
        Date date = new Date();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setPassword(password);
        admin.setUpdateTime(date);
        admin.setUpdateUser(updateUser);

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
        // 管理员不存在或已删除
        if (admin == null || admin.getIsDel() == 1) {
            throw new SAException(ExceptionEnum.ADMIN_SEARCH_NOT_EXIST);
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
        if (data.size() == 0) throw new SAException(ExceptionEnum.ADMIN_SEARCH_NOT_EXIST);
        Admin admin = data.get(0);
        // 如果第一个用户不存在或已删除则抛出异常
        if (admin == null || admin.getIsDel() == 1) throw new SAException(ExceptionEnum.ADMIN_SEARCH_NOT_EXIST);
        // 否则 返回第一个数据
        return admin;
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
        if (data.size() == 0) throw new SAException(ExceptionEnum.ADMIN_LOGIN_NOT_EXIST);

        // 将第一个数组取出来作为管理员对象
        Admin admin = data.get(0);
        // 如果第一个用户不存在或已删除则抛出异常
        if (admin == null || admin.getIsDel() == 1) throw new SAException(ExceptionEnum.ADMIN_LOGIN_NOT_EXIST);
        // 密码不正确时抛的异常
        if (!password.equals(admin.getPassword()))  throw new SAException(ExceptionEnum.ADMIN_LOGIN_PSW_ERROR);
        // 如果正确则顺利返回
    }
}
