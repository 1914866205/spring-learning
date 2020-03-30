package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @Configuration注解用来标注本类是个配置类，
 * @ComponentScan用来扫描包
 * @PropertySource用来读入资源目录的属性文件,
 * @EnableTransactionManagement注解运行事务管理器
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class SpringDataSourceConfig {
    @Value("${jdbc.driver}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;


    @Bean
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(8);
        druidDataSource.setMinIdle(1);
        //配置获取连接等待超时的时间
        druidDataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测。检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        //配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //禁止自动提交，实现事务管理
        druidDataSource.setDefaultAutoCommit(false);
        //设置连接池启用预处理事务集
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        return new JdbcTemplate(druidDataSource);
    }

    /**
     * 装配事务管理器
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }

}
