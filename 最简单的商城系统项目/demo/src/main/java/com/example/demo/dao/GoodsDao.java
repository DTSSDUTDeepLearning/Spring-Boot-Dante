package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("GoodsDao")
public interface GoodsDao {
    String select_goods_name_by_goods_id(@Param("goods_id") int goods_id);
    double select_goods_price_by_goods_id(@Param("goods_id") int goods_id);
}
