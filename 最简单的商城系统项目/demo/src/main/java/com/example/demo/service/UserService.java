package com.example.demo.service;

public interface UserService {

    int register(int user_id, String user_name, String user_password, String user_phone, String time_stamp);

    int update_user_phone_by_user_id(int user_id, String user_phone);
    int update_user_password_by_user_id(int user_id, String user_password);
    int update_user_wallet_by_user_id(int user_id, double user_wallet);
    int update_user_login_time_by_user_id(int user_id, String login_time);

    int find_max_user_id();
    int select_user_id_by_user_name(String user_name);
    String select_user_name_by_user_id(int user_id);
    String select_user_phone_by_user_id(int user_id);
    String select_user_password_by_user_id(int user_id);
    double select_user_wallet_by_user_id(int user_id);
    int find_user_name_if_exists(String user_name);
    String select_user_password_by_user_name(String user_name);
}