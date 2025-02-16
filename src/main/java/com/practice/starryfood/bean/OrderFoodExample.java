package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderFoodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFoodExample() {
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

        public Criteria andOrderFoodUuidIsNull() {
            addCriterion("order_food_uuid is null");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidIsNotNull() {
            addCriterion("order_food_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidEqualTo(String value) {
            addCriterion("order_food_uuid =", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidNotEqualTo(String value) {
            addCriterion("order_food_uuid <>", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidGreaterThan(String value) {
            addCriterion("order_food_uuid >", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidGreaterThanOrEqualTo(String value) {
            addCriterion("order_food_uuid >=", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidLessThan(String value) {
            addCriterion("order_food_uuid <", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidLessThanOrEqualTo(String value) {
            addCriterion("order_food_uuid <=", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidLike(String value) {
            addCriterion("order_food_uuid like", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidNotLike(String value) {
            addCriterion("order_food_uuid not like", value, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidIn(List<String> values) {
            addCriterion("order_food_uuid in", values, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidNotIn(List<String> values) {
            addCriterion("order_food_uuid not in", values, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidBetween(String value1, String value2) {
            addCriterion("order_food_uuid between", value1, value2, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderFoodUuidNotBetween(String value1, String value2) {
            addCriterion("order_food_uuid not between", value1, value2, "orderFoodUuid");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andFoodOneTotalPriceIsNull() {
            addCriterion("food_one_total_price is null");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceIsNotNull() {
            addCriterion("food_one_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceEqualTo(BigDecimal value) {
            addCriterion("food_one_total_price =", value, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceNotEqualTo(BigDecimal value) {
            addCriterion("food_one_total_price <>", value, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceGreaterThan(BigDecimal value) {
            addCriterion("food_one_total_price >", value, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("food_one_total_price >=", value, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceLessThan(BigDecimal value) {
            addCriterion("food_one_total_price <", value, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("food_one_total_price <=", value, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceIn(List<BigDecimal> values) {
            addCriterion("food_one_total_price in", values, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceNotIn(List<BigDecimal> values) {
            addCriterion("food_one_total_price not in", values, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("food_one_total_price between", value1, value2, "foodOneTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFoodOneTotalPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("food_one_total_price not between", value1, value2, "foodOneTotalPrice");
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