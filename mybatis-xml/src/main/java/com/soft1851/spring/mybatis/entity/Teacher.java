package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 11:10
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    private int teacherId;
    private String teacherName;
    private int clazzId;
    private Clazz clazz;
}
