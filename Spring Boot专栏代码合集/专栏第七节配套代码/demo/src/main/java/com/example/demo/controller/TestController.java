package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import com.example.demo.config.Base64ToPic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private JdbcTemplate JdbcTemplate;

    @RequestMapping(value = "/firstMethod", method = { RequestMethod.GET })
    public String firstMethod() {
        System.out.println("Hello World!");
        return "Hello World!";
    }

    @RequestMapping(value = "/sqlMethod", method = { RequestMethod.GET })
    public List<Map<String, Object>> secondMethod() {
        String sql = "select * from user_";
        return JdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "/sqlMethod_parameter", method = { RequestMethod.GET })
    public List<Map<String, Object>> thirdMethod(@RequestParam("user_id") int user_id) {
        String sql = "select * from user_ where user_id=" + user_id;
        return JdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "/sqlMethod_parameters", method = { RequestMethod.GET })
    public List<Map<String, Object>> fourthMethod(@RequestParam("user_id1") int user_id1,
            @RequestParam("user_id2") int user_id2) {
        String sql = "select * from user_ where user_id=" + user_id1 + " or user_id=" + user_id2;
        return JdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "save_picture", method = {RequestMethod.GET})
    public String save_picture() {
        String picture_txt_path = "E:/SpringBoot/firstDemo/demo/src/main/resources/picture.txt";
        FileInputStream fin;
        try {
            fin = new FileInputStream(picture_txt_path);
            InputStreamReader reader = new InputStreamReader(fin);
            BufferedReader buffReader = new BufferedReader(reader);
            String picture_string = "";
            String line;
            while ((line = buffReader.readLine()) != null) {
                picture_string+=line;
            }
            buffReader.close();
            
            String[] picture_type_base = Base64ToPic.split(picture_string);
            if (picture_type_base == null) {
                return "图片上传出错";
            }

            String imageName = "test."+picture_type_base[0]; // 要保存的图片的文件名
            boolean b = Base64ToPic.GenerateImage(picture_type_base[1], imageName);
            if (b) {
                return "图片上传成功";
            }
            else {
                return "图片上传失败";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "文件未找到";
        } catch (IOException e) {
            e.printStackTrace();
            return "文件读写出错";
        }
    }
    
}
