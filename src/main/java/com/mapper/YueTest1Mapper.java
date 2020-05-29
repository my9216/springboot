package com.mapper;

import com.model.BaseYueTest;
import com.model.YueTest1;
import com.model.YueTest1Example;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YueTest1Mapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    long countByExample(YueTest1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int deleteByExample(YueTest1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int insert(YueTest1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int insertSelective(YueTest1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    List<YueTest1> selectByExample(YueTest1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    YueTest1 selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") YueTest1 record, @Param("example") YueTest1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int updateByExample(@Param("record") YueTest1 record, @Param("example") YueTest1Example example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int updateByPrimaryKeySelective(YueTest1 record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table yue_test1
     *
     * @mbg.generated Sat Feb 29 01:02:45 CST 2020
     */
    int updateByPrimaryKey(YueTest1 record);

    BaseYueTest getBaseYueInfo(int i);
}