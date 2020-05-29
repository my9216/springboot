package com.model;

import java.util.ArrayList;
import java.util.List;

public class YueTest2Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public YueTest2Example() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
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
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTest2NameIsNull() {
            addCriterion("test2_name is null");
            return (Criteria) this;
        }

        public Criteria andTest2NameIsNotNull() {
            addCriterion("test2_name is not null");
            return (Criteria) this;
        }

        public Criteria andTest2NameEqualTo(String value) {
            addCriterion("test2_name =", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameNotEqualTo(String value) {
            addCriterion("test2_name <>", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameGreaterThan(String value) {
            addCriterion("test2_name >", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameGreaterThanOrEqualTo(String value) {
            addCriterion("test2_name >=", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameLessThan(String value) {
            addCriterion("test2_name <", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameLessThanOrEqualTo(String value) {
            addCriterion("test2_name <=", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameLike(String value) {
            addCriterion("test2_name like", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameNotLike(String value) {
            addCriterion("test2_name not like", value, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameIn(List<String> values) {
            addCriterion("test2_name in", values, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameNotIn(List<String> values) {
            addCriterion("test2_name not in", values, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameBetween(String value1, String value2) {
            addCriterion("test2_name between", value1, value2, "test2Name");
            return (Criteria) this;
        }

        public Criteria andTest2NameNotBetween(String value1, String value2) {
            addCriterion("test2_name not between", value1, value2, "test2Name");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andTest1IdIsNull() {
            addCriterion("test1_id is null");
            return (Criteria) this;
        }

        public Criteria andTest1IdIsNotNull() {
            addCriterion("test1_id is not null");
            return (Criteria) this;
        }

        public Criteria andTest1IdEqualTo(Integer value) {
            addCriterion("test1_id =", value, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdNotEqualTo(Integer value) {
            addCriterion("test1_id <>", value, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdGreaterThan(Integer value) {
            addCriterion("test1_id >", value, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdGreaterThanOrEqualTo(Integer value) {
            addCriterion("test1_id >=", value, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdLessThan(Integer value) {
            addCriterion("test1_id <", value, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdLessThanOrEqualTo(Integer value) {
            addCriterion("test1_id <=", value, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdIn(List<Integer> values) {
            addCriterion("test1_id in", values, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdNotIn(List<Integer> values) {
            addCriterion("test1_id not in", values, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdBetween(Integer value1, Integer value2) {
            addCriterion("test1_id between", value1, value2, "test1Id");
            return (Criteria) this;
        }

        public Criteria andTest1IdNotBetween(Integer value1, Integer value2) {
            addCriterion("test1_id not between", value1, value2, "test1Id");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yue_test2
     *
     * @mbg.generated do_not_delete_during_merge Sat Feb 29 01:02:45 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table yue_test2
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    public static class Criterion {
        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

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