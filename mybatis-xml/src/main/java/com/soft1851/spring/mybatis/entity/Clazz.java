package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 11:28
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clazz {
    private int clazzId;
    private String clazzName;
    private int teacherId;
    private Teacher teacher;
    private List<Student> students;
}
