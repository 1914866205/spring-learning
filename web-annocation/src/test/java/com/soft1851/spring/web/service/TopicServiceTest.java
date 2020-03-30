package com.soft1851.spring.web.service;

import com.soft1851.spring.web.Spider.JueJinSpider;
import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")//WebAppConfiguration注解类默认为webapp目录，，切换到这个目录
public class TopicServiceTest {
    @Resource
    private TopicService topicService;

    @Test
    public void queryAll() {
        List<Topic> topics = topicService.queryAll();
        for (Topic topic:topics){
            System.out.println(topic);
        }
//        assertEquals(3, topics.size());
    }

    @Test
    public void addTopic() {
    }

    @Test
    public void batchInsert() {
        int[] ints = topicService.batchInsert(JueJinSpider.getTopics());
        assertEquals(JueJinSpider.getTopics().size(), ints.length);
    }
}