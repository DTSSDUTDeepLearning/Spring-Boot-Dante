package com.example.demo.controller;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/firstMethod", method = {RequestMethod.GET})
    public String firstMethod() {
        System.out.println("Hello World!");
        return "Hello World!";
    }

    @RequestMapping(value = "/sqlMethod", method = {RequestMethod.GET})
    public List<Map<String, Object>> secondMethod() {
        String sql = "select * from user_";
        return JdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "/sqlMethod_parameter", method = {RequestMethod.GET})
    public List<Map<String, Object>> thirdMethod(@RequestParam("user_id") int user_id) {
        String sql = "select * from user_ where user_id="+user_id;
        return JdbcTemplate.queryForList(sql);
    }

    @RequestMapping(value = "/sqlMethod_parameters", method = {RequestMethod.GET})
    public List<Map<String, Object>> fourthMethod(@RequestParam("user_id1") int user_id1, @RequestParam("user_id2") int user_id2) {
        String sql = "select * from user_ where user_id="+user_id1+" or user_id="+user_id2;
        return JdbcTemplate.queryForList(sql);
    }
    
}
