package com.soft1851.spring.mybatis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class TeacherServiceTest {
    @Resource
    private TeacherService teacherService;
    @Test
    public void getTeacherOneToOne() {
        System.out.println(teacherService.getTeacherOneToOne(1));
    }
}