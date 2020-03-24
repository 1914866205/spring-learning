package com.soft1851.spring.orm.dao.impl;

import com.soft1851.spring.orm.config.JDBCConfig;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes ={JDBCConfig.class})
public class ForumDaoImplTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void selectAll() {
        ForumDao forumDao = new ForumDaoImpl(jdbcTemplate);
        List<Forum> list = forumDao.selectAll();
        list.forEach(System.out::println);
    }
}
