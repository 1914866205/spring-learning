package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;
    @Test
    public void insert() {
        Post post = Post.builder().postId(1).forimId(1).title("测试帖子1").content("sss").build();
        int count = postDao.insert(post);
        System.out.println(count);
    }

    @Test
    public void batchInsert() {
        Post[] posts = {Post.builder().postId(2).forimId(2).title("测试帖子2").content("xxx").build(),
       Post.builder().postId(3).forimId(1).title("测试帖子3").content("hhh").build()
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(postList);
        System.out.println("row"+rows);
    }

    @Test
    public void delete() {
        int row=postDao.delete(1);
        System.out.println(row);
    }

    @Test
    public void update() {
        Post post=postDao.get(2);
        post.setTitle("测试帖子修改的新名称");
        int n = postDao.update(post);
        System.out.println("n"+n);
    }

    @Test
    public void get() {
        Post post=postDao.get(2);
        System.out.println(post);
    }

    @Test
    public void selectAll() {
        List<Post> posts = postDao.selectAll();
        for (Post post:posts) {
            System.out.println(post);
        }
    }

    @Test
    public void testSelectCount(){
        int num = postDao.selectCount();
        System.out.println(num);
    }


    @Test
    public void testeBatchDelete(){
        Post[] posts = {Post.builder().postId(2).forimId(2).title("测试帖子2").content("xxx").build(),
                Post.builder().postId(3).forimId(1).title("测试帖子3").content("hhh").build()
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchDelete(postList);
        System.out.println("row"+rows);
    }
}
