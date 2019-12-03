package com.practice.starryfood.controller;

import com.practice.starryfood.enums.ResultEnum;
import com.practice.starryfood.pojo.FoodKindExtend;
import com.practice.starryfood.service.FoodKindService;
import com.practice.starryfood.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Project starryfood
 * @ClassName FoodKindController
 * @Author StarryHu
 * @Description 菜品种类相关接口
 * @Date 2019/12/2 16:12
 */
@RestController
@RequestMapping("foodKind")
public class FoodKindController extends BaseController{
    @Autowired
    private FoodKindService foodKindService;

    /**
    * @Description: 添加菜品种类
    * @Param: [foodKindName, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    @PostMapping("/add")
    public BaseResponse addFoodKind(String foodKindName, HttpSession session) throws Exception {
        // 判断信息是否填写完成
        if (foodKindName == null || foodKindName.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_KIND_INFO_NOT_FULL);

        // 获取当前登录的管理员作为创建者
        String createUser = (String) session.getAttribute("adminUuid");
        // 进行菜品添加
        foodKindService.addFoodKind(foodKindName,createUser);
        return ajaxSucc(null, ResultEnum.FOOD_KIND_ADD_SUCCESS);
    }

    /**
    * @Description: 删除菜品种类（逻辑删除）
    * @Param: [foodKindId, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    @GetMapping("/delete")
    public BaseResponse deleteFoodKind(String foodKindId, HttpSession session) throws Exception {
        // 判断信息是否填写完成
        if (foodKindId == null || foodKindId.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_KIND_INFO_NOT_FULL);

        // 获取当前登录的管理员作为更新者
        String updateUser = (String) session.getAttribute("adminUuid");
        // 进行菜品种类添加
        foodKindService.deleteFoodKind(foodKindId,updateUser);
        return ajaxSucc(null, ResultEnum.FOOD_KIND_DELETE_SUCCESS);
    }

    /**
    * @Description: 更新菜品种类
    * @Param: [foodKindId, foodKindName, session]
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    @PostMapping("/update")
    public BaseResponse updateFoodKind(String foodKindId, String foodKindName, HttpSession session) throws Exception {
        // 判断信息是否填写完成
        if (foodKindName == null || foodKindName.trim().equals(""))
            return ajaxFail(ResultEnum.FOOD_KIND_INFO_NOT_FULL);

        // 获取当前登录的管理员作为更新者
        String updateUser = (String) session.getAttribute("adminUuid");
        // 进行菜品添加
        foodKindService.updateFoodKind(foodKindId,foodKindName,updateUser);
        return ajaxSucc(null, ResultEnum.FOOD_KIND_UPDATE_SUCCESS);
    }

    /**
    * @Description: 获取全部菜品种类
    * @Param: []
    * @return: com.practice.starryfood.util.BaseResponse
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    @GetMapping("/getAllFoodKinds")
    public BaseResponse getAllFoodKinds() throws Exception {
        List<FoodKindExtend> foodKindExtendList = foodKindService.getAllFoodKinds();
        return ajaxSucc(foodKindExtendList,ResultEnum.FOOD_KIND_SEARCH_SUCCESS);
    }

}
