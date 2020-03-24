//package com.soft1851.spring.web.service;
//
//import com.soft1851.spring.web.entity.Forum;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/applicationContext.xml"})
//public class ForumServiceTest {
//    @Autowired
//    private ForumService forumService;
//
//    @Test
//    public void selectAll() {
//        List<Forum> forumList = forumService.selectAll();
//        forumList.forEach(System.out::println);
//    }
//
//    @Test
//    public void get() {
//        Forum forum = forumService.get(5);
//        System.out.println(forum);
//    }
//
//    @Test
//    public void insert(){
//        Forum forum=Forum.builder().forumId(5).forumName("测试论坛一万").build();
//        int count = forumService.update(forum);
//        System.out.println(count);
//    }
//}
