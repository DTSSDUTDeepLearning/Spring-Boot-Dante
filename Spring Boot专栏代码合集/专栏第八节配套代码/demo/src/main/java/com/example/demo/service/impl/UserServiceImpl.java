package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> show_user_all() {
        return userDao.show_user_all();
    }

    @Override
    public List<User> show_user_by_user_name(String user_name) {
        return userDao.show_user_by_user_name(user_name);
    }

    @Override
    public int add_user(int user_id, String user_name, String user_phone, String user_password, double user_wallet,
            String register_time, String login_time) {
        return userDao.add_user(user_id, user_name, user_phone, user_password, user_wallet, register_time, login_time);
    }

    @Override
    public int delete_user_by_user_id(int user_id) {
        return userDao.delete_user_by_user_id(user_id);
    }

    @Override
    public int delete_user_by_user_name(String user_name) {
        return userDao.delete_user_by_user_name(user_name);
    }

    @Override
    public int update_user_name_by_user_id(int user_id, String user_name) {
        return userDao.update_user_name_by_user_id(user_id, user_name);
    }

    @Override
    public int update_user_wallet_by_user_id(int user_id, double user_wallet) {
        return userDao.update_user_wallet_by_user_id(user_id, user_wallet);
    }

    @Override
    public int select_max_user_id() {
        return userDao.select_max_user_id();
    }

    @Override
    public double select_user_wallet_by_user_id(int usre_id) {
        return userDao.select_user_wallet_by_user_id(usre_id);
    }

    @Override
    public int update_user_name_by_user_id_Class(User user) {
        return userDao.update_user_name_by_user_id_Class(user);
    }

    @Override
    public List<String> select_user_name_list_by_user_id_list(List<Integer> user_id_list) {
        return userDao.select_user_name_list_by_user_id_list(user_id_list);
    }

    @Override
    public int find_user_name_if_exists(String user_name) {
        return userDao.find_user_name_if_exists(user_name);
    }

    @Override
    public String select_user_password_by_user_name(String user_name) {
        return userDao.select_user_password_by_user_name(user_name);
    }

}
