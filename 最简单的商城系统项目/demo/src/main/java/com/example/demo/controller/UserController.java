package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.GetTime;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderGoods;
import com.example.demo.entity.Order_get;
import com.example.demo.entity.User;
import com.example.demo.entity.User_phone;
import com.example.demo.entity.User_price;
import com.example.demo.entity.user_password;
import com.example.demo.service.OrderGoodsService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
@ResponseBody
public class UserController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderGoodsService ordergoodsService;

    @RequestMapping("register")
    public String register(@RequestBody String user_str) {
        User user = JSON.parseObject(user_str, User.class);
        String user_name = user.get_user_name();
        String user_phone = user.get_user_phone();
        String user_password = user.get_user_password();
        if (userService.find_user_name_if_exists(user_name) == 1) {
            return "该用户名已经存在";
        }
        int user_id = userService.find_max_user_id()+1;
        String time_stamp = GetTime.NowTime();
        userService.register(user_id, user_name, user_password, user_phone, time_stamp);
        return "success";
    }

    @RequestMapping("login")
    public String login(@RequestBody String user_str) {
        User user = JSON.parseObject(user_str, User.class);
        String user_name = user.get_user_name();
        String user_password = user.get_user_password();
        if (userService.find_user_name_if_exists(user_name) == 0) {
            return "该用户名不存在";
        }
        if (!userService.select_user_password_by_user_name(user_name).equals(user_password)) {
            return "密码错误";
        }
        int user_id = userService.select_user_id_by_user_name(user_name);
        String login_time = GetTime.NowTime();
        userService.update_user_login_time_by_user_id(user_id, login_time);
        return "success";
    }

    @RequestMapping("update_user_phone")
    public String update_user_phone(@RequestBody String user_str) {
        User_phone user = JSON.parseObject(user_str, User_phone.class);
        int user_id = user.get_user_id();
        String user_phone = user.get_user_phone();
        if (userService.select_user_phone_by_user_id(user_id).equals(user_phone)) {
            return "新手机号与旧手机号相同";
        }
        userService.update_user_phone_by_user_id(user_id, user_phone);
        return "success";
    }

    @RequestMapping("update_user_password")
    public String update_user_password(@RequestBody String user_str) {
        // 省略手机号验证的部分
        user_password user = JSON.parseObject(user_str, user_password.class);
        int user_id = user.get_user_id();
        String old_user_password = user.get_old_user_password();
        String new_user_password = user.get_user_password();
        if (!userService.select_user_password_by_user_id(user_id).equals(old_user_password)) {
            return "原密码错误";
        }
        if (old_user_password.equals(new_user_password)) {
            return "原密码与新密码相同";
        }
        userService.update_user_password_by_user_id(user_id, new_user_password);
        return "success";
    }

    @RequestMapping("forget_password")
    public String forget_password(@RequestBody String user_str) {
        // 省略手机号验证的部分
        user_password user = JSON.parseObject(user_str, user_password.class);
        int user_id = user.get_user_id();
        String user_password = user.get_user_password();
        if (userService.select_user_password_by_user_id(user_id).equals(user_password)) {
            return "原密码与新密码相同";
        }
        userService.update_user_password_by_user_id(user_id, user_password);
        return "success";
    }

    @RequestMapping("charge")
    public String charge(@RequestBody String user_price_str) {
        User_price user_price = JSON.parseObject(user_price_str, User_price.class);
        int user_id = user_price.get_user_id();
        double price = user_price.get_price();
        userService.update_user_wallet_by_user_id(user_id, userService.select_user_wallet_by_user_id(user_id)+price);
        return "success";
    }

    @RequestMapping("look_all_order_by_user_id")
    public String look_all_order_by_user_id(@RequestBody String user_id_str) {
        int user_id = JSON.parseObject(user_id_str, Integer.class);
        List<Integer> order_id_list = orderService.select_order_id_list_by_user_id(user_id);
        int len1 = order_id_list.size();
        List<Order_get> result_list = new LinkedList<>(); // 此处用LinkedList应该比ArrayList节省时间
        for (int i = 0;i < len1;i++) {
            int order_id = order_id_list.get(i);
            Order order = orderService.select_order_by_order_id(order_id);
            String order_state = order.get_order_state();
            double order_price = order.get_order_price();
            String time_stamp = order.get_time_stamp();

            List<OrderGoods> order_goods_list = ordergoodsService.select_order_goods(order_id);
            int len2 = order_goods_list.size();
            List<Integer> goods_id_list = new LinkedList<>(); // 此处用LinkedList应该比ArrayList节省时间
            List<Integer> goods_number_list = new LinkedList<>();
            for (int j = 0;j < len2;j++) {
                OrderGoods order_goods = order_goods_list.get(j);
                int goods_id = order_goods.get_goods_id();
                goods_id_list.add(goods_id);
                int goods_number = order_goods.get_goods_number();
                goods_number_list.add(goods_number);
            }
            Order_get result = new Order_get(order_id, user_id, order_state, order_price, time_stamp, goods_id_list, goods_number_list);
            result_list.add(result);
        }
        return JSON.toJSONString(result_list);
    }

}
