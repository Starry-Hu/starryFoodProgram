package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartFoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartFoodExample() {
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

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCartlistIdIsNull() {
            addCriterion("cartList_id is null");
            return (Criteria) this;
        }

        public Criteria andCartlistIdIsNotNull() {
            addCriterion("cartList_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartlistIdEqualTo(String value) {
            addCriterion("cartList_id =", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdNotEqualTo(String value) {
            addCriterion("cartList_id <>", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdGreaterThan(String value) {
            addCriterion("cartList_id >", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdGreaterThanOrEqualTo(String value) {
            addCriterion("cartList_id >=", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdLessThan(String value) {
            addCriterion("cartList_id <", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdLessThanOrEqualTo(String value) {
            addCriterion("cartList_id <=", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdLike(String value) {
            addCriterion("cartList_id like", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdNotLike(String value) {
            addCriterion("cartList_id not like", value, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdIn(List<String> values) {
            addCriterion("cartList_id in", values, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdNotIn(List<String> values) {
            addCriterion("cartList_id not in", values, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdBetween(String value1, String value2) {
            addCriterion("cartList_id between", value1, value2, "cartlistId");
            return (Criteria) this;
        }

        public Criteria andCartlistIdNotBetween(String value1, String value2) {
            addCriterion("cartList_id not between", value1, value2, "cartlistId");
            return (Criteria) this;
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

        public Criteria andFoodNumIsNull() {
            addCriterion("food_num is null");
            return (Criteria) this;
        }

        public Criteria andFoodNumIsNotNull() {
            addCriterion("food_num is not null");
            return (Criteria) this;
        }

        public Criteria andFoodNumEqualTo(Integer value) {
            addCriterion("food_num =", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumNotEqualTo(Integer value) {
            addCriterion("food_num <>", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumGreaterThan(Integer value) {
            addCriterion("food_num >", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("food_num >=", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumLessThan(Integer value) {
            addCriterion("food_num <", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumLessThanOrEqualTo(Integer value) {
            addCriterion("food_num <=", value, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumIn(List<Integer> values) {
            addCriterion("food_num in", values, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumNotIn(List<Integer> values) {
            addCriterion("food_num not in", values, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumBetween(Integer value1, Integer value2) {
            addCriterion("food_num between", value1, value2, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodNumNotBetween(Integer value1, Integer value2) {
            addCriterion("food_num not between", value1, value2, "foodNum");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceIsNull() {
            addCriterion("food_oneTotalPrice is null");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceIsNotNull() {
            addCriterion("food_oneTotalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceEqualTo(BigDecimal value) {
            addCriterion("food_oneTotalPrice =", value, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceNotEqualTo(BigDecimal value) {
            addCriterion("food_oneTotalPrice <>", value, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceGreaterThan(BigDecimal value) {
            addCriterion("food_oneTotalPrice >", value, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("food_oneTotalPrice >=", value, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceLessThan(BigDecimal value) {
            addCriterion("food_oneTotalPrice <", value, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("food_oneTotalPrice <=", value, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceIn(List<BigDecimal> values) {
            addCriterion("food_oneTotalPrice in", values, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceNotIn(List<BigDecimal> values) {
            addCriterion("food_oneTotalPrice not in", values, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("food_oneTotalPrice between", value1, value2, "foodOnetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodOnetotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("food_oneTotalPrice not between", value1, value2, "foodOnetotalprice");
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