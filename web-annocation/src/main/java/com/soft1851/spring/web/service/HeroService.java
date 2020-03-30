package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Hero;

import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 16:31
 * @Version 1.0
 **/
public interface HeroService {
    List<Hero> queryAll();

    int[] batchInsert(List<Hero> heroList);
}
