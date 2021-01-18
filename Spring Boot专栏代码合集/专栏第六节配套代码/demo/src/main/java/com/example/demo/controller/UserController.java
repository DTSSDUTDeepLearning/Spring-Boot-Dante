package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/show_user_all", method = {RequestMethod.GET})
    public List<User> show_user_all() {
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
        return result;
    }

    @RequestMapping(value = "/show_user_by_user_name", method = {RequestMethod.GET})
    public List<User> show_user_by_user_name(@RequestParam("user_name") String user_name) {
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

    @RequestMapping(value = "/add_user", method = {RequestMethod.GET})
    public String add_user(@RequestParam("user_name") String user_name, @RequestParam("user_phone") String user_phone, @RequestParam("user_password") String user_password, 
    @RequestParam("user_wallet") double user_wallet, @RequestParam("register_time") String register_time, @RequestParam("login_time") String login_time) {
        int user_id = userService.select_max_user_id()+1;
        int add = userService.add_user(user_id, user_name, user_phone, user_password, user_wallet, register_time, login_time);
        if (add == 1) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/delete_user_by_user_id", method = {RequestMethod.GET})
    public String delete_user_by_user_id(@RequestParam("user_id") int user_id) {
        int delete = userService.delete_user_by_user_id(user_id);
        if (delete != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/delete_user_by_user_name", method = {RequestMethod.GET})
    public String delete_user_by_user_name(@RequestParam("user_name") String user_name) {
        int delete = userService.delete_user_by_user_name(user_name);
        if (delete != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/update_user_name_by_user_id", method = {RequestMethod.GET})
    public String update_user_name_by_user_id(@RequestParam("user_id") int user_id, @RequestParam("user_name") String user_name) {
        int update = userService.update_user_name_by_user_id(user_id, user_name);
        if (update != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/update_user_wallet_by_user_id", method = {RequestMethod.GET})
    public String update_user_wallet_by_user_id(@RequestParam("user_id") int user_id, @RequestParam("user_wallet") double user_wallet) {
        int update = userService.update_user_wallet_by_user_id(user_id, user_wallet);
        if (update != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/select_user_wallet_by_user_id", method = {RequestMethod.GET})
    public double select_user_wallet_by_user_id(@RequestParam("user_id") int user_id) {
        double user_wallet = userService.select_user_wallet_by_user_id(user_id);
        return user_wallet;
    }

    @RequestMapping(value = "/update_user_name_by_user_id_Class", method = {RequestMethod.GET})
    public String update_user_name_by_user_id_Class(@RequestParam("user_name") String user_name, @RequestParam("user_password") String user_password) {
        User user = new User(user_name, user_password);
        int update = userService.update_user_name_by_user_id_Class(user);
        if (update != 0) {
            return "success";
        }
        else {
            return "fail";
        }
    }

    @RequestMapping(value = "/select_user_name_list_by_user_id_list", method = {RequestMethod.GET})
    public List<String> select_user_name_list_by_user_id_list() {
        List<Integer> user_id_list = new ArrayList<>();
        user_id_list.add(1);
        user_id_list.add(2);
        user_id_list.add(3);
        List<String> user_name_list = userService.select_user_name_list_by_user_id_list(user_id_list);
        return user_name_list;
    }

}
