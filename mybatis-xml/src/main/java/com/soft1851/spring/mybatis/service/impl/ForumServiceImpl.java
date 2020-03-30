package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Forum;
import com.soft1851.spring.mybatis.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/21 11:33
 * @Version 1.0
 **/
public class ForumServiceImpl implements ForumService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Forum> selectAll() {
        String sql = "SELECT * FROM springtest.t_forum";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Forum.class));
    }

    @Override
    public Forum get(int forumId) {
        String sql = "SELECT * FROM springtest.t_forum WHERE forum_id=?";
        Object[] args = {forumId};
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Forum.class));
    }

    @Override
    public int update(Forum forum) {
        String sql = "UPDATE springtest.t_forum SET forum_name=? WHERE forum_id =?";
        Object[] args = {forum.getForumName(), forum.getForumId()};
        return jdbcTemplate.update(sql,args);
    }

}
