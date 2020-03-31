package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.MatterDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ClazzServiceTest {
    @Resource
    private ClazzService clazzService;
    @Resource
    private StudentServer studentServer;

    @Test
    public void getClazzStudent() {
        clazzService.getClazzStudent(2).forEach(System.out::println);
    }

    @Test
    public void getClazzTeacher() {
        clazzService.getClazzTeacher(2).forEach(System.out::println);
    }

    @Test
    public void getClazzStudent1() {
        clazzService.getClazzStudent1(2).forEach(System.out::println);
    }

    @Test
    public void selectLimitFromTeacherInClassByDynamicSql() {
//        System.out.println(clazzService.selectLimitFromTeacherInClassByDynamicSql(MatterDto.builder().clazzName("软件1851").student(studentServer.getStudentById(1006)).teacherName("许老师").build()));
        System.out.println(clazzService.selectLimitFromTeacherInClassByDynamicSql(MatterDto.builder().clazzName("软件1851").studentName("小胖胖").teacherName("许老师").build()));
    }

    @Test
    public void getTeacherOneToOne(){
        System.out.println(clazzService.getTeacherOneToOne(1));
    }

    @Test
    public void getClazzOneToMany(){
        System.out.println(clazzService.getClazzOneToMany(1));
    }
}
