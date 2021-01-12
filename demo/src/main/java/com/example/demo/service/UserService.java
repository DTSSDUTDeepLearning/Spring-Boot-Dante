package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> show_user_all();

    List<User> show_user_by_user_name(String user_name);
}