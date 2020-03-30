package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Hero;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 16:22
 * @Version 1.0
 **/
public interface HeroDao {
    /**
     * 查询所有
     *
     * @return
     */
    List<Hero> selectAll();

    /**
     * 批量插入
     * @return
     */
    int[] batchInsert(List<Hero> heroes);

}
