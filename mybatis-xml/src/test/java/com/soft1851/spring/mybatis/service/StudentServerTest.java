package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentServerTest {
    @Resource
    private StudentServer studentServer;
    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏南京")
                .birthday(LocalDate.of(2000,10,10))
                .build();
        studentServer.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentServer.delete(2010);
    }

    @Test
    public void select() {
        System.out.println(studentServer.getStudentById(1006));
    }

    @Test
    public void update(){
        Student student = studentServer.getStudentById(1006);
        student.setStudentName("小胖");
        student.setHometown("徐州");
        student.setBirthday(LocalDate.of(1999, 5, 27));
        studentServer.update(student);
    }

    @Test
    public void batchInsert(){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            Student student = Student.builder()
                    .studentId(3000 + i)
                    .studentName("测试" + i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(1999, 5, 27))
                    .build();
            students.add(student);
        }
        System.out.println(studentServer.batchInsert(students));
    }

    @Test
    public void batchDelete(){
        List<Integer> idList = new ArrayList<>();
        for (int i = 3000; i <3008 ; i++) {
            idList.add(i);
        }
        studentServer.batchDelete(idList);
    }

    @Test
    public void batchUpdate(){
        List<Student> students = new ArrayList<>();
        Student student1 = studentServer.getStudentById(1006);
        student1.setStudentName("小胖胖");
        students.add(student1);
        Student student2 = studentServer.getStudentById(1007);
        student2.setStudentName("田震震");
        students.add(student2);
        studentServer.batchUpdate(students);
    }

    @Test
    public void selectLimit(){
        System.out.println(studentServer.selectLimit());
    }

    @Test
    public void selectLimitByDynamicSql(){
        Student student=Student.builder().clazzId(1).hometown("徐州").build();
        System.out.println(studentServer.selectLimitByDynamicSql(student));
    }

    @Test
    public void selectAll(){
        System.out.println(studentServer.selectAll());
    }

    @Test
    public void queryStudentsBySql(){
        System.out.println(studentServer.queryStudentsBySql(4,5));
    }
}