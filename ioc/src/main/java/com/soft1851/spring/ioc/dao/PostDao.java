package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

public interface PostDao {
    /**
     * 新增帖子
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量新增Post
     * @param posts
     * @return int[]
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 根据id删除Post
     *
     * @param postId
     * @return
     */
    int delete(int postId);


    /**
     * 修改Post
     * @param post
     * @return
     */
    int update(Post post);

    /**
     * 根据id查询Post
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     * 查询所有论坛信息
     * @return
     */
    List<Post> selectAll();

}
