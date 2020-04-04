package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Music)实体类
 *
 * @author makejava
 * @since 2020-04-02 11:11:06
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Music implements Serializable {
    private static final long serialVersionUID = 382626475913615522L;
    
    private Integer id;
    
    private String title;
    
    private String songList_Time;
    
    private String author;
    
    private String link;


}