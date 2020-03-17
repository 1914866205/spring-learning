package com.soft1851.spring.ioc.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserLogin {
    private User adminUser;

    public boolean userLogin(User user){
        boolean flag=false;
        //获取配置文件的结果
        ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
        adminUser = (User) ac.getBean("user");
        if (adminUser.getAccount().equals(user.getAccount())&&adminUser.getPassword().equals(user.getPassword())){
            flag = true;
        }
        return flag;
    }
    public User getUser() {
        return adminUser;
    }

    public void setUser(User adminUser) {
        this.adminUser = adminUser;
    }
}
