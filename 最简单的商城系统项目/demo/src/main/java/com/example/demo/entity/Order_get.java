package com.example.demo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Log4j
public class Order_get {
    @Setter
    private int order_id;
    public int get_order_id() {
        return order_id;
    }
    @Setter
    private int user_id;
    public int get_user_id() {
        return user_id;
    }
    @Setter
    private String order_state;
    public String get_order_state() {
        return order_state;
    }
    @Setter
    private double order_price;
    public double get_order_price() {
        return order_price;
    }
    @Setter
    private String time_stamp;
    public String get_time_stamp() {
        return time_stamp;
    }
    @Setter
    private List<Integer> goods_id_list;
    public List<Integer> get_goods_id_list() {
        return goods_id_list;
    }

    @Setter List<Integer> goods_number_list;
    public List<Integer> get_goods_number_list() {
        return goods_number_list;
    }

    public Order_get(int user_id, List<Integer> goods_id_list, List<Integer> goods_number_list) {
        this.user_id = user_id;
        this.goods_id_list = goods_id_list;
        this.goods_number_list = goods_number_list;
    }

    public Order_get(int order_id, int user_id, String order_state, double order_price, String time_stamp, List<Integer> goods_id_list, List<Integer> goods_number_list) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_state = order_state;
        this.order_price = order_price;
        this.time_stamp = time_stamp;
        this.goods_id_list = goods_id_list;
        this.goods_number_list = goods_number_list;
    }
}
