package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@CrossOrigin
@ResponseBody
public class GoodsController {

    @Autowired
    private GoodsService goodsService;
    
    @RequestMapping("look_goods_detail")
    public String look_goods_detail(@RequestBody String goods_id_str) {
        int goods_id = JSON.parseObject(goods_id_str, Integer.class);
        String goods_name = goodsService.select_goods_name_by_goods_id(goods_id);
        double goods_price = goodsService.select_goods_price_by_goods_id(goods_id);
        Goods goods = new Goods(goods_id, goods_name, goods_price);
        return JSON.toJSONString(goods);
    }
}
