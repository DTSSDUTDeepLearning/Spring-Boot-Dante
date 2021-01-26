package com.example.demo.service.impl;

import com.example.demo.dao.GoodsDao;
import com.example.demo.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService{

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public String select_goods_name_by_goods_id(int goods_id) {
        return goodsDao.select_goods_name_by_goods_id(goods_id);
    }

    @Override
    public double select_goods_price_by_goods_id(int goods_id) {
        return goodsDao.select_goods_price_by_goods_id(goods_id);
    }
    
}
