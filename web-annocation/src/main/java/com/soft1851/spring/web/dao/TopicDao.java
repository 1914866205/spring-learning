package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/26 10:27
 * @Version 1.0
 **/
public interface TopicDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     *
     * @param topics
     * @return
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增一个
     * @param topic
     * @return
     */
    int insert(Topic topic);

}
