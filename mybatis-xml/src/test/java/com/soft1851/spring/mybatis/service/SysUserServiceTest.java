package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class SysUserServiceTest {

    @Resource
    private SysUserService sysUserService;
    @Test
    public void insert() {
        SysUser sysUser = SysUser.builder()
                .userName("test")
                .password("123456")
                .email("18851699003@163.com")
                .phoneNumber("18851699003")
                .status(1)
                .binding(0)
                .credits(0)
                .createTime(new Date())
                .lastLoginTime(new Date())
                .build();
        sysUserService.insert(sysUser);
    }
//    @Test
//    public void login() {
//        Boolean flag = false;
//        String username = "涛涛";
//        String password = "123";
//        SysUser sysUser = SysUser.builder()
//                .id(1)
//                .phoneNumber("19999999")
//                .build();
//        SysUser sysUser1 = sysUserMapper.getUserByUser(sysUser);
//        if ("涛涛".equals(sysUser1.getUserName()) || "123".equals(sysUser1.getPassword())) {
//            flag = true;
//            System.out.println("登录成功");
//            if (flag == true) {
//                SysUser sysUser2 = sysUserMapper.selectById(sysUser1.getId());
//                sysUser2.setLastLoginTime(new Date());
//                sysUserMapper.update(sysUser2);
//                sysUserService.addCredits(sysUser2);
//                System.out.println(sysUser2);
//            }
//        }
//    }
    @Test
    public void getUserByUser() {
        System.out.println(sysUserService.getUserByUser(SysUser.builder().id(1).email("123").build()));
        System.out.println(sysUserService.getUserByUser(SysUser.builder().id(9).phoneNumber("19999999").build()));
    }

    @Test
    public void addCredits(){
        SysUser sysUser = sysUserService.getUserByUser(SysUser.builder().id(1).phoneNumber("19999999").build());
        sysUserService.addCredits(sysUser);
    }

    @Test
    public void loadMusic(){
        sysUserService.loadMusic(SysUser.builder().credits(1).build());
        sysUserService.loadMusic(SysUser.builder().credits(50).build());
        sysUserService.loadMusic(SysUser.builder().credits(51).build());
        sysUserService.loadMusic(SysUser.builder().credits(100).build());
        sysUserService.loadMusic(SysUser.builder().credits(101).build());
    }

}