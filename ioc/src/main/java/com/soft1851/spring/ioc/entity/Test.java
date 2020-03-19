package com.soft1851.spring.ioc.entity;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.ioc.config.JDBCConfig;
import com.soft1851.spring.ioc.dao.ForumDao;
import com.soft1851.spring.ioc.dao.impl.ForumDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Test {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(AppConfig.class);
//        actx.scan("com.soft1851.spring.ioc.config");
//
//        Phone phone = (Phone) actx.getBean("phone");
//        phone.setBrand("华为");
//        phone.setPrice(2000.0);
//        System.out.println(phone);

//        ForumDao forumDao = new ForumDaoImpl();
//        System.out.println(forumDao.get(5));

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JDBCConfig.class);
        ctx.scan("com.soft1851.spring.ioc.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
        ForumDao forumDao = (ForumDao) ctx.getBean("forumDao");
        System.out.println(forumDao.get(5));
    }
}
