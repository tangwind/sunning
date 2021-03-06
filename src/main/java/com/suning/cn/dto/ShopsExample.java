package com.suning.cn.dto;

import java.util.ArrayList;
import java.util.List;

public class ShopsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shops
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shops
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shops
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public ShopsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
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
     * This method corresponds to the database table shops
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
     * This method corresponds to the database table shops
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shops
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
     * This class corresponds to the database table shops
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

        public Criteria andShopsIdIsNull() {
            addCriterion("shops_id is null");
            return (Criteria) this;
        }

        public Criteria andShopsIdIsNotNull() {
            addCriterion("shops_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopsIdEqualTo(String value) {
            addCriterion("shops_id =", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotEqualTo(String value) {
            addCriterion("shops_id <>", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdGreaterThan(String value) {
            addCriterion("shops_id >", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdGreaterThanOrEqualTo(String value) {
            addCriterion("shops_id >=", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdLessThan(String value) {
            addCriterion("shops_id <", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdLessThanOrEqualTo(String value) {
            addCriterion("shops_id <=", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdLike(String value) {
            addCriterion("shops_id like", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotLike(String value) {
            addCriterion("shops_id not like", value, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdIn(List<String> values) {
            addCriterion("shops_id in", values, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotIn(List<String> values) {
            addCriterion("shops_id not in", values, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdBetween(String value1, String value2) {
            addCriterion("shops_id between", value1, value2, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsIdNotBetween(String value1, String value2) {
            addCriterion("shops_id not between", value1, value2, "shopsId");
            return (Criteria) this;
        }

        public Criteria andShopsNameIsNull() {
            addCriterion("shops_name is null");
            return (Criteria) this;
        }

        public Criteria andShopsNameIsNotNull() {
            addCriterion("shops_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopsNameEqualTo(String value) {
            addCriterion("shops_name =", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotEqualTo(String value) {
            addCriterion("shops_name <>", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameGreaterThan(String value) {
            addCriterion("shops_name >", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameGreaterThanOrEqualTo(String value) {
            addCriterion("shops_name >=", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameLessThan(String value) {
            addCriterion("shops_name <", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameLessThanOrEqualTo(String value) {
            addCriterion("shops_name <=", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameLike(String value) {
            addCriterion("shops_name like", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotLike(String value) {
            addCriterion("shops_name not like", value, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameIn(List<String> values) {
            addCriterion("shops_name in", values, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotIn(List<String> values) {
            addCriterion("shops_name not in", values, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameBetween(String value1, String value2) {
            addCriterion("shops_name between", value1, value2, "shopsName");
            return (Criteria) this;
        }

        public Criteria andShopsNameNotBetween(String value1, String value2) {
            addCriterion("shops_name not between", value1, value2, "shopsName");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shops
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
     * This class corresponds to the database table shops
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