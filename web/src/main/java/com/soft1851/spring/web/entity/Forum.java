
package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/21 11:17
 * @Version 1.0
 **/

//论坛
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {
    private Integer forumId;
    private String forumName;

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", forumName='" + forumName + '\'' +
                '}';
    }
}

