package com.practice.starryfood.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderCreateCustomerIsNull() {
            addCriterion("order_create_customer is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerIsNotNull() {
            addCriterion("order_create_customer is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerEqualTo(String value) {
            addCriterion("order_create_customer =", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerNotEqualTo(String value) {
            addCriterion("order_create_customer <>", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerGreaterThan(String value) {
            addCriterion("order_create_customer >", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("order_create_customer >=", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerLessThan(String value) {
            addCriterion("order_create_customer <", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerLessThanOrEqualTo(String value) {
            addCriterion("order_create_customer <=", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerLike(String value) {
            addCriterion("order_create_customer like", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerNotLike(String value) {
            addCriterion("order_create_customer not like", value, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerIn(List<String> values) {
            addCriterion("order_create_customer in", values, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerNotIn(List<String> values) {
            addCriterion("order_create_customer not in", values, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerBetween(String value1, String value2) {
            addCriterion("order_create_customer between", value1, value2, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateCustomerNotBetween(String value1, String value2) {
            addCriterion("order_create_customer not between", value1, value2, "orderCreateCustomer");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceIsNull() {
            addCriterion("order_sum_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceIsNotNull() {
            addCriterion("order_sum_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceEqualTo(BigDecimal value) {
            addCriterion("order_sum_price =", value, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_sum_price <>", value, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceGreaterThan(BigDecimal value) {
            addCriterion("order_sum_price >", value, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_sum_price >=", value, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceLessThan(BigDecimal value) {
            addCriterion("order_sum_price <", value, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_sum_price <=", value, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceIn(List<BigDecimal> values) {
            addCriterion("order_sum_price in", values, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_sum_price not in", values, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_sum_price between", value1, value2, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderSumPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_sum_price not between", value1, value2, "orderSumPrice");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminIsNull() {
            addCriterion("order_deal_admin is null");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminIsNotNull() {
            addCriterion("order_deal_admin is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminEqualTo(String value) {
            addCriterion("order_deal_admin =", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminNotEqualTo(String value) {
            addCriterion("order_deal_admin <>", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminGreaterThan(String value) {
            addCriterion("order_deal_admin >", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminGreaterThanOrEqualTo(String value) {
            addCriterion("order_deal_admin >=", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminLessThan(String value) {
            addCriterion("order_deal_admin <", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminLessThanOrEqualTo(String value) {
            addCriterion("order_deal_admin <=", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminLike(String value) {
            addCriterion("order_deal_admin like", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminNotLike(String value) {
            addCriterion("order_deal_admin not like", value, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminIn(List<String> values) {
            addCriterion("order_deal_admin in", values, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminNotIn(List<String> values) {
            addCriterion("order_deal_admin not in", values, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminBetween(String value1, String value2) {
            addCriterion("order_deal_admin between", value1, value2, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderDealAdminNotBetween(String value1, String value2) {
            addCriterion("order_deal_admin not between", value1, value2, "orderDealAdmin");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeIsNull() {
            addCriterion("order_update_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeIsNotNull() {
            addCriterion("order_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeEqualTo(Date value) {
            addCriterion("order_update_time =", value, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeNotEqualTo(Date value) {
            addCriterion("order_update_time <>", value, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeGreaterThan(Date value) {
            addCriterion("order_update_time >", value, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_update_time >=", value, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeLessThan(Date value) {
            addCriterion("order_update_time <", value, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_update_time <=", value, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeIn(List<Date> values) {
            addCriterion("order_update_time in", values, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeNotIn(List<Date> values) {
            addCriterion("order_update_time not in", values, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("order_update_time between", value1, value2, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_update_time not between", value1, value2, "orderUpdateTime");
            return (Criteria) this;
        }

        public Criteria andOrderConditionIsNull() {
            addCriterion("order_condition is null");
            return (Criteria) this;
        }

        public Criteria andOrderConditionIsNotNull() {
            addCriterion("order_condition is not null");
            return (Criteria) this;
        }

        public Criteria andOrderConditionEqualTo(Integer value) {
            addCriterion("order_condition =", value, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionNotEqualTo(Integer value) {
            addCriterion("order_condition <>", value, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionGreaterThan(Integer value) {
            addCriterion("order_condition >", value, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_condition >=", value, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionLessThan(Integer value) {
            addCriterion("order_condition <", value, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionLessThanOrEqualTo(Integer value) {
            addCriterion("order_condition <=", value, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionIn(List<Integer> values) {
            addCriterion("order_condition in", values, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionNotIn(List<Integer> values) {
            addCriterion("order_condition not in", values, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionBetween(Integer value1, Integer value2) {
            addCriterion("order_condition between", value1, value2, "orderCondition");
            return (Criteria) this;
        }

        public Criteria andOrderConditionNotBetween(Integer value1, Integer value2) {
            addCriterion("order_condition not between", value1, value2, "orderCondition");
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