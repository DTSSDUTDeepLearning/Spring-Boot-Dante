package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.OrderGoods;

public interface OrderGoodsService {
    
    int insert_order_goods(int order_id, int goods_id, int goods_number);

    int delete_order_goods(int order_id);

    List<OrderGoods> select_order_goods(int order_id);
}
