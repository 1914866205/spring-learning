package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/26 10:25
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
 public class Topic {
   private String Id;
   private String topicName;
   private String topicIcon;
   private String description;
   private Integer msgCount;
   private Integer followsCount;
   private Boolean followed;
}
