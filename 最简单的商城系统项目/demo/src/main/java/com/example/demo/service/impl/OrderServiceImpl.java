package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int insert_order_with_pay(int order_id, int user_id, double order_price, String time_stamp) {
        return orderDao.insert_order_with_pay(order_id, user_id, order_price, time_stamp);
    }

    @Override
    public int insert_order_without_pay(int order_id, int user_id, double order_price, String time_stamp) {
        return orderDao.insert_order_without_pay(order_id, user_id, order_price, time_stamp);
    }

    @Override
    public int delete_order(int order_id) {
        return orderDao.delete_order(order_id);
    }

    @Override
    public int update_order_pay(int order_id) {
        return orderDao.update_order_pay(order_id);
    }

    @Override
    public int update_order_receive(int order_id) {
        return orderDao.update_order_receive(order_id);
    }

    @Override
    public int find_max_order_id() {
        return orderDao.find_max_order_id();
    }

    @Override
    public Order select_order_by_order_id(int order_id) {
        return orderDao.select_order_by_order_id(order_id);
    }

    @Override
    public List<Integer> select_order_id_list_by_user_id(int user_id) {
        return orderDao.select_order_id_list_by_user_id(user_id);
    }
    
}
