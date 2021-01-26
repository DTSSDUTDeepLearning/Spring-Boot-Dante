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
public class OrderGoods {
    @Setter
    private int order_id;
    public int get_order_id() {
        return order_id;
    }

    @Setter
    private int goods_id;
    public int get_goods_id() {
        return goods_id;
    }

    @Setter
    private int goods_number;
    public int get_goods_number() {
        return goods_number;
    }

    public OrderGoods(int order_id, int goods_id, int goods_number) {
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.goods_number = goods_number;
    }
}
