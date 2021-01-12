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

}
