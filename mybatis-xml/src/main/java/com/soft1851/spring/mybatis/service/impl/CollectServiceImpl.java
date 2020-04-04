package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Collect;
import com.soft1851.spring.mybatis.entity.Music;
import com.soft1851.spring.mybatis.entity.SysUser;
import com.soft1851.spring.mybatis.mapper.CollectMapper;
import com.soft1851.spring.mybatis.service.CollectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/2 9:39
 * @Version 1.0
 **/
@Service
public class CollectServiceImpl implements CollectService {
    @Resource
    private CollectMapper collectMapper;

    @Override
    public List<SysUser> getUserByMusic(Music music) {
        return collectMapper.getUserByMusic(music);
    }

    @Override
    public List<Music> getMusicByUser(SysUser sysUser) {
        return collectMapper.getMusicByUser(sysUser);
    }

    @Override
    public int batchInsert(List<Collect> collects) {
        return collectMapper.batchInsert(collects);
    }

    @Override
    public int batchDelete(List<Collect> collects) {
        return collectMapper.batchDelete(collects);
    }
}
