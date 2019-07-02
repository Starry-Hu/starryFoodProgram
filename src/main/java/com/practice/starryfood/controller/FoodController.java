package com.practice.starryfood.controller;

import com.github.pagehelper.PageInfo;
import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.FoodExtend;
import com.practice.starryfood.service.FoodService;
import com.practice.starryfood.util.BaseResponse;
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
     * 添加菜品信息
     *
     * @param name        菜品名称
     * @param price       单价
     * @param measurement 计量单位
     * @param introduce   简介
     * @param img         图片
     * @param createUser  创建者
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    public BaseResponse addFood(String name, BigDecimal price, String measurement, String introduce,
                                String img, String createUser) throws Exception {
        // 判断信息是否填写完全
        if (name == null || price == null || measurement == null || name.trim().equals("")
                || price.equals(0.0) || measurement.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 进行菜品添加
        foodService.addFood(name, price, measurement, introduce, img, createUser);
        return ajaxSucc(null, ResultEnum.FOOD_ADD_SUCCESS);
    }

    /***
     * 删除菜品
     * @param id 菜品id
     * @param updateUser 更新者
     * @return
     * @throws Exception
     */
    @GetMapping("/delete")
    public BaseResponse deleteFood(String id, String updateUser) throws Exception {
        // 判断信息是否填写完全
        if (id == null || id.trim().equals("")) return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 进行删除
        foodService.deleteFood(id, updateUser);
        return ajaxSucc(null, ResultEnum.FOOD_DELETE_SUCCESS);
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
