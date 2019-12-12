package com.practice.starryfood.service.ServiceImpl;

import com.practice.starryfood.bean.Food;
import com.practice.starryfood.bean.FoodExample;
import com.practice.starryfood.bean.FoodKind;
import com.practice.starryfood.dao.FoodKindMapper;
import com.practice.starryfood.dao.FoodMapper;
import com.practice.starryfood.daoExtend.FoodExtendMapper;
import com.practice.starryfood.daoExtend.FoodKindExtendMapper;
import com.practice.starryfood.enums.ExceptionEnum;
import com.practice.starryfood.exception.SAException;
import com.practice.starryfood.pojo.FoodExtend;
import com.practice.starryfood.pojo.FoodKindExtend;
import com.practice.starryfood.pojo.OrderFoodExtend;
import com.practice.starryfood.service.FoodKindService;
import com.practice.starryfood.util.DateStamp;
import com.practice.starryfood.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Project starryfood
 * @ClassName FoodKindService
 * @Author StarryHu
 * @Description 菜品种类业务逻辑层
 * @Date 2019/12/2 14:49
 */
@Service("foodKindService")
public class FoodKindServiceImpl implements FoodKindService {
    @Autowired
    private FoodKindMapper foodKindMapper;
    @Autowired
    private FoodKindExtendMapper foodKindExtendMapper;
    @Autowired
    private FoodMapper foodMapper;
    @Autowired
    private FoodExtendMapper foodExtendMapper;

    /**
     * @Description: 添加菜品种类
     * @Param: [foodKindName, session]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/2
     */
    public int addFoodKind(String foodKindName, String createUser) throws Exception {
        FoodKind foodKind = new FoodKind();
        String foodKindId = IDGenerator.generator();
        foodKind.setFoodKindId(foodKindId);
        foodKind.setFoodKindName(foodKindName);
        Date date = new Date();
        foodKind.setCreateTime(date);
        foodKind.setCreateUser(createUser);
        foodKind.setIsDel(0);

        int n = foodKindMapper.insert(foodKind);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_KIND_ADD_FAIL);
    }

    /**
     * @Description: 删除某菜品种类，同时级联删除其下的所有菜品信息
     * @Param: [foodKindId, updateUser]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/2
     */
    public int deleteFoodKind(String foodKindId, String updateUser) throws Exception {
        // 查找该菜品种类是否存在
        FoodKind foodKind = foodKindMapper.selectByPrimaryKey(foodKindId);
        if (foodKind == null) throw new SAException(ExceptionEnum.FOOD_KIND_DELETE_NOT_EXIST);
        // 查找该菜品种类下是否还有相关菜品
        FoodExample foodExample = new FoodExample();
        foodExample.createCriteria().andFoodKindIdEqualTo(foodKindId);
        List<Food> foodList = foodMapper.selectByExample(foodExample);

        // 如果该种类下仍存在相关的菜品，则拒绝删除
        // 由于内部菜品是逻辑删除，所以要判断菜品是否都删了
        if (foodList.size() != 0) {
            for(Food food : foodList){
                // 存在一个没有删除的 则拒绝删除
                if (food.getIsDel() == 0) throw new SAException(ExceptionEnum.FOOD_KIND_DELETE_CASCADE);
            }
        }
        // 进行逻辑删除
        Date date = new Date();
        foodKind.setIsDel(1);
        foodKind.setUpdateTime(date);
        foodKind.setUpdateUser(updateUser);

        int n = foodKindMapper.updateByPrimaryKey(foodKind);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_KIND_DELETE_FAIL);
    }

    /**
     * @Description: 更新菜品信息
     * @Param: [foodKindId, foodKindName, updateUser]
     * @return: int
     * @Author: StarryHu
     * @Date: 2019/12/2
     */
    public int updateFoodKind(String foodKindId, String foodKindName, String updateUser) throws Exception {
        // 查找该菜品种类是否存在
        FoodKind foodKind = foodKindMapper.selectByPrimaryKey(foodKindId);
        if (foodKind == null) throw new SAException(ExceptionEnum.FOOD_KIND_UPDATE_NOT_EXIST);

        Date date = new Date();
        foodKind.setFoodKindName(foodKindName);
        foodKind.setUpdateTime(date);
        foodKind.setUpdateUser(updateUser);

        int n = foodKindMapper.updateByPrimaryKeySelective(foodKind);
        if (n > 0) return n;
        throw new SAException(ExceptionEnum.FOOD_KIND_UPDATE_FAIL);
    }

    /**
    * @Description: 获取全部的菜品种类（不包括里面的全部菜品信息）
    * @Param: []
    * @return: java.util.List<com.practice.starryfood.bean.FoodKind>
    * @Author: StarryHu
    * @Date: 2019/12/2
    */
    public List<FoodKindExtend> getAllFoodKinds() throws Exception{
        List<FoodKindExtend> foodKindExtendList = foodKindExtendMapper.getAllFoodKinds();

        if (foodKindExtendList.size() == 0) throw new SAException(ExceptionEnum.FOOD_KIND_SEARCH_NOT_EXIST);

        // 对每个种类进行处理
        for(FoodKindExtend foodKindExtend : foodKindExtendList){
            // 处理时间戳
            if (null != foodKindExtend.getCreateTime()) {
                String createTimeString = DateStamp.stampToDate(foodKindExtend.getCreateTime());
                foodKindExtend.setCreateTimeString(createTimeString);
            }
            if (null != foodKindExtend.getUpdateTime()) {
                String updateTimeString = DateStamp.stampToDate(foodKindExtend.getUpdateTime());
                foodKindExtend.setUpdateTimeString(updateTimeString);
            }
        }
        return foodKindExtendList;
    }
}
