
package com.soft1851.spring.mybatis.service;


import com.soft1851.spring.mybatis.entity.Forum;

import java.util.List;


/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/21 11:32
 * @Version 1.0
 **/

public interface ForumService {

/**
     * 查询所有Forum
     *
     * @return List<Forum>
     */

    List<Forum> selectAll();


/**
     * 根据id查询
     *
     * @param forumId
     * @return
     */

    Forum get(int forumId);


/**
     * 更新信息
     * @param forum
     * @return
     */

    int update(Forum forum);
}

