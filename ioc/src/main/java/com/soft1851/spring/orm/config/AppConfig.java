package com.soft1851.spring.orm.config;

import com.soft1851.spring.orm.entity.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Phone phone(){
        return new Phone();
    }
}
