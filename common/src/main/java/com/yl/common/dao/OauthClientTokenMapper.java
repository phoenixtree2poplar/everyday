package com.yl.common.dao;

import com.yl.common.pojo.OauthClientToken;
import com.yl.common.pojo.OauthClientTokenExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OauthClientTokenMapper {
    int countByExample(OauthClientTokenExample example);

    int deleteByExample(OauthClientTokenExample example);

    int deleteByPrimaryKey(String authenticationId);

    int insert(OauthClientToken record);

    int insertSelective(OauthClientToken record);

    List<OauthClientToken> selectByExampleWithBLOBs(OauthClientTokenExample example);

    List<OauthClientToken> selectByExample(OauthClientTokenExample example);

    OauthClientToken selectByPrimaryKey(String authenticationId);

    int updateByExampleSelective(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenExample example);

    int updateByExample(@Param("record") OauthClientToken record, @Param("example") OauthClientTokenExample example);

    int updateByPrimaryKeySelective(OauthClientToken record);

    int updateByPrimaryKeyWithBLOBs(OauthClientToken record);

    int updateByPrimaryKey(OauthClientToken record);
}