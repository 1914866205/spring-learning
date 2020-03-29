package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.HeroService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 16:34
 * @Version 1.0
 **/
@Controller
//@RequestMapping(value = "/")
public class HeroController {
    @Resource
    private HeroService heroService;

    @GetMapping(value = "heros", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getHero() {
        ResponseObject rs = new ResponseObject(1, "success", heroService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/")
    public String topic(Model model) {
        model.addAttribute("heros", heroService.queryAll());
        return "hero";
    }
}
