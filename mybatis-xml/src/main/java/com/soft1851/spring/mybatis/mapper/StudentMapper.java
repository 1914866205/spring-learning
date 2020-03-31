package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 14:24
 * @Version 1.0
 **/
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {

    /**
     * 新增student，并返回自增主键
     * @param student
     */
    int insert(Student student);

    /**
     * 根据studentId删除Student
     *
     * @param studentId
     */
    void delete(int studentId);


    /**
     * 根据studentId查找用户
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
     * 批量添加
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
     * @param students
     * @return
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 单表(带两个指定条件)查询
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
