package com.yl.common.dao;

import com.yl.common.pojo.Role;
import com.yl.common.pojo.UserRole;
import com.yl.common.pojo.UserRoleExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserRoleMapper {
    int countByExample(UserRoleExample example);

    int deleteByExample(UserRoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleExample example);

    UserRole selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    /**
     * 通过用户id获取角色信息
     * @param userId
     * @return
     */
    @Select("SELECT r.id,r.name FROM user_role ur\r\n" +
            "LEFT JOIN role r ON ur.`role_id`=r.`id`\r\n" +
            "WHERE ur.id=#{userId}")
    public List<Role> getRolesByUserId(String userId);

}