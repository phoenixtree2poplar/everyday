package com.yl.common.dao;

import com.yl.common.pojo.Solution;
import com.yl.common.pojo.SolutionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SolutionMapper {
    int countByExample(SolutionExample example);

    int deleteByExample(SolutionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Solution record);

    int insertSelective(Solution record);

    List<Solution> selectByExample(SolutionExample example);

    Solution selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Solution record, @Param("example") SolutionExample example);

    int updateByExample(@Param("record") Solution record, @Param("example") SolutionExample example);

    int updateByPrimaryKeySelective(Solution record);

    int updateByPrimaryKey(Solution record);
}