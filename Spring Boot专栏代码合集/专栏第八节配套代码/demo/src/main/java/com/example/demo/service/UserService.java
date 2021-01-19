package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> show_user_all();

    List<User> show_user_by_user_name(String user_name);

    int add_user(int user_id, String user_name, String user_phone, String user_password, double user_wallet, String register_time, String login_time);

    int delete_user_by_user_id(int user_id);
    int delete_user_by_user_name(String user_name);

    int update_user_name_by_user_id(int user_id, String user_name);
    int update_user_wallet_by_user_id(int user_id, double user_wallet);

    int select_max_user_id();
    double select_user_wallet_by_user_id(int usre_id);

    int update_user_name_by_user_id_Class(User user);

    List<String> select_user_name_list_by_user_id_list(List<Integer> user_id_list);

    int find_user_name_if_exists(String user_name);
    String select_user_password_by_user_name(String user_name);
}