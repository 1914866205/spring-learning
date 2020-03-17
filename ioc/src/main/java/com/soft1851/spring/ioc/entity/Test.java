package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(AppConfig.class);
        actx.scan("com.soft1851.spring.ioc.config");

        Phone phone = (Phone) actx.getBean("phone");
        phone.setBrand("华为");
        phone.setPrice(2000.0);
        System.out.println(phone);
    }
}
