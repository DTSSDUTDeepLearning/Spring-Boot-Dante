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

    int add_user(@Param("user_id") int user_id, @Param("user_name") String user_name,
	@Param("user_phone") String user_phone, @Param("user_password") String user_password,
	@Param("user_wallet") double user_wallet, @Param("register_time") String register_time,
    @Param("login_time") String login_time);
    
    int delete_user_by_user_id(@Param("user_id") int user_id);
    int delete_user_by_user_name(@Param("user_name") String user_name);

    int update_user_name_by_user_id(@Param("user_id") int user_id, @Param("user_name") String user_name);
    int update_user_wallet_by_user_id(@Param("user_id") int user_id, @Param("user_wallet") double user_wallet);

    int select_max_user_id();
    double select_user_wallet_by_user_id(@Param("user_id") int usre_id);

    int update_user_name_by_user_id_Class(@Param("user") User user);

    List<String> select_user_name_list_by_user_id_list(@Param("user_id_list") List<Integer> user_id_list);
}