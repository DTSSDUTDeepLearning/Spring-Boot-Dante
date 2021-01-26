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
public class Goods {
    @Setter
    private int goods_id;
    public int get_goods_id() {
        return goods_id;
    }
    @Setter
    private String goods_name;
    public String get_goods_name() {
        return goods_name;
    }
    @Setter
    private double goods_price;
    public double get_goods_price() {
        return goods_price;
    }
    public Goods(String goods_name, double goods_price) {
        this.goods_name = goods_name;
        this.goods_price = goods_price;
    }
    public Goods(int goods_id, String goods_name, double goods_price) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
    }
}
