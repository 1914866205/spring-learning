package com.soft1851.spring.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 19:38
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClazzVo {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    private Integer studentId;
    private String studentName;
    private String hometown;
    private LocalDate birthday;
}
