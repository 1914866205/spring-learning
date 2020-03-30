package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.service.TopicService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/27 17:58
 * @Version 1.0
 **/
@Controller
public class TopicController {
    @Resource
    private TopicService topicService;

    /**
     * 如果类级别加了@Controller，而方法级别不添加@ResponseBody
     * 则返回的是一个视图
     */
    @GetMapping(value = "topics", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getTopic() {
        ResponseObject rs = new ResponseObject(1, "success", topicService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/topic")
    public String topic(Model model){
        model.addAttribute("topics", topicService.queryAll());
        // topic其实是视图的名字
        return "topic";
    }
}
