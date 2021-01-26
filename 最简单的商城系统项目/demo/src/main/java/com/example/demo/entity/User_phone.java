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

public class User_phone {
    @Setter
    public int user_id;
    public int get_user_id() {
        return user_id;
    }

    @Setter
    public String user_phone;
    public String get_user_phone() {
        return user_phone;
    }

    public User_phone(int user_id, String user_phone) {
        this.user_id = user_id;
        this.user_phone = user_phone;
    }
}
