package com.yifeng.dao;


import com.yifeng.domain.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Select("select * from user where userId=#{username}")
    UserInfo findByUsername(String username);
}
