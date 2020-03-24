//package com.soft1851.spring.web.controller;
//
//import com.alibaba.fastjson.JSON;
//import com.soft1851.spring.web.service.ForumService;
//import com.soft1851.spring.web.util.ResponseObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Description TODO
// * @Author 涛涛
// * @Date 2020/3/21 12:57
// * @Version 1.0
// **/
//
//@RestController
//@RequestMapping(value = "forum")
//public class ForumController {
//    @Autowired
//    private ForumService forumService;
//    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
//    public String getForum(){
//        ResponseObject ro = new ResponseObject(1, "成功", forumService.selectAll());
//        return JSON.toJSONString(ro);
//    }
//
//    @RequestMapping(value = "/list/{id}", produces = "application/json;charset=utf-8")
//    public String getForumById(@PathVariable int id){
//        ResponseObject ro = new ResponseObject(1, "成功", forumService.get(id));
//        return JSON.toJSONString(ro);
//    }
//
////    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
////    public String getForum(){
////        ResponseObject ro = new ResponseObject(1, "成功", forumService.selectAll());
////        return JSON.toJSONString(ro);
////    }
//}
