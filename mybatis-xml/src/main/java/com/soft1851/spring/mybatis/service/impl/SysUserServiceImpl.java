package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.SysUser;
import com.soft1851.spring.mybatis.mapper.SysUserMapper;
import com.soft1851.spring.mybatis.service.SysUserService;
import com.soft1851.spring.mybatis.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/2 9:39
 * @Version 1.0
 **/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;


    @Override
    public boolean login(SysUser sysUser) {
        Boolean flag = false;
        if (sysUserMapper.getUserByUser(sysUser)!=null) {
            flag = true;
            System.out.println("登录成功");
            if (flag == true) {
                SysUser sysUser2 = sysUserMapper.selectById(sysUser1.getId());
                sysUser2.setLastLoginTime(new Date());
                sysUserMapper.update(sysUser2);
                sysUserService.addCredits(sysUser2);
                System.out.println(sysUser2);
            }
        }
        return false;
    }

    @Override
    public SysUser getUserByUser(SysUser sysUser) {
        return sysUserMapper.getUserByUser(sysUser);
    }

    @Override
    public void addCredits(SysUser sysUser) {
        if (new Date().getDate() - sysUser.getLastLoginTime().getDate() > 0) {
            int credits = sysUser.getCredits();
            System.out.println("初始积分：" + credits);
            credits += 5;
            sysUser.setCredits(credits);
            sysUserMapper.addCredits(sysUser);
            System.out.println("当前积分：" + sysUser.getCredits());
        } else {
            System.out.println("今天已经登录过，不重复加分");
        }
    }

    @Override
    public void loadMusic(SysUser sysUser) {
        int credits = sysUser.getCredits();
        if(credits>100){
            System.out.println("批量下载");
        }else if(credits>50){
            System.out.println("单个下载");
        }else {
            System.out.println("不可下载");
        }
    }

    @Override
    public SysUser selectById(int id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public void insert(SysUser sysUser) {
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //生成随机盐
        MD5Util md5Util = new MD5Util();
        String passwordSalt = md5Util.generate(sysUser.getPassword());
        sysUser.setSalt(passwordSalt);
        sysUserMapper.insert(sysUser);
        System.out.println(sysUser.getId());
    }

    @Override
    public void update(SysUser sysUser) {
        sysUserMapper.update(sysUser);
    }

}