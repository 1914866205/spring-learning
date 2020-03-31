package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Teacher;
import com.soft1851.spring.mybatis.mapper.TeacherMapper;
import com.soft1851.spring.mybatis.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 11:14
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherOneToOne(int teacherId) {
        return teacherMapper.getTeacherOneToOne(teacherId);
    }
}
