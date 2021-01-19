package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@ResponseBody
@CrossOrigin
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show_user_all")
    public String show_user_all() {
        List<User> result = userService.show_user_all();
        int len = result.size();
        System.out.println("共查询到"+len+"条记录");
        for (int i = 0;i < len;i++) {
            User user = result.get(i);
            String user_name = user.get_user_name();
            String user_password = user.get_user_password();
            String register_time = user.get_register_time();
            String login_time = user.get_login_time();
            System.out.println("第"+(i+1)+"条记录的用户名为"+user_name+"，密码为"+user_password+"，注册时间为"+register_time+"，最后一次的登录时间为"+login_time);
        }
        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/show_user_by_user_name")
    public List<User> show_user_by_user_name(@RequestBody String user_name) {
        List<User> result = userService.show_user_by_user_name(user_name);
        int len = result.size();
        System.out.println("共查询到"+len+"条记录");
        for (int i = 0;i < len;i++) {
            User user = result.get(i);
            String user_password = user.get_user_password();
            String register_time = user.get_register_time();
            String login_time = user.get_login_time();
            System.out.println("第"+(i+1)+"条记录的用户名为"+user_name+"，密码为"+user_password+"，注册时间为"+register_time+"，最后一次的登录时间为"+login_time);
        }
        return result;
    }

    @RequestMapping(value = "/add_user")
    public String add_user(@RequestBody String user_str) {
        User user = JSON.parseObject(user_str, User.class);
        String user_name = user.get_user_name();
        String user_phone = user.get_user_phone();
        String user_password = user.get_user_password();
        double user_wallet = user.get_user_wallet();
        String register_time = user.get_register_time();
        String login_time = user.get_login_time();
        int user_id = userService.select_max_user_id()+1;
        int add = userService.add_user(user_id, user_name, user_phone, user_password, user_wallet, register_time, login_time);
        if (add == 1) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/delete_user_by_user_id")
    public String delete_user_by_user_id(@RequestBody String user_id_str) {
        int user_id = JSON.parseObject(user_id_str, Integer.class);
        int delete = userService.delete_user_by_user_id(user_id);
        if (delete != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/delete_user_by_user_name")
    public String delete_user_by_user_name(@RequestBody String user_name) {
        int delete = userService.delete_user_by_user_name(user_name);
        if (delete != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/update_user_name_by_user_id")
    public String update_user_name_by_user_id(@RequestBody String user_str) {
        User user = JSON.parseObject(user_str, User.class);
        int user_id = user.get_user_id();
	    String new_user_password = user.get_user_password();
        int update = userService.update_user_name_by_user_id(user_id, new_user_password);
        if (update != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/update_user_wallet_by_user_id")
    public String update_user_wallet_by_user_id(@RequestBody String user_str) {
        User user = JSON.parseObject(user_str, User.class);
        int user_id = user.get_user_id();
        double user_wallet = user.get_user_wallet();
        int update = userService.update_user_wallet_by_user_id(user_id, user_wallet);
        if (update != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/select_user_wallet_by_user_id")
    public double select_user_wallet_by_user_id(@RequestBody String user_id_str) {
        int user_id = JSON.parseObject(user_id_str, Integer.class);
        double user_wallet = userService.select_user_wallet_by_user_id(user_id);
        return user_wallet;
    }

    @RequestMapping(value = "/update_user_name_by_user_id_Class")
    public String update_user_name_by_user_id_Class(@RequestBody String user_str) {
        User user = JSON.parseObject(user_str, User.class);
        int update = userService.update_user_name_by_user_id_Class(user);
        if (update != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/select_user_name_list_by_user_id_list")
    public List<String> select_user_name_list_by_user_id_list() {
        List<Integer> user_id_list = new ArrayList<>();
        user_id_list.add(1);
        user_id_list.add(2);
        user_id_list.add(3);
        List<String> user_name_list = userService.select_user_name_list_by_user_id_list(user_id_list);
        return user_name_list;
    }

    @RequestMapping(value = "/login")
    public String login(@RequestBody String user_str) {
	    User user = JSON.parseObject(user_str, User.class);
	    String user_name = user.get_user_name();
	    String user_password = user.get_user_password();
	    if (userService.find_user_name_if_exists(user_name) == 0) {
	    	return "该用户名不存在！";
	    }
	    if (!userService.select_user_password_by_user_name(user_name).equals(user_password)) {
	    	return "账号密码错误！";
	    }
	    return "登录成功！用户名为："+user_name+"，用户密码为："+user_password;
}

}
