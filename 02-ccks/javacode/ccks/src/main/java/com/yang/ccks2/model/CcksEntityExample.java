package com.yang.ccks2.model;

import java.util.ArrayList;
import java.util.List;

public class CcksEntityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public CcksEntityExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
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
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andEntityIdIsNull() {
            addCriterion("entity_id is null");
            return (Criteria) this;
        }

        public Criteria andEntityIdIsNotNull() {
            addCriterion("entity_id is not null");
            return (Criteria) this;
        }

        public Criteria andEntityIdEqualTo(Long value) {
            addCriterion("entity_id =", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotEqualTo(Long value) {
            addCriterion("entity_id <>", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdGreaterThan(Long value) {
            addCriterion("entity_id >", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("entity_id >=", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLessThan(Long value) {
            addCriterion("entity_id <", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdLessThanOrEqualTo(Long value) {
            addCriterion("entity_id <=", value, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdIn(List<Long> values) {
            addCriterion("entity_id in", values, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotIn(List<Long> values) {
            addCriterion("entity_id not in", values, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdBetween(Long value1, Long value2) {
            addCriterion("entity_id between", value1, value2, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityIdNotBetween(Long value1, Long value2) {
            addCriterion("entity_id not between", value1, value2, "entityId");
            return (Criteria) this;
        }

        public Criteria andEntityContentIsNull() {
            addCriterion("entity_content is null");
            return (Criteria) this;
        }

        public Criteria andEntityContentIsNotNull() {
            addCriterion("entity_content is not null");
            return (Criteria) this;
        }

        public Criteria andEntityContentEqualTo(String value) {
            addCriterion("entity_content =", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentNotEqualTo(String value) {
            addCriterion("entity_content <>", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentGreaterThan(String value) {
            addCriterion("entity_content >", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentGreaterThanOrEqualTo(String value) {
            addCriterion("entity_content >=", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentLessThan(String value) {
            addCriterion("entity_content <", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentLessThanOrEqualTo(String value) {
            addCriterion("entity_content <=", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentLike(String value) {
            addCriterion("entity_content like", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentNotLike(String value) {
            addCriterion("entity_content not like", value, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentIn(List<String> values) {
            addCriterion("entity_content in", values, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentNotIn(List<String> values) {
            addCriterion("entity_content not in", values, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentBetween(String value1, String value2) {
            addCriterion("entity_content between", value1, value2, "entityContent");
            return (Criteria) this;
        }

        public Criteria andEntityContentNotBetween(String value1, String value2) {
            addCriterion("entity_content not between", value1, value2, "entityContent");
            return (Criteria) this;
        }

        public Criteria andStartIndexIsNull() {
            addCriterion("start_index is null");
            return (Criteria) this;
        }

        public Criteria andStartIndexIsNotNull() {
            addCriterion("start_index is not null");
            return (Criteria) this;
        }

        public Criteria andStartIndexEqualTo(Integer value) {
            addCriterion("start_index =", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotEqualTo(Integer value) {
            addCriterion("start_index <>", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexGreaterThan(Integer value) {
            addCriterion("start_index >", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_index >=", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexLessThan(Integer value) {
            addCriterion("start_index <", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexLessThanOrEqualTo(Integer value) {
            addCriterion("start_index <=", value, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexIn(List<Integer> values) {
            addCriterion("start_index in", values, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotIn(List<Integer> values) {
            addCriterion("start_index not in", values, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexBetween(Integer value1, Integer value2) {
            addCriterion("start_index between", value1, value2, "startIndex");
            return (Criteria) this;
        }

        public Criteria andStartIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("start_index not between", value1, value2, "startIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexIsNull() {
            addCriterion("end_index is null");
            return (Criteria) this;
        }

        public Criteria andEndIndexIsNotNull() {
            addCriterion("end_index is not null");
            return (Criteria) this;
        }

        public Criteria andEndIndexEqualTo(Integer value) {
            addCriterion("end_index =", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotEqualTo(Integer value) {
            addCriterion("end_index <>", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexGreaterThan(Integer value) {
            addCriterion("end_index >", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_index >=", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLessThan(Integer value) {
            addCriterion("end_index <", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexLessThanOrEqualTo(Integer value) {
            addCriterion("end_index <=", value, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexIn(List<Integer> values) {
            addCriterion("end_index in", values, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotIn(List<Integer> values) {
            addCriterion("end_index not in", values, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexBetween(Integer value1, Integer value2) {
            addCriterion("end_index between", value1, value2, "endIndex");
            return (Criteria) this;
        }

        public Criteria andEndIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("end_index not between", value1, value2, "endIndex");
            return (Criteria) this;
        }

        public Criteria andTextIdIsNull() {
            addCriterion("text_id is null");
            return (Criteria) this;
        }

        public Criteria andTextIdIsNotNull() {
            addCriterion("text_id is not null");
            return (Criteria) this;
        }

        public Criteria andTextIdEqualTo(Long value) {
            addCriterion("text_id =", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotEqualTo(Long value) {
            addCriterion("text_id <>", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdGreaterThan(Long value) {
            addCriterion("text_id >", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdGreaterThanOrEqualTo(Long value) {
            addCriterion("text_id >=", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdLessThan(Long value) {
            addCriterion("text_id <", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdLessThanOrEqualTo(Long value) {
            addCriterion("text_id <=", value, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdIn(List<Long> values) {
            addCriterion("text_id in", values, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotIn(List<Long> values) {
            addCriterion("text_id not in", values, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdBetween(Long value1, Long value2) {
            addCriterion("text_id between", value1, value2, "textId");
            return (Criteria) this;
        }

        public Criteria andTextIdNotBetween(Long value1, Long value2) {
            addCriterion("text_id not between", value1, value2, "textId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNull() {
            addCriterion("commit_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIsNotNull() {
            addCriterion("commit_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdEqualTo(Long value) {
            addCriterion("commit_user_id =", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotEqualTo(Long value) {
            addCriterion("commit_user_id <>", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThan(Long value) {
            addCriterion("commit_user_id >", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("commit_user_id >=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThan(Long value) {
            addCriterion("commit_user_id <", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdLessThanOrEqualTo(Long value) {
            addCriterion("commit_user_id <=", value, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdIn(List<Long> values) {
            addCriterion("commit_user_id in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotIn(List<Long> values) {
            addCriterion("commit_user_id not in", values, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdBetween(Long value1, Long value2) {
            addCriterion("commit_user_id between", value1, value2, "commitUserId");
            return (Criteria) this;
        }

        public Criteria andCommitUserIdNotBetween(Long value1, Long value2) {
            addCriterion("commit_user_id not between", value1, value2, "commitUserId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ccks_entity
     *
     * @mbg.generated do_not_delete_during_merge Sun Dec 27 14:50:31 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ccks_entity
     *
     * @mbg.generated Sun Dec 27 14:50:31 CST 2020
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