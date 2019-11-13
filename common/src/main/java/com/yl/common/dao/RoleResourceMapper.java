package com.yl.common.dao;

import com.yl.common.pojo.Role;
import com.yl.common.pojo.RoleResource;
import com.yl.common.pojo.RoleResourceExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleResourceMapper {
    int countByExample(RoleResourceExample example);

    int deleteByExample(RoleResourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(RoleResource record);

    int insertSelective(RoleResource record);

    List<RoleResource> selectByExample(RoleResourceExample example);

    RoleResource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByExample(@Param("record") RoleResource record, @Param("example") RoleResourceExample example);

    int updateByPrimaryKeySelective(RoleResource record);

    int updateByPrimaryKey(RoleResource record);

    /**
     * 通过资源的id获取所有的角色
     * 		先通过role_resource中间表的resource_id查出对应的role_id
     * 		再通过role表的id查出对应的所有信息
     * @return
     */
    @Select("SELECT r.* \r\n" +
            "FROM role_resource rr \r\n" +
            "LEFT JOIN role r ON rr.role_id=r.id\r\n" +
            "WHERE rr.resource_id=#{resourceId}")
    List<Role> findRolesByResourceUrl(String resourceId);
}