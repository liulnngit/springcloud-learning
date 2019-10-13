package com.study.jesse.hello.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserDao {

    @Select("select * from t_user where id= #{id}")
    Map<String,Object> get(@Param("id") String id);
}
