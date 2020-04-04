package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Collect;
import com.soft1851.spring.mybatis.entity.Music;
import com.soft1851.spring.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/2 11:27
 * @Version 1.0
 **/
public interface CollectMapper {
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
     * 取消收藏
     * @param collects
     * @return
     */
    int batchDelete(@Param("collects") List<Collect> collects);

    /**
     * 添加收藏
     * @param collects
     * @return
     */
    int batchInsert(@Param("collects") List<Collect> collects);
}
