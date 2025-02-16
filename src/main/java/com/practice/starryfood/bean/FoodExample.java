package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FoodExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFoodIdIsNull() {
            addCriterion("food_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodIdIsNotNull() {
            addCriterion("food_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodIdEqualTo(String value) {
            addCriterion("food_id =", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotEqualTo(String value) {
            addCriterion("food_id <>", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThan(String value) {
            addCriterion("food_id >", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdGreaterThanOrEqualTo(String value) {
            addCriterion("food_id >=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThan(String value) {
            addCriterion("food_id <", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLessThanOrEqualTo(String value) {
            addCriterion("food_id <=", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdLike(String value) {
            addCriterion("food_id like", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotLike(String value) {
            addCriterion("food_id not like", value, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdIn(List<String> values) {
            addCriterion("food_id in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotIn(List<String> values) {
            addCriterion("food_id not in", values, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdBetween(String value1, String value2) {
            addCriterion("food_id between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodIdNotBetween(String value1, String value2) {
            addCriterion("food_id not between", value1, value2, "foodId");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNull() {
            addCriterion("food_name is null");
            return (Criteria) this;
        }

        public Criteria andFoodNameIsNotNull() {
            addCriterion("food_name is not null");
            return (Criteria) this;
        }

        public Criteria andFoodNameEqualTo(String value) {
            addCriterion("food_name =", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotEqualTo(String value) {
            addCriterion("food_name <>", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThan(String value) {
            addCriterion("food_name >", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameGreaterThanOrEqualTo(String value) {
            addCriterion("food_name >=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThan(String value) {
            addCriterion("food_name <", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLessThanOrEqualTo(String value) {
            addCriterion("food_name <=", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameLike(String value) {
            addCriterion("food_name like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotLike(String value) {
            addCriterion("food_name not like", value, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameIn(List<String> values) {
            addCriterion("food_name in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotIn(List<String> values) {
            addCriterion("food_name not in", values, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameBetween(String value1, String value2) {
            addCriterion("food_name between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodNameNotBetween(String value1, String value2) {
            addCriterion("food_name not between", value1, value2, "foodName");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdIsNull() {
            addCriterion("food_kind_id is null");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdIsNotNull() {
            addCriterion("food_kind_id is not null");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdEqualTo(String value) {
            addCriterion("food_kind_id =", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdNotEqualTo(String value) {
            addCriterion("food_kind_id <>", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdGreaterThan(String value) {
            addCriterion("food_kind_id >", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdGreaterThanOrEqualTo(String value) {
            addCriterion("food_kind_id >=", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdLessThan(String value) {
            addCriterion("food_kind_id <", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdLessThanOrEqualTo(String value) {
            addCriterion("food_kind_id <=", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdLike(String value) {
            addCriterion("food_kind_id like", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdNotLike(String value) {
            addCriterion("food_kind_id not like", value, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdIn(List<String> values) {
            addCriterion("food_kind_id in", values, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdNotIn(List<String> values) {
            addCriterion("food_kind_id not in", values, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdBetween(String value1, String value2) {
            addCriterion("food_kind_id between", value1, value2, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodKindIdNotBetween(String value1, String value2) {
            addCriterion("food_kind_id not between", value1, value2, "foodKindId");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIsNull() {
            addCriterion("food_price is null");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIsNotNull() {
            addCriterion("food_price is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPriceEqualTo(BigDecimal value) {
            addCriterion("food_price =", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotEqualTo(BigDecimal value) {
            addCriterion("food_price <>", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceGreaterThan(BigDecimal value) {
            addCriterion("food_price >", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("food_price >=", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLessThan(BigDecimal value) {
            addCriterion("food_price <", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("food_price <=", value, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceIn(List<BigDecimal> values) {
            addCriterion("food_price in", values, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotIn(List<BigDecimal> values) {
            addCriterion("food_price not in", values, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("food_price between", value1, value2, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("food_price not between", value1, value2, "foodPrice");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementIsNull() {
            addCriterion("food_measurement is null");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementIsNotNull() {
            addCriterion("food_measurement is not null");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementEqualTo(String value) {
            addCriterion("food_measurement =", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementNotEqualTo(String value) {
            addCriterion("food_measurement <>", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementGreaterThan(String value) {
            addCriterion("food_measurement >", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementGreaterThanOrEqualTo(String value) {
            addCriterion("food_measurement >=", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementLessThan(String value) {
            addCriterion("food_measurement <", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementLessThanOrEqualTo(String value) {
            addCriterion("food_measurement <=", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementLike(String value) {
            addCriterion("food_measurement like", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementNotLike(String value) {
            addCriterion("food_measurement not like", value, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementIn(List<String> values) {
            addCriterion("food_measurement in", values, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementNotIn(List<String> values) {
            addCriterion("food_measurement not in", values, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementBetween(String value1, String value2) {
            addCriterion("food_measurement between", value1, value2, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodMeasurementNotBetween(String value1, String value2) {
            addCriterion("food_measurement not between", value1, value2, "foodMeasurement");
            return (Criteria) this;
        }

        public Criteria andFoodImgIsNull() {
            addCriterion("food_img is null");
            return (Criteria) this;
        }

        public Criteria andFoodImgIsNotNull() {
            addCriterion("food_img is not null");
            return (Criteria) this;
        }

        public Criteria andFoodImgEqualTo(String value) {
            addCriterion("food_img =", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgNotEqualTo(String value) {
            addCriterion("food_img <>", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgGreaterThan(String value) {
            addCriterion("food_img >", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgGreaterThanOrEqualTo(String value) {
            addCriterion("food_img >=", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgLessThan(String value) {
            addCriterion("food_img <", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgLessThanOrEqualTo(String value) {
            addCriterion("food_img <=", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgLike(String value) {
            addCriterion("food_img like", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgNotLike(String value) {
            addCriterion("food_img not like", value, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgIn(List<String> values) {
            addCriterion("food_img in", values, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgNotIn(List<String> values) {
            addCriterion("food_img not in", values, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgBetween(String value1, String value2) {
            addCriterion("food_img between", value1, value2, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodImgNotBetween(String value1, String value2) {
            addCriterion("food_img not between", value1, value2, "foodImg");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldIsNull() {
            addCriterion("food_has_sold is null");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldIsNotNull() {
            addCriterion("food_has_sold is not null");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldEqualTo(Integer value) {
            addCriterion("food_has_sold =", value, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldNotEqualTo(Integer value) {
            addCriterion("food_has_sold <>", value, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldGreaterThan(Integer value) {
            addCriterion("food_has_sold >", value, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_has_sold >=", value, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldLessThan(Integer value) {
            addCriterion("food_has_sold <", value, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldLessThanOrEqualTo(Integer value) {
            addCriterion("food_has_sold <=", value, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldIn(List<Integer> values) {
            addCriterion("food_has_sold in", values, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldNotIn(List<Integer> values) {
            addCriterion("food_has_sold not in", values, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldBetween(Integer value1, Integer value2) {
            addCriterion("food_has_sold between", value1, value2, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andFoodHasSoldNotBetween(Integer value1, Integer value2) {
            addCriterion("food_has_sold not between", value1, value2, "foodHasSold");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}