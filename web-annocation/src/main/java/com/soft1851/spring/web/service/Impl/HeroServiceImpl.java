package com.soft1851.spring.web.service.Impl;

import com.soft1851.spring.web.dao.HeroDao;
import com.soft1851.spring.web.entity.Hero;
import com.soft1851.spring.web.service.HeroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 16:31
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class HeroServiceImpl implements HeroService {
    @Resource
    private HeroDao heroDao;
    @Override
    public List<Hero> queryAll() {
        return heroDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Hero> heroList) {
        return heroDao.batchInsert(heroList);
    }
}
