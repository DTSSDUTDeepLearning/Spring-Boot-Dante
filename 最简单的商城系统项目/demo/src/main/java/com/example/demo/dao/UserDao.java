package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {

    int register(@Param("user_id") int user_id, @Param("user_name") String user_name, @Param("user_password") String user_password, @Param("user_phone") String user_phone, @Param("time_stamp") String time_stamp);

    int update_user_phone_by_user_id(@Param("user_id") int user_id, @Param("user_phone") String user_phone);
    int update_user_password_by_user_id(@Param("user_id") int user_id, @Param("user_password") String user_password);
    int update_user_wallet_by_user_id(@Param("user_id") int user_id, @Param("user_wallet") double user_wallet);
    int update_user_login_time_by_user_id(@Param("user_id") int user_id, @Param("login_time") String login_time);

    int find_max_user_id();
    int select_user_id_by_user_name(@Param("user_name") String user_name);
    String select_user_name_by_user_id(@Param("user_id") int user_id); // 写完Controller层后，发现该方法未用上
    String select_user_phone_by_user_id(@Param("user_id") int user_id);
    String select_user_password_by_user_id(@Param("user_id") int user_id);
    double select_user_wallet_by_user_id(@Param("user_id") int user_id);
    int find_user_name_if_exists(@Param("user_name") String user_name);
    String select_user_password_by_user_name(@Param("user_name") String user_name);
}