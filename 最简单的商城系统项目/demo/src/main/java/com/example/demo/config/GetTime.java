package com.example.demo.config;

import java.util.Date;
import java.text.SimpleDateFormat;

public class GetTime {

    public static String NowTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(df.format(new Date())); // new Date()为获取当前系统时间
        return df.format(new Date());
    }

}
