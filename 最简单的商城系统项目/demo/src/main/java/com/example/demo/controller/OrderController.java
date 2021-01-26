package com.example.demo.controller;

import java.util.LinkedList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.GetTime;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderGoods;
import com.example.demo.entity.Order_get;
import com.example.demo.service.GoodsService;
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
@RequestMapping("/order")
@CrossOrigin
@ResponseBody
public class OrderController {
    
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrderGoodsService ordergoodsService;

    // 创建一个待付款订单，该种订单有两种操作————更改状态、取消订单
    @RequestMapping("offer_order")
    public String offer_order(@RequestBody String order_str) {
        Order_get order_get = JSON.parseObject(order_str, Order_get.class);
        int user_id = order_get.get_user_id();
        List<Integer> goods_id_list = order_get.get_goods_id_list();
        List<Integer> goods_number_list = order_get.get_goods_number_list();
        int len = goods_id_list.size();
        double order_price = 0.0;
        for (int i = 0;i < len;i++) {
            int goods_id = goods_id_list.get(i);
            double goods_price = goodsService.select_goods_price_by_goods_id(goods_id);
            int goods_number = goods_number_list.get(i);
            order_price += goods_price*goods_number;
        }
        int order_id = orderService.find_max_order_id();
        String time_stamp = GetTime.NowTime();
        // 因为order_goods的属性order_id是连接表order_的外键，所以必须先有order_，再有order_goods
        orderService.insert_order_without_pay(order_id, user_id, order_price, time_stamp);
        for (int i = 0;i < len;i++) {
            int goods_id = goods_id_list.get(i);
            int goods_number = goods_number_list.get(i);
            ordergoodsService.insert_order_goods(order_id, goods_id, goods_number);
        }
        return "success";
    }

    @RequestMapping("update_order_pay")
    public String update_order_pay(@RequestBody String order_id_str) {
        int order_id = JSON.parseObject(order_id_str, Integer.class);
        Order order = orderService.select_order_by_order_id(order_id);
        int user_id = order.get_user_id();
        double order_price = order.get_order_price();
        double user_wallet = userService.select_user_wallet_by_user_id(user_id);
        if (user_wallet < order_price) {
            return "余额不足，请先充值";
        }
        userService.update_user_wallet_by_user_id(user_id, user_wallet-order_price);
        orderService.update_order_pay(order_id);
        return "success";
    }

    @RequestMapping("cancel_order")
    public String cancel_order(@RequestBody String order_id_str) {
        int order_id = JSON.parseObject(order_id_str, Integer.class);
        orderService.delete_order(order_id);
        return "success";
    }

    // 创建一个待收货订单，该种订单有一种操作————更改状态
    @RequestMapping("pay_order")
    public String pay_order(@RequestBody String order_str) {
        Order_get order_get = JSON.parseObject(order_str, Order_get.class);
        int user_id = order_get.get_user_id();
        List<Integer> goods_id_list = order_get.get_goods_id_list();
        List<Integer> goods_number_list = order_get.get_goods_number_list();
        int len = goods_id_list.size();
        double order_price = 0.0;
        for (int i = 0;i < len;i++) {
            int goods_id = goods_id_list.get(i);
            double goods_price = goodsService.select_goods_price_by_goods_id(goods_id);
            int goods_number = goods_number_list.get(i);
            order_price += goods_price*goods_number;
        }
        double user_wallet = userService.select_user_wallet_by_user_id(user_id);
        int order_id = orderService.find_max_order_id();
        String time_stamp = GetTime.NowTime();
        if (user_wallet < order_price) {
            // 创建待付款订单
            // 因为order_goods的属性order_id是连接表order_的外键，所以必须先有order_，再有order_goods
            orderService.insert_order_without_pay(order_id, user_id, order_price, time_stamp);
            for (int i = 0;i < len;i++) {
                int goods_id = goods_id_list.get(i);
                int goods_number = goods_number_list.get(i);
                ordergoodsService.insert_order_goods(order_id, goods_id, goods_number);
            }
            return "余额不足，已创建待付款订单，请先充值后支付";
        }
        // 因为order_goods的属性order_id是连接表order_的外键，所以必须先有order_，再有order_goods
        orderService.insert_order_with_pay(order_id, user_id, order_price, time_stamp);
        for (int i = 0;i < len;i++) {
            int goods_id = goods_id_list.get(i);
            int goods_number = goods_number_list.get(i);
            ordergoodsService.insert_order_goods(order_id, goods_id, goods_number);
        }
        return "success";
    }

    @RequestMapping("update_order_receive")
    public String update_order_receive(@RequestBody String order_id_str) {
        int order_id = JSON.parseObject(order_id_str, Integer.class);
        orderService.update_order_receive(order_id);
        return "success";
    }

    // 对于已完成订单，只有一种操作————删除订单
    @RequestMapping("delete_order")
    public String delete_order(@RequestBody String order_id_str) {
        int order_id = JSON.parseObject(order_id_str, Integer.class);
        ordergoodsService.delete_order_goods(order_id);
        orderService.delete_order(order_id);
        return "success";
    }

    // 查看订单具体内容，这与订单有关，也与订单-商品类有关
    @RequestMapping("look_order_detail")
    public String look_order_detail(@RequestBody String order_id_str) {
        int order_id = JSON.parseObject(order_id_str, Integer.class);
        Order order = orderService.select_order_by_order_id(order_id);
        int user_id = order.get_user_id();
        String order_state = order.get_order_state();
        double order_price = order.get_order_price();
        String time_stamp = order.get_time_stamp();

        List<OrderGoods> order_goods_list = ordergoodsService.select_order_goods(order_id);
        int len = order_goods_list.size();
        List<Integer> goods_id_list = new LinkedList<>(); // 此处用LinkedList应该比ArrayList节省时间
        List<Integer> goods_number_list = new LinkedList<>();
        for (int i = 0;i < len;i++) {
            OrderGoods order_goods = order_goods_list.get(i);
            int goods_id = order_goods.get_goods_id();
            goods_id_list.add(goods_id);
            int goods_number = order_goods.get_goods_number();
            goods_number_list.add(goods_number);
        }
        Order_get result = new Order_get(order_id, user_id, order_state, order_price, time_stamp, goods_id_list, goods_number_list);
        return JSON.toJSONString(result);
    }

}
