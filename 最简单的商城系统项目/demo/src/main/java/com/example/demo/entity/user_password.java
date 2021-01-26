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

public class user_password {
    @Setter
    public int user_id;
    public int get_user_id() {
        return user_id;
    }

    @Setter
    public String old_user_password;
    public String get_old_user_password() {
        return old_user_password;
    }

    @Setter
    public String user_password;
    public String get_user_password() {
        return user_password;
    }

    public user_password(int user_id, String user_password) {
        this.user_id = user_id;
        this.user_password = user_password;
    }

    public user_password(int user_id, String old_user_password, String user_password) {
        this.user_id = user_id;
        this.old_user_password = old_user_password;
        this.user_password = user_password;
    }
}
