package com.soft1851.spring.web.service;

import com.soft1851.spring.web.Spider.LOLSpider;
import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class HeroServiceTest {

    @Resource
    private HeroService heroService;
    @Test
    public void queryAll() {
        List<Hero> heroList = heroService.queryAll();
        for (Hero hero : heroList) {
            System.out.println(hero);
        }
    }

    @Test
    public void batchInsert() throws IOException {
        int[] ints = heroService.batchInsert(LOLSpider.getHeros());
        System.out.println(ints);
    }
}