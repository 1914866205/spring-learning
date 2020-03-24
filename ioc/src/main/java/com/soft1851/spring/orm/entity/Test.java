package com.soft1851.spring.orm.entity;

import com.soft1851.spring.orm.config.JDBCConfig;
import com.soft1851.spring.orm.dao.ForumDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
public class Test {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JDBCConfig.class);
        ctx.scan("com.soft1851.spring.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
        ForumDao forumDao = (ForumDao) ctx.getBean("forumDao");
        System.out.println(forumDao.delete(8));

    }
}
