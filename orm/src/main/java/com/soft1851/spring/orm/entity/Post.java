package com.soft1851.spring.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

//帖子
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer postId;
    private Integer forimId;
    private String title;
    //缩略图
    private String content;
    //帖子图片
    private byte[] thumbnail;
    //时间戳
    private Timestamp createTime;
}
