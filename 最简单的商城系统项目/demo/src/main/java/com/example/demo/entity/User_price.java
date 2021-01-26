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

public class User_price {
    @Setter
    public int user_id;
    public int get_user_id() {
        return user_id;
    }

    @Setter
    public double price;
    public double get_price() {
        return price;
    }

    public User_price(int user_id, double price) {
        this.user_id = user_id;
        this.price = price;
    }
}
