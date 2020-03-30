package com.soft1851.spring.web.service.Impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/27 10:35
 * @Version 1.0
 **/

/**
 * @Transactional表示本类启动了事务，发生异常后回滚
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDao topicDao;
    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
        try {
            int a = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        for (Topic t:topics) {
            System.out.println(t);
        }
        return topicDao.batchInsert(topics);
    }
}
