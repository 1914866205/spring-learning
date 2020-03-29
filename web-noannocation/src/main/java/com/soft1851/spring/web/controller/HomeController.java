package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/24 9:48
 * @Version 1.0
 **/
@Controller
@RestController
public class HomeController {
//    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello Spring MVC");

        List<Books> bookList = new ArrayList<Books>();
        bookList.add(new Books("java编程思想","http://img3m0.ddimg.cn/4/24/9317290-1_b_5.jpg"));
        bookList.add(new Books("疯狂java讲义","http://img3m2.ddimg.cn/55/24/27858952-1_b_3.jpg"));
        bookList.add(new Books("java核心技术","http://img3m2.ddimg.cn/1/1/28487152-1_b_3.jpg"));
        model.addAttribute("bookList", bookList);

        Map<String, String> map = new HashMap<String, String>();
        map.put("java编程思想", "http://img3m0.ddimg.cn/4/24/9317290-1_b_5.jpg");
        map.put("疯狂java讲义","http://img3m2.ddimg.cn/55/24/27858952-1_b_3.jpg");
        map.put("java核心技术","http://img3m2.ddimg.cn/1/1/28487152-1_b_3.jpg");
        model.addAttribute("map", map);
        return "home";
    }
}
