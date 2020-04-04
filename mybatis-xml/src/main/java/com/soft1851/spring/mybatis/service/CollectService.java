package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Collect;
import com.soft1851.spring.mybatis.entity.Music;
import com.soft1851.spring.mybatis.entity.SysUser;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/2 9:36
 * @Version 1.0
 **/
public interface CollectService {
    /**
     * 根据歌曲查用户
     * @return
     */
    List<SysUser> getUserByMusic(Music music);

    /**
     * 根据用户查歌曲
     *
     * @param sysUser
     * @return
     */
    List<Music> getMusicByUser(SysUser sysUser);

    /**
     * 批量收藏
     * @param collects
     * @return
     */
    int batchInsert(List<Collect> collects);

    /**
     * 批量取消收藏
     * @param collects
     * @return
     */
    int batchDelete(List<Collect> collects);
}
