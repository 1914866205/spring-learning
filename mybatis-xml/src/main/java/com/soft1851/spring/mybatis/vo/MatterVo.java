package com.soft1851.spring.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 20:31
 * @Version 1.0
 **/
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatterVo {
    private String teacherName;
    private String clazzName;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
}
