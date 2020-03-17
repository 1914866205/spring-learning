package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/beans.xml"})
public class ForumDaoTest {
    @Autowired
    private ForumDao forumDao;
    @Test
    public void insert() {
        Forum forum=Forum.builder().forumName("测试论坛").build();
        int count = forumDao.insert(forum);
        System.out.println(count);
    }

    @Test
    public void batchInsert(){
        Forum[] forums = {Forum.builder().forumName("测试论坛1").build(),
                Forum.builder().forumName("测试论坛2").build(),
                Forum.builder().forumName("测试论坛3").build()
        };
        List<Forum> forumList = Arrays.asList(forums);
        int[] rows = forumDao.batchInsert(forumList);
        System.out.println("row"+rows);
    }

    @Test
    public void update(){
        Forum forum=forumDao.get(1);
        forum.setForumName("测试论坛修改的新名称");
        int n = forumDao.update(forum);
        System.out.println("n"+n);
    }

    @Test
    public void get(){
        Forum forum=forumDao.get(1);
        System.out.println(forum);
    }

    @Test
    public void selectAll(){
        List<Forum> forums = forumDao.selectAll();
        System.out.println(forums.get(0));
        System.out.println(forums.get(1));
        System.out.println(forums.get(2));
        System.out.println(forums.get(3));
    }
}
