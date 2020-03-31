package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 14:29
 * @Version 1.0
 **/
public interface StudentServer {
    int insert(Student student);

    /**
     * 根据studentId删除student
     *
     * @param studentId
     */
    void delete(int studentId);

    /**
     * 根据id查找用户
     *
     * @param studentId
     * @return
     */
    Student getStudentById(int studentId);

    /**
     * 修改Student
     * @param student
     */
    void update(Student student);

    /**
     * 批量插入
     *
     * @param students
     * @return
     */
    int batchInsert(@Param("students") List<Student> students);

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 批量修改
     *
     * @param students
     * @return
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 单表(带两个指定条件) 查询
     * @return
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询（结合动态SQL）
     *
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 查询所有学生，按生日排序，多对一关联查询学生所在班级信息
     * @return
     */
    List<Student> selectAll();
}
