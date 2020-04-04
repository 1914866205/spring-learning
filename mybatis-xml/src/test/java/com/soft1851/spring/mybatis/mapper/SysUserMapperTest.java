package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.SysUser;
import com.soft1851.spring.mybatis.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
@WebAppConfiguration("src/main/resources")
public class SysUserMapperTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void insert() {
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //生成随机盐
        MD5Util md5Util = new MD5Util();
        String passwordSalt = md5Util.generate("123456");
        SysUser sysUser = SysUser.builder()
                .userName("test")
                .password("123456")
                .salt(passwordSalt)
                .email("18851699003@163.com")
                .phoneNumber("18851699003")
                .status(1)
                .binding(0)
                .credits(0)
                .createTime(new Date())
                .lastLoginTime(new Date())
                .build();
        sysUserMapper.insert(sysUser);
        System.out.println(sysUser.getId());
    }}