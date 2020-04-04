package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Collect;
import com.soft1851.spring.mybatis.entity.Music;
import com.soft1851.spring.mybatis.entity.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class CollectServiceTest {
    @Resource
    private CollectService collectService;
    @Test
    public void getUserByMusic() {
        System.out.println(collectService.getUserByMusic(Music.builder().id(1).build()));
    }

    @Test
    public void getMusicByUser() {
        System.out.println(collectService.getMusicByUser(SysUser.builder().id(1).build()));
    }

    @Test
    public void batchInsert(){
        List<Collect> collects = new ArrayList<>();
        collects.add(Collect.builder().userId(1).musicId(1).build());
        collects.add(Collect.builder().userId(1).musicId(2).build());
        collectService.batchInsert(collects);
    }

    @Test
    public void batchDelete(){
        List<Collect> collects = new ArrayList<>();
        collects.add(Collect.builder().userId(1).musicId(1).build());
        collects.add(Collect.builder().userId(1).musicId(2).build());
        collectService.batchDelete(collects);
    }
}