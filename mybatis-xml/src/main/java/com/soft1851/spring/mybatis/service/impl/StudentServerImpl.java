package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.mapper.StudentMapper;
import com.soft1851.spring.mybatis.service.StudentServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 14:30
 * @Version 1.0
 **/
@Service
public class StudentServerImpl implements StudentServer {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public int insert(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public void delete(int studentId) {
        studentMapper.delete(studentId);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentMapper.getStudentById(studentId);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public int batchInsert(List<Student> students) {
        return studentMapper.batchInsert(students);
    }

    @Override
    public int batchDelete(@Param("idList") List<Integer> idList) {
        return studentMapper.batchDelete(idList);
    }

    @Override
    public int batchUpdate(List<Student> students) {
        return studentMapper.batchUpdate(students);
    }

    @Override
    public List<Student> selectLimit() {
        return studentMapper.selectLimit();
    }

    @Override
    public List<Student> selectLimitByDynamicSql(Student student) {
        return studentMapper.selectLimitByDynamicSql(student);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }


}
