package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderService {
    
    int insert_order_with_pay(int order_id, int user_id, double order_price, String time_stamp);
    int insert_order_without_pay(int order_id, int user_id, double order_price, String time_stamp);

    int delete_order(int order_id);

    int update_order_pay(int order_id);
    int update_order_receive(int order_id);

    int find_max_order_id();
    Order select_order_by_order_id(int order_id);
    List<Integer> select_order_id_list_by_user_id(int user_id);
}
