package com.suning.cn.dto;

import java.util.ArrayList;
import java.util.List;

public class AfterGoodsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public AfterGoodsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table after_goods
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table after_goods
     *
     * @mbg.generated
     */
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

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(String value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(String value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(String value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(String value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(String value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(String value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLike(String value) {
            addCriterion("goods_id like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotLike(String value) {
            addCriterion("goods_id not like", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<String> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<String> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(String value1, String value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(String value1, String value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageIsNull() {
            addCriterion("goods_package is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageIsNotNull() {
            addCriterion("goods_package is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageEqualTo(String value) {
            addCriterion("goods_package =", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageNotEqualTo(String value) {
            addCriterion("goods_package <>", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageGreaterThan(String value) {
            addCriterion("goods_package >", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageGreaterThanOrEqualTo(String value) {
            addCriterion("goods_package >=", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageLessThan(String value) {
            addCriterion("goods_package <", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageLessThanOrEqualTo(String value) {
            addCriterion("goods_package <=", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageLike(String value) {
            addCriterion("goods_package like", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageNotLike(String value) {
            addCriterion("goods_package not like", value, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageIn(List<String> values) {
            addCriterion("goods_package in", values, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageNotIn(List<String> values) {
            addCriterion("goods_package not in", values, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageBetween(String value1, String value2) {
            addCriterion("goods_package between", value1, value2, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andGoodsPackageNotBetween(String value1, String value2) {
            addCriterion("goods_package not between", value1, value2, "goodsPackage");
            return (Criteria) this;
        }

        public Criteria andAfterBuyIsNull() {
            addCriterion("after_buy is null");
            return (Criteria) this;
        }

        public Criteria andAfterBuyIsNotNull() {
            addCriterion("after_buy is not null");
            return (Criteria) this;
        }

        public Criteria andAfterBuyEqualTo(String value) {
            addCriterion("after_buy =", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyNotEqualTo(String value) {
            addCriterion("after_buy <>", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyGreaterThan(String value) {
            addCriterion("after_buy >", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyGreaterThanOrEqualTo(String value) {
            addCriterion("after_buy >=", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyLessThan(String value) {
            addCriterion("after_buy <", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyLessThanOrEqualTo(String value) {
            addCriterion("after_buy <=", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyLike(String value) {
            addCriterion("after_buy like", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyNotLike(String value) {
            addCriterion("after_buy not like", value, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyIn(List<String> values) {
            addCriterion("after_buy in", values, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyNotIn(List<String> values) {
            addCriterion("after_buy not in", values, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyBetween(String value1, String value2) {
            addCriterion("after_buy between", value1, value2, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andAfterBuyNotBetween(String value1, String value2) {
            addCriterion("after_buy not between", value1, value2, "afterBuy");
            return (Criteria) this;
        }

        public Criteria andExplaionIsNull() {
            addCriterion("explaion is null");
            return (Criteria) this;
        }

        public Criteria andExplaionIsNotNull() {
            addCriterion("explaion is not null");
            return (Criteria) this;
        }

        public Criteria andExplaionEqualTo(String value) {
            addCriterion("explaion =", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionNotEqualTo(String value) {
            addCriterion("explaion <>", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionGreaterThan(String value) {
            addCriterion("explaion >", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionGreaterThanOrEqualTo(String value) {
            addCriterion("explaion >=", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionLessThan(String value) {
            addCriterion("explaion <", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionLessThanOrEqualTo(String value) {
            addCriterion("explaion <=", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionLike(String value) {
            addCriterion("explaion like", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionNotLike(String value) {
            addCriterion("explaion not like", value, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionIn(List<String> values) {
            addCriterion("explaion in", values, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionNotIn(List<String> values) {
            addCriterion("explaion not in", values, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionBetween(String value1, String value2) {
            addCriterion("explaion between", value1, value2, "explaion");
            return (Criteria) this;
        }

        public Criteria andExplaionNotBetween(String value1, String value2) {
            addCriterion("explaion not between", value1, value2, "explaion");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table after_goods
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table after_goods
     *
     * @mbg.generated
     */
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