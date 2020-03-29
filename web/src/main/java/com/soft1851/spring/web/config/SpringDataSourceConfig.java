package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.soft1851.spring.web")
public class SpringDataSourceConfig {
    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new  DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/springtest?useSSL=false&serverTimezone=UTC&Unicode=true&characterEncoding=utf-8");
        druidDataSource.setUsername("ntt");
        druidDataSource.setPassword(".15252205596xin");
        druidDataSource.setInitialSize(8);
        druidDataSource.setMinIdle(1);
        //配置获取连接等待超时的时间
        druidDataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测。检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //禁止自动提交，实现事务管理
        druidDataSource.setDefaultAutoCommit(true);
        //设置连接池启用预处理事务集
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

}
