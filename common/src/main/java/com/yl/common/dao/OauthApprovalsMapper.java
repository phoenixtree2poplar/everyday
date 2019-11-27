package com.yl.common.dao;

import com.yl.common.pojo.OauthApprovals;
import com.yl.common.pojo.OauthApprovalsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OauthApprovalsMapper {
    int countByExample(OauthApprovalsExample example);

    int deleteByExample(OauthApprovalsExample example);

    int insert(OauthApprovals record);

    int insertSelective(OauthApprovals record);

    List<OauthApprovals> selectByExample(OauthApprovalsExample example);

    int updateByExampleSelective(@Param("record") OauthApprovals record, @Param("example") OauthApprovalsExample example);

    int updateByExample(@Param("record") OauthApprovals record, @Param("example") OauthApprovalsExample example);
}