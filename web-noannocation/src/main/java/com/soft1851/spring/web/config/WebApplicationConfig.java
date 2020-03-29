package com.soft1851.spring.web.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Description Web应用配置，替换之前的web.xml文件
 * @Author 涛涛
 * @Date 2020/3/24 8:52
 * @Version 1.0
 **/
public class WebApplicationConfig implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //创建一个基于注解的Web应用的上下文配置对象
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        //将WebMvcConfig的配置类注册进来   这个类相当于 -servlet
        ctx.register(WebMvcConfig.class);

        //设置servletContext  最高优先级
        ctx.setServletContext(servletContext);
        //刷新
        ctx.refresh();
        //映射了ctx规则的配置
        //配置了ctx的映射规则的对象  进行时动态注册                              分发servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        //添加规则
        registration.addMapping("/");
        //设置该servlet的启动优先级
        registration.setLoadOnStartup(1);


    }
}
