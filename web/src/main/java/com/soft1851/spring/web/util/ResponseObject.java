package com.soft1851.spring.web.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/21 12:56
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object data;
}
