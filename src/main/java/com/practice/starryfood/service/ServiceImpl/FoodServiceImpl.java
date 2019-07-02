package com.practice.starryfood.service.ServiceImpl;

import com.github.pagehelper.PageHelper;
import com.practice.starryfood.bean.Food;
import com.practice.starryfood.dao.FoodMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.service.FoodService;
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

    /***
     * 添加菜品
     * @param name
     * @param price
     * @param measurement
     * @param introduce
     * @param img
     * @return
     * @throws Exception
     */
    public int addFood(String name, BigDecimal price, String measurement,
                       String introduce, String img, String createUser) throws Exception {
        Food food = new Food();
        Date date = new Date();
        food.setId(IDGenerator.generator());
        food.setName(name);
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
     * @param id
     * @param name
     * @param price
     * @param measurement
     * @param introduce
     * @param img
     * @return
     * @throws Exception
     */
    public int updateFood(String id, String name, BigDecimal price, String measurement,
                          String introduce, String img, String updateUser) throws Exception {
        Food food = foodMapper.selectByPrimaryKey(id);
        if (food == null || food.getIsDel() == 1) throw new SAException(ExceptionEnum.FOOD_UPDATE_NOT_EXIST);
        food.setName(name);
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

    public int getFoodByName() throws Exception {
        return 0;
    }


    public List<Food> getAllFoods(int pageNum, int pageSize) throws Exception {
        // 设置分页
        PageHelper.startPage(pageNum, pageSize);
//        List<Food> foodList = foodMapper.sele
        return null;
    }
}
