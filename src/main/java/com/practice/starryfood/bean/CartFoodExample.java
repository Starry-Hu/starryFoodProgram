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

        public Criteria andCartidIsNull() {
            addCriterion("cartId is null");
            return (Criteria) this;
        }

        public Criteria andCartidIsNotNull() {
            addCriterion("cartId is not null");
            return (Criteria) this;
        }

        public Criteria andCartidEqualTo(String value) {
            addCriterion("cartId =", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidNotEqualTo(String value) {
            addCriterion("cartId <>", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidGreaterThan(String value) {
            addCriterion("cartId >", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidGreaterThanOrEqualTo(String value) {
            addCriterion("cartId >=", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidLessThan(String value) {
            addCriterion("cartId <", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidLessThanOrEqualTo(String value) {
            addCriterion("cartId <=", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidLike(String value) {
            addCriterion("cartId like", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidNotLike(String value) {
            addCriterion("cartId not like", value, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidIn(List<String> values) {
            addCriterion("cartId in", values, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidNotIn(List<String> values) {
            addCriterion("cartId not in", values, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidBetween(String value1, String value2) {
            addCriterion("cartId between", value1, value2, "cartid");
            return (Criteria) this;
        }

        public Criteria andCartidNotBetween(String value1, String value2) {
            addCriterion("cartId not between", value1, value2, "cartid");
            return (Criteria) this;
        }

        public Criteria andFoodidIsNull() {
            addCriterion("foodId is null");
            return (Criteria) this;
        }

        public Criteria andFoodidIsNotNull() {
            addCriterion("foodId is not null");
            return (Criteria) this;
        }

        public Criteria andFoodidEqualTo(String value) {
            addCriterion("foodId =", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotEqualTo(String value) {
            addCriterion("foodId <>", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidGreaterThan(String value) {
            addCriterion("foodId >", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidGreaterThanOrEqualTo(String value) {
            addCriterion("foodId >=", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLessThan(String value) {
            addCriterion("foodId <", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLessThanOrEqualTo(String value) {
            addCriterion("foodId <=", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidLike(String value) {
            addCriterion("foodId like", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotLike(String value) {
            addCriterion("foodId not like", value, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidIn(List<String> values) {
            addCriterion("foodId in", values, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotIn(List<String> values) {
            addCriterion("foodId not in", values, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidBetween(String value1, String value2) {
            addCriterion("foodId between", value1, value2, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodidNotBetween(String value1, String value2) {
            addCriterion("foodId not between", value1, value2, "foodid");
            return (Criteria) this;
        }

        public Criteria andFoodnumIsNull() {
            addCriterion("foodNum is null");
            return (Criteria) this;
        }

        public Criteria andFoodnumIsNotNull() {
            addCriterion("foodNum is not null");
            return (Criteria) this;
        }

        public Criteria andFoodnumEqualTo(Integer value) {
            addCriterion("foodNum =", value, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumNotEqualTo(Integer value) {
            addCriterion("foodNum <>", value, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumGreaterThan(Integer value) {
            addCriterion("foodNum >", value, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("foodNum >=", value, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumLessThan(Integer value) {
            addCriterion("foodNum <", value, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumLessThanOrEqualTo(Integer value) {
            addCriterion("foodNum <=", value, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumIn(List<Integer> values) {
            addCriterion("foodNum in", values, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumNotIn(List<Integer> values) {
            addCriterion("foodNum not in", values, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumBetween(Integer value1, Integer value2) {
            addCriterion("foodNum between", value1, value2, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodnumNotBetween(Integer value1, Integer value2) {
            addCriterion("foodNum not between", value1, value2, "foodnum");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceIsNull() {
            addCriterion("foodOneTotalPrice is null");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceIsNotNull() {
            addCriterion("foodOneTotalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceEqualTo(BigDecimal value) {
            addCriterion("foodOneTotalPrice =", value, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceNotEqualTo(BigDecimal value) {
            addCriterion("foodOneTotalPrice <>", value, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceGreaterThan(BigDecimal value) {
            addCriterion("foodOneTotalPrice >", value, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("foodOneTotalPrice >=", value, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceLessThan(BigDecimal value) {
            addCriterion("foodOneTotalPrice <", value, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("foodOneTotalPrice <=", value, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceIn(List<BigDecimal> values) {
            addCriterion("foodOneTotalPrice in", values, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceNotIn(List<BigDecimal> values) {
            addCriterion("foodOneTotalPrice not in", values, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foodOneTotalPrice between", value1, value2, "foodonetotalprice");
            return (Criteria) this;
        }

        public Criteria andFoodonetotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("foodOneTotalPrice not between", value1, value2, "foodonetotalprice");
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