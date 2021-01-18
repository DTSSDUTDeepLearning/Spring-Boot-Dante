package com.example.demo.controller;

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

}
