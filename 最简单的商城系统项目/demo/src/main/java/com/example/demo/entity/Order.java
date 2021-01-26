package com.example.demo.entity;

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
public class Order {
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

    public Order(int user_id, String order_state, double order_price, String time_stamp) {
        this.user_id = user_id;
        this.order_state = order_state;
        this.order_price = order_price;
        this.time_stamp = time_stamp;
    }

    public Order(int user_id, double order_price) {
        this.user_id = user_id;
        this.order_price = order_price;
    }
}
