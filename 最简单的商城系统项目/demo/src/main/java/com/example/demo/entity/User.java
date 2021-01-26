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
public class User {
    @Setter
    private int user_id;
    public int get_user_id() {
        return user_id;
    }
    @Setter
    private String user_name;
    public String get_user_name() {
        return user_name;
    }
    @Setter
    private String user_phone;
    public String get_user_phone() {
        return user_phone;
    }
    @Setter
    private String user_password;
    public String get_user_password() {
        return user_password;
    }
    @Setter double user_wallet;
    public double get_user_wallet() {
        return user_wallet;
    }
    @Setter
    private String register_time;
    public String get_register_time() {
        return register_time;
    }
    @Setter
    private String login_time;
    public String get_login_time() {
        return login_time;
    }

    public User(String user_name, String user_password) {
        this.user_name = user_name;
        this.user_password = user_password;
    }

    public User(String user_name, String user_phone, String user_password) {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_password = user_password;
    }

}