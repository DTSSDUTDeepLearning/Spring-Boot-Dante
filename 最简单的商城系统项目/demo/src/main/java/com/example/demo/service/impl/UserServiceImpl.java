package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

	@Override
	public int register(int user_id, String user_name, String user_password, String user_phone, String time_stamp) {
		return userDao.register(user_id, user_name, user_password, user_phone, time_stamp);
	}

	@Override
	public int update_user_phone_by_user_id(int user_id, String user_phone) {
		return userDao.update_user_phone_by_user_id(user_id, user_phone);
	}

	@Override
	public int update_user_password_by_user_id(int user_id, String user_password) {
		return userDao.update_user_password_by_user_id(user_id, user_password);
	}

	@Override
	public int update_user_wallet_by_user_id(int user_id, double user_wallet) {
		return userDao.update_user_wallet_by_user_id(user_id, user_wallet);
	}

	@Override
	public int update_user_login_time_by_user_id(int user_id, String login_time) {
		return userDao.update_user_login_time_by_user_id(user_id, login_time);
	}

	@Override
	public int find_max_user_id() {
		return userDao.find_max_user_id();
	}

	@Override
	public int select_user_id_by_user_name(String user_name) {
		return userDao.select_user_id_by_user_name(user_name);
	}

	@Override
	public String select_user_name_by_user_id(int user_id) {
		return userDao.select_user_name_by_user_id(user_id);
	}

	@Override
	public String select_user_phone_by_user_id(int user_id) {
		return userDao.select_user_phone_by_user_id(user_id);
	}

	@Override
	public String select_user_password_by_user_id(int user_id) {
		return userDao.select_user_password_by_user_id(user_id);
	}

	@Override
	public double select_user_wallet_by_user_id(int user_id) {
		return userDao.select_user_wallet_by_user_id(user_id);
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
