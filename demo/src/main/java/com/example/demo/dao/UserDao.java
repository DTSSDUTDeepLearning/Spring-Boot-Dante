package com.example.demo.dao;

import com.example.demo.entity.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
@Mapper
public interface UserDao {

    List<User> show_user_all();

    List<User> show_user_by_user_name(@Param("user_name") String user_name);
}