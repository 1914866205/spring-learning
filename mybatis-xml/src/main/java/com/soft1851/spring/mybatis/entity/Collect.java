package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Collect)实体类
 *
 * @author makejava
 * @since 2020-04-02 11:24:22
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collect implements Serializable {
    private static final long serialVersionUID = -74574976680324852L;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 歌曲id
    */
    private Integer musicId;

}