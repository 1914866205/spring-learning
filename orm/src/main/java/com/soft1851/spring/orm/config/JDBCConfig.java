package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.dao.impl.ForumDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class JDBCConfig {
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new  DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/springtest?useSSL=false&serverTimezone=UTC&Unicode=true&characterEncoding=utf-8");
        druidDataSource.setUsername("ntt");
        druidDataSource.setPassword(".15252205596xin");
        druidDataSource.setInitialSize(8);
        return druidDataSource;
    }

//    @Bean
//    public org.springframework.jdbc.core.JdbcTemplate jdbcTemplate(){
//        return new org.springframework.jdbc.core.JdbcTemplate(this.druidDataSource());
//    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

    @Bean
    public ForumDao forumDao(JdbcTemplate jdbcTemplate) {
        return new ForumDaoImpl(jdbcTemplate);
    }
}
