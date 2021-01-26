package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Order;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("OrderDao")
public interface OrderDao {

    int insert_order_with_pay(@Param("order_id") int order_id, @Param("user_id") int user_id, @Param("order_price") double order_price, @Param("time_stamp") String time_stamp);
    int insert_order_without_pay(@Param("order_id") int order_id, @Param("user_id") int user_id, @Param("order_price") double order_price, @Param("time_stamp") String time_stamp);

    int delete_order(@Param("order_id") int order_id);

    int update_order_pay(@Param("order_id") int order_id);
    int update_order_receive(@Param("order_id") int order_id);

    int find_max_order_id();
    Order select_order_by_order_id(@Param("order_id") int order_id);
    List<Integer> select_order_id_list_by_user_id(@Param("user_id") int user_id);
}
