package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Teacher;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 11:13
 * @Version 1.0
 **/
public interface TeacherService {
    /**
     * 根据teacherId 一对一关联查询其管理的班级信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherOneToOne(int teacherId);}
