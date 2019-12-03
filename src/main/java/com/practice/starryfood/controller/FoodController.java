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

import javax.servlet.http.HttpSession;
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
    * @Param: [foodName, foodKindId, foodPrice, foodMeasurement, foodIntroduce, foodImg, createUser]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @PostMapping("/add")
    public BaseResponse addFood(String foodName,String foodKindId, BigDecimal foodPrice, String foodMeasurement, String foodIntroduce,
                                String foodImg, HttpSession session) throws Exception {
        // 判断信息是否填写完全
        if (foodName == null || foodKindId == null || foodPrice == null || foodMeasurement == null || foodName.trim().equals("")
                || foodKindId.trim().equals("") || foodPrice.equals(0.0) || foodMeasurement.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 获取当前登录的管理员作为创建者
        String createUser = (String) session.getAttribute("adminUuid");
        // 进行菜品添加
        foodService.addFood(foodName, foodKindId, foodPrice, foodMeasurement, foodIntroduce, foodImg, createUser);
        return ajaxSucc(null, ResultEnum.FOOD_ADD_SUCCESS);
    }

    /**
    * @Description: 删除菜品(逻辑删除)
    * @Param: [foodId, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/11/21
    */
    @GetMapping("/delete")
    public BaseResponse deleteFood(String foodId, HttpSession session) throws Exception {
        // 判断信息是否填写完全
        if (foodId == null || foodId.trim().equals("")) return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");

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
    public BaseResponse updateFood(String foodId, String foodKindId, String foodName, BigDecimal foodPrice, String foodMeasurement, String foodIntroduce,
                                   String foodImg, HttpSession session) throws Exception {
        // 判断信息是否填写完全
        if (foodName == null || foodKindId == null || foodPrice == null || foodMeasurement == null || foodName.trim().equals("")
                || foodKindId.trim().equals("") || foodPrice.equals(0.0) || foodMeasurement.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_INFO_NOT_FULL);
        // 获取当前登录的管理员
        String updateUser = (String) session.getAttribute("adminUuid");
        // 进行菜品更新
        foodService.updateFood(foodId,foodKindId,foodName, foodPrice, foodMeasurement, foodIntroduce, foodImg, updateUser);
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
    * @Description: 获取全部菜品（带分页）
    * @Param: [pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
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

    /**
    * @Description: 获取指定菜品种类的菜品信息（带分页）
    * @Param: [foodKindId, pageNum, pageSize]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    @GetMapping("/getFoodsByKind")
    public BaseResponse getFoodsByKind(String foodKindId,Integer pageNum, Integer pageSize) throws Exception {
        // 判断信息是否填写完全，如果分页条件未填写则给默认值
        if (pageNum == null || pageSize == null) {
            pageNum = 1;
            pageSize = 10;
        }
        // 进行查找
        PageInfo<FoodExtend> pageInfo =  foodService.getFoodsByKind(foodKindId,pageNum,pageSize);
        return ajaxSucc(pageInfo,ResultEnum.FOOD_SEARCH_SUCCESS);
    }
}
