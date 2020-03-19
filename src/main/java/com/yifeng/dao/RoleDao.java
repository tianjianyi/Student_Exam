package com.yifeng.dao;

import com.yifeng.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleDao {

    @Select("select * from role where id = #{roleId}")
    public List<Role> findRoleByUserId(Integer roleId);
}
