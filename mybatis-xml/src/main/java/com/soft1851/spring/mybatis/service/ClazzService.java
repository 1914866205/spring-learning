package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.Teacher;
import com.soft1851.spring.mybatis.vo.ClazzVo;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 19:43
 * @Version 1.0
 **/
public interface ClazzService {
    /**
     * 获取指定班课中所有学生的信息
     *
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取指定班课中所有教师的信息
     *
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzTeacher(int clazzId);
    /**
     * 获取指定班课中所有教师的信息
     *
     * @param id
     * @return
     */
    List<Map<String, Object>> getClazzStudent1(int id);

    /**
     * 查询某位老师的某个班级上面的某个学生
     */
    List<Teacher> selectLimitFromTeacherInClassByDynamicSql(MatterDto matterDto);

    /**
     * 根据teacherId 一对一关联查询其管理的老师信息
     *
     * @param clazzId
     * @return
     */
    Teacher getTeacherOneToOne(int clazzId);

    /**
     * 根据clazzId一对多关联本班所有学生
     * @param clazzId
     * @return
     */
    Clazz getClazzOneToMany(int clazzId);
}
