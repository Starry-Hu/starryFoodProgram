package com.practice.starryfood.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Admin;
import com.practice.starryfood.bean.AdminExample;
import com.practice.starryfood.bean.Food;
import com.practice.starryfood.dao.AdminMapper;
import com.practice.starryfood.dao.FoodMapper;
import com.practice.starryfood.daoExtend.AdminExtendMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.pojo.AdminExtend;
import com.practice.starryfood.pojo.CustomerExtend;
import com.practice.starryfood.service.AdminService;
import com.practice.starryfood.util.DateStamp;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Autowired
    private AdminExtendMapper adminExtendMapper;

    /**
     * 添加管理员 (相当于注册功能)
     *
     * @param adminId       管理员账号
     * @param adminName     管理员名称
     * @param adminPassword 账户密码
     * @return
     * @throws Exception
     */
    public int addAdmin(String adminId, String adminName, String adminPassword, String createUser) throws Exception {
        // 设置查询条件
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andAdminIdEqualTo(adminId);
        List<Admin> data = adminMapper.selectByExample(adminExample);
        // 如果查出来的数据不为空，则抛出账户已存在异常
        if (data.size() != 0) throw new SAException(ExceptionEnum.ADMIN_ADD_EXIST);

        Admin admin = new Admin();
        Date date = new Date();
        admin.setAdminUuid(IDGenerator.generator());
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        admin.setCreateTime(date);
        admin.setCreateUser(createUser);
        admin.setIsDel(0);

        int n = adminMapper.insert(admin);
        // 添加成功
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.ADMIN_ADD_FAIL);
    }

    /**
     * 删除管理员(逻辑删除)
     *
     * @param adminUuid 管理员的uuid
     * @return
     * @throws Exception
     */
    public int deleteAdmin(String adminUuid, String updateUser) throws Exception {
        // 查找相应管理员，并判断是否存在，如果已不存在则抛出异常
        Admin admin = adminMapper.selectByPrimaryKey(adminUuid);
        if (admin == null || admin.getIsDel() == 1) throw new SAException(ExceptionEnum.ADMIN_DELETE_FAIL);
        Date date = new Date();
        admin.setIsDel(1);
        admin.setUpdateTime(date);
        admin.setUpdateUser(updateUser);
        int n = adminMapper.updateByPrimaryKeySelective(admin);
        // 删除成功
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.ADMIN_DELETE_FAIL);
    }

    /**
     * @Description: 恢复已删除管理员
     * @Param: [adminUuid, updateUser]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/4
     */
    public int restoreDeleteAdmin(String adminUuid, String updateUser) throws Exception {
        Admin admin = adminMapper.selectByPrimaryKey(adminUuid);
        // 如果该管理员不存在或者已恢复，则抛出异常
        if (admin == null || admin.getIsDel() == 0) throw new SAException(ExceptionEnum.ADMIN_IS_RESTORE_NOW);

        // 进行还原操作
        admin.setIsDel(0);
        Date date = new Date();
        admin.setUpdateTime(date);
        admin.setUpdateUser(updateUser);

        int n = adminMapper.updateByPrimaryKeySelective(admin);
        if (n <= 0) throw new SAException(ExceptionEnum.ADMIN_RESTORE_FAIL);
        return n;
    }

    /***
     * @Description: 更新管理员信息（根据uuid）
     * @Param: [adminUuid, adminName, adminPassword, updateUser]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/3
     */
    public int updateAdmin(String adminUuid, String adminName, String adminPassword, String updateUser) throws Exception {
        Admin admin = adminMapper.selectByPrimaryKey(adminUuid);
        // 根据uuid获取管理员对象，并判断是否存在
        if (admin == null || admin.getIsDel() == 1) throw new SAException(ExceptionEnum.ADMIN_UPDATE_NOT_EXIST);
        Date date = new Date();
        admin.setAdminName(adminName);
        admin.setAdminPassword(adminPassword);
        admin.setUpdateTime(date);
        admin.setUpdateUser(updateUser);

        int n = adminMapper.updateByPrimaryKeySelective(admin);
        // 更新成功
        if (n > 0) {
            return n;
        }
        throw new SAException(ExceptionEnum.ADMIN_UPDATE_FAIL);
    }

    /**
     * 根据uuid获取管理员信息
     *
     * @param adminUuid
     * @return
     * @throws Exception
     */
    public Admin getAdminByUuid(String adminUuid) throws Exception {
        Admin admin = adminMapper.selectByPrimaryKey(adminUuid);
        // 管理员不存在或已删除
        if (admin == null || admin.getIsDel() == 1) {
            throw new SAException(ExceptionEnum.ADMIN_SEARCH_NOT_EXIST);
        }
        return admin;
    }

    /**
     * 根据账户名查找管理员
     *
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
     * @Description: 获取全部管理员（带分页）
     * @Param: [pageNum, pageSize]
     * @return: com.github.pagehelper.PageInfo<com.practice.starryfood.pojo.AdminExtend>
     * @Author: StarryHu
     * @Date: 2019/12/3
     */
    public PageInfo<AdminExtend> getAllAdmins(int pageNum, int pageSize) throws Exception {
        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取查询到的对象
        List<AdminExtend> adminExtendList = adminExtendMapper.getAllAdmins();

        //如果查到的数据为空，则抛出异常
        if (adminExtendList.size() == 0) throw new SAException(ExceptionEnum.ADMIN_SEARCH_NOT_EXIST);

        // 逐个处理时间戳 需要判空
        for (AdminExtend adminExtend : adminExtendList) {
            dealAdminTimeStamp(adminExtend);
        }
        // 封装成分页对象
        PageInfo<AdminExtend> pageInfo = new PageInfo<>(adminExtendList);
        return pageInfo;
    }

    public PageInfo<AdminExtend> getIsDeleteAdmins(int pageNum, int pageSize) throws Exception {
        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取查询到的对象
        List<AdminExtend> adminExtendList = adminExtendMapper.getIsDeleteAdmins();

        //如果查到的数据为空，则抛出异常
        if (adminExtendList.size() == 0) throw new SAException(ExceptionEnum.ADMIN_SEARCH_NOT_EXIST);

        // 逐个处理时间戳 需要判空
        for (AdminExtend adminExtend : adminExtendList) {
            dealAdminTimeStamp(adminExtend);
        }
        // 封装成分页对象
        PageInfo<AdminExtend> pageInfo = new PageInfo<>(adminExtendList);
        return pageInfo;
    }

    /**
     * 管理员登录
     *
     * @param adminId       管理员账号
     * @param adminPassword 密码
     * @throws Exception
     */
    public Admin login(String adminId, String adminPassword) throws Exception {
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
        if (!adminPassword.equals(admin.getAdminPassword())) throw new SAException(ExceptionEnum.ADMIN_LOGIN_PSW_ERROR);
        // 如果正确则顺利返回该管理员对象
        return admin;
    }

    /***
     * 修改个人密码（需要判断原密码是否正确）
     * @param adminUuid 账户uuid
     * @param oldPsw 原密码
     * @param newPsw 新密码
     * @return
     * @throws Exception
     */
    public int editPersonPsw(String adminUuid, String oldPsw, String newPsw) throws Exception {
        // 查看管理员是否存在
        Admin admin = adminMapper.selectByPrimaryKey(adminUuid);
        if (admin == null || admin.getIsDel() == 1)
            throw new SAException(ExceptionEnum.ADMIN_EDITPSW_NOT_EXIST);
        // 查看原密码是否输入正确
        if (!admin.getAdminPassword().equals(oldPsw))
            throw new SAException(ExceptionEnum.ADMIN_EDITPSW_OLDPSW_ERROR);
        // 与原密码进行比对，如果无变化则抛出异常，不继续操作
        if (admin.getAdminPassword().equals(newPsw))
            throw new SAException(ExceptionEnum.ADMIN_EDITPSW_SAME_WITH_OLD);

        admin.setAdminPassword(newPsw);
        int n = adminMapper.updateByPrimaryKeySelective(admin);
        if (n > 0) return n;
        // 出错的情况
        throw new SAException(ExceptionEnum.ADMIN_EDITPSW_FAIL);

    }

    private void dealAdminTimeStamp(AdminExtend adminExtend) {
        // 逐个处理时间戳 需要判空
        if (null != adminExtend.getCreateTime()) {
            String createTimeString = DateStamp.stampToDate(adminExtend.getCreateTime());
            adminExtend.setCreateTimeString(createTimeString);
        }
        if (null != adminExtend.getUpdateTime()) {
            String updateTimeString = DateStamp.stampToDate(adminExtend.getUpdateTime());
            adminExtend.setUpdateTimeString(updateTimeString);
        }
    }
}
