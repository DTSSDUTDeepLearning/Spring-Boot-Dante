package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.OrderGoods;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("OrderGoodsDao")
public interface OrderGoodsDao {
    
    int insert_order_goods(@Param("order_id") int order_id, @Param("goods_id") int goods_id, @Param("goods_number") int goods_number);

    int delete_order_goods(@Param("order_id") int order_id);

    List<OrderGoods> select_order_goods(@Param("order_id") int order_id);
}
