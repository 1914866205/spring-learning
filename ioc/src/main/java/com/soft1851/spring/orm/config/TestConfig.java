package com.soft1851.spring.orm.config;

import com.soft1851.spring.orm.entity.Phone;
import com.soft1851.spring.orm.entity.Sort;
import com.soft1851.spring.orm.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class TestConfig {
    @Bean
    public Phone phone(){
        return new Phone();
    }

    @Bean
    public Student student(){
        return new Student();
    }
    @Bean
    public Student student2(){
        return new Student();
    }
    @Bean
    public Sort sort(){
        return new Sort();
    }
}
