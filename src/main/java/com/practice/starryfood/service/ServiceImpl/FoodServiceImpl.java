package com.practice.starryfood.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.practice.starryfood.bean.Food;
import com.practice.starryfood.dao.FoodMapper;
import com.practice.starryfood.daoExtend.FoodExtendMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.pojo.FoodExtend;
import com.practice.starryfood.service.FoodService;
import com.practice.starryfood.util.DateStamp;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Project starryfood
 * @ClassName FoodServiceImpl
 * @Author StarryHu
 * @Description 菜品业务逻辑层
 * @Date 2019/7/2 9:47
 */
@Service("foodService")
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private FoodExtendMapper foodExtendMapper;

    /***
     * 添加菜品
     * @param fname
     * @param price
     * @param measurement
     * @param introduce
     * @param img
     * @return
     * @throws Exception
     */
    public int addFood(String fname, BigDecimal price, String measurement,
                       String introduce, String img, String createUser) throws Exception {
        Food food = new Food();
        Date date = new Date();
        food.setFid(IDGenerator.generator());
        food.setFname(fname);
        food.setPrice(price);
        food.setMeasurement(measurement);
        food.setIntroduce(introduce);
        food.setImg(img);
        food.setCreateTime(date);
        food.setCreateUser(createUser);
        food.setIsDel(0);

        int n = foodMapper.insert(food);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_ADD_FAIL);
    }

    /**
     * 删除菜品，逻辑删除
     *
     * @param id 菜品uuid
     * @return
     * @throws Exception
     */
    public int deleteFood(String id, String updateUser) throws Exception {
        Food food = foodMapper.selectByPrimaryKey(id);
        if (food == null || food.getIsDel() == 1) throw new SAException(ExceptionEnum.FOOD_DELETE_NOT_EXIST);
        Date date = new Date();
        food.setIsDel(1);
        food.setUpdateTime(date);
        food.setUpdateUser(updateUser);
        int n = foodMapper.updateByPrimaryKey(food);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_DELETE_FAIL);
    }

    /***
     * 更新菜品信息
     * @param fid
     * @param fname
     * @param price
     * @param measurement
     * @param introduce
     * @param img
     * @return
     * @throws Exception
     */
    public int updateFood(String fid, String fname, BigDecimal price, String measurement,
                          String introduce, String img, String updateUser) throws Exception {
        Food food = foodMapper.selectByPrimaryKey(fid);
        if (food == null || food.getIsDel() == 1) throw new SAException(ExceptionEnum.FOOD_UPDATE_NOT_EXIST);
        food.setFname(fname);
        food.setPrice(price);
        food.setMeasurement(measurement);
        food.setIntroduce(introduce);
        food.setImg(img);
        Date date = new Date();
        food.setUpdateTime(date);
        food.setUpdateUser(updateUser);
        food.setIsDel(0);

        int n = foodMapper.insert(food);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_UPDATE_FAIL);
    }

    public FoodExtend getFoodById(String fid) throws Exception{
        FoodExtend foodExtend = foodExtendMapper.getFoodById(fid);
        if (foodExtend == null) throw new SAException(ExceptionEnum.FOOD_SEARCH_NULL);
        // 处理时间戳 需要判空
        if (null != foodExtend.getCreateTime()) {
            String createTimeString = DateStamp.stampToDate(foodExtend.getCreateTime());
            foodExtend.setCreateTimeString(createTimeString);
        }
        if (null != foodExtend.getUpdateTime()) {
            String updateTimeString = DateStamp.stampToDate(foodExtend.getUpdateTime());
            foodExtend.setUpdateTimeString(updateTimeString);
        }
        // 返回对象
        return foodExtend;
    }
    /**
     * 分页查询全部菜品
     * @param pageNum 页号
     * @param pageSize 每页的大小
     * @return
     * @throws Exception
     */
    public PageInfo<FoodExtend> getAllFoods(int pageNum, int pageSize) throws Exception {
        // 开启分页查询，写在查询语句之前
        PageHelper.startPage(pageNum, pageSize);
        // 获取查询到的对象
        List<FoodExtend> foodList = foodExtendMapper.getAllFoods();
        //如果查到的数据为空，则抛出异常
        if (foodList.size() == 0) throw new SAException(ExceptionEnum.FOOD_SEARCH_NULL);
        // 封装成分页对象
        PageInfo<FoodExtend> pageInfo = new PageInfo<>(foodList);
        return pageInfo;
    }
}
