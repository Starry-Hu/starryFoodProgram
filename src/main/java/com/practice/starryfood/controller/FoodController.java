package com.practice.starryfood.controller;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.daoExtend.FoodExtendMapper;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.FoodExtend;
import com.practice.starryfood.service.FoodService;
import com.practice.starryfood.util.BaseResponse;
import com.practice.starryfood.util.DateStamp;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Project starryfood
 * @ClassName FoodController
 * @Author StarryHu
 * @Description 菜品相关接口
 * @Date 2019/7/2 15:24
 */
@RestController
@RequestMapping("food")
public class FoodController extends BaseController {
    @Autowired
    private FoodService foodService;

    /**
    * @Description: 添加菜品信息
    * @Param: [foodName, foodPrice, foodMeasurement, foodIntroduce, foodImg, createUser]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @PostMapping("/add")
    public BaseResponse addFood(String foodName, BigDecimal foodPrice, String foodMeasurement, String foodIntroduce,
                                String foodImg, String createUser) throws Exception {
        // 判断信息是否填写完全
        if (foodName == null || foodPrice == null || foodMeasurement == null || foodName.trim().equals("")
                || foodPrice.equals(0.0) || foodMeasurement.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 进行菜品添加
        foodService.addFood(foodName, foodPrice, foodMeasurement, foodIntroduce, foodImg, createUser);
        return ajaxSucc(null, ResultEnum.FOOD_ADD_SUCCESS);
    }

    /***
     * 删除菜品
     * @param foodId 菜品id
     * @param updateUser 更新者
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    public BaseResponse deleteFood(String foodId, String updateUser) throws Exception {
        // 判断信息是否填写完全
        if (foodId == null || foodId.trim().equals("")) return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 进行删除
        foodService.deleteFood(foodId, updateUser);
        return ajaxSucc(null, ResultEnum.FOOD_DELETE_SUCCESS);
    }


    /**
    * @Description: 更新菜品信息（根据foodId获取到）
    * @Param: [foodName, foodPrice, foodMeasurement, foodIntroduce, foodImg, updateUser]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @PostMapping("/update")
    public BaseResponse updateFood(String foodId, String foodName, BigDecimal foodPrice, String foodMeasurement, String foodIntroduce,
                                   String foodImg, String updateUser) throws Exception {
        // 判断信息是否填写完全
        if (foodId == null ||foodName == null || foodPrice == null || foodMeasurement == null || foodName.trim().equals("")
                || foodId.trim().equals("") || foodPrice.equals(0.0) || foodMeasurement.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 进行菜品更新
        foodService.updateFood(foodId,foodName, foodPrice, foodMeasurement, foodIntroduce, foodImg, updateUser);
        return ajaxSucc(null, ResultEnum.FOOD_UPDATE_SUCCESS);
    }

    /**
     * 根据菜品id获取菜品信息
     * @param foodId
     * @return
     * @throws Exception
     */
    @GetMapping("/getFoodById")
    public BaseResponse getFoodById(String foodId) throws Exception{
        // 判断信息是否填写完全
        if (foodId == null || foodId.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        FoodExtend foodExtend = foodService.getFoodById(foodId);
        return ajaxSucc(foodExtend,ResultEnum.FOOD_SEARCH_SUCCESS);
    }
    /**
     * 查找全部菜品（带分页）
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return
     * @throws Exception
     */
    @GetMapping("/getAllFoods")
    public BaseResponse getAllFoods(Integer pageNum, Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        // 进行查找
        PageInfo<FoodExtend> pageInfo =  foodService.getAllFoods(pageNum,pageSize);
        return ajaxSucc(pageInfo,ResultEnum.FOOD_SEARCH_SUCCESS);
    }

}
