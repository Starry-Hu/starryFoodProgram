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

    /**
    * @Description: 添加菜品
    * @Param: [foodName, foodPrice, foodMeasurement, foodIntroduce, foodImg, createUser]
    * @return: int
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    public int addFood(String foodName, BigDecimal foodPrice, String foodMeasurement,
                       String foodIntroduce, String foodImg, String createUser) throws Exception {
        Food food = new Food();
        Date date = new Date();
        food.setFoodId(IDGenerator.generator());
        food.setFoodName(foodName);
        food.setFoodPrice(foodPrice);
        food.setFoodMeasurement(foodMeasurement);
        food.setFoodIntroduce(foodIntroduce);
        food.setFoodImg(foodImg);
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
     * @param foodId 菜品uuid
     * @return
     * @throws Exception
     */
    public int deleteFood(String foodId, String updateUser) throws Exception {
        Food food = foodMapper.selectByPrimaryKey(foodId);
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
     * @param foodId
     * @param foodName
     * @param foodPrice
     * @param foodMeasurement
     * @param foodIntroduce
     * @param foodImg
     * @return
     * @throws Exception
     */
    public int updateFood(String foodId, String foodName, BigDecimal foodPrice, String foodMeasurement,
                          String foodIntroduce, String foodImg, String updateUser) throws Exception {
        Food food = foodMapper.selectByPrimaryKey(foodId);
        if (food == null || food.getIsDel() == 1) throw new SAException(ExceptionEnum.FOOD_UPDATE_NOT_EXIST);

        Date date = new Date();
        food.setFoodName(foodName);
        food.setFoodPrice(foodPrice);
        food.setFoodMeasurement(foodMeasurement);
        food.setFoodIntroduce(foodIntroduce);
        food.setFoodImg(foodImg);
        food.setUpdateTime(date);
        food.setUpdateUser(updateUser);
        food.setIsDel(0);

        int n = foodMapper.updateByPrimaryKey(food);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_UPDATE_FAIL);
    }

    /** 
    * @Description: 根据id获取食品 
    * @Param: [foodId] 
    * @return: com.practice.starryfood.pojo.FoodExtend 
    * @Author: StarryHu
    * @Date: 2019/11/20 
    */ 
    public FoodExtend getFoodById(String foodId) throws Exception{
        FoodExtend foodExtend = foodExtendMapper.getFoodById(foodId);
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
