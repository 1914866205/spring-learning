package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 14:21
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentId;
    private int clazzId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
    private Clazz clazz;
}
