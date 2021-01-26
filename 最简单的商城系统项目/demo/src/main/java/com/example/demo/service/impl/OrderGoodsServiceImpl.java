package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.OrderGoodsDao;
import com.example.demo.entity.OrderGoods;
import com.example.demo.service.OrderGoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderGoodsService")
public class OrderGoodsServiceImpl implements OrderGoodsService {

    @Autowired
    private OrderGoodsDao ordergoodsDao;

    @Override
    public int insert_order_goods(int order_id, int goods_id, int goods_number) {
        return ordergoodsDao.insert_order_goods(order_id, goods_id, goods_number);
    }

    @Override
    public int delete_order_goods(int order_id) {
        return ordergoodsDao.delete_order_goods(order_id);
    }

    @Override
    public List<OrderGoods> select_order_goods(int order_id) {
        return ordergoodsDao.select_order_goods(order_id);
    }
    
}
