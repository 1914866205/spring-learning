package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDao;
import com.soft1851.spring.ioc.entity.Forum;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO  t_post VALUES (?,?,?,null,null,null)";
        Object[] args = {post.getPostId(),post.getForimId(),post.getTitle()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO  t_post VALUES (?,?,?,null,null,null)";

//        String sql="INSERT INTO t_post VALUES(NULL,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, postList.get(i).getPostId());
                preparedStatement.setInt(2, postList.get(i).getForimId());
                preparedStatement.setString(3, postList.get(i).getTitle());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id=?";
        Object[] args = {postId};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int update(Post post) {
        String sql = "UPDATE t_post SET title= ? WHERE post_id =?";
        Object[] args = {post.getTitle(), post.getPostId()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id=?";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql, args, new BeanPropertyRowMapper<>(Post.class));    }

    @Override
    public List<Post> selectAll() {
        String sql = "SELECT * FROM t_post";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));    }

    @Override
    public int selectCount() {
        String sql = "SELECT count(*) FROM t_post";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    @Override
    public int[] batchDelete(List<Post> posts){
        final List<Post> postList = posts;
        String sql = "DELETE FROM t_post WHERE post_id=?";

        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1, postList.get(i).getPostId());
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });    }
}
