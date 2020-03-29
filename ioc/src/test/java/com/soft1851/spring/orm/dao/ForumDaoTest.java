package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Forum;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"/beans.xml"})

public class ForumDaoTest {
//    @Autowired
    private ForumDao forumDao;
    @Before
//    public void init(){
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JDBCConfig.class);
//        ctx.scan("com.soft1851.spring.ioc.config");
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
//        System.out.println(jdbcTemplate);
//         forumDao = (ForumDao) ctx.getBean("forumDao");
//    }
    @Test
    public void insert() {
        Forum forum=Forum.builder().forumName("测试论坛").build();
        int count = forumDao.insert(forum);
        System.out.println(count);
    }

    @Test
    public void batchInsert(){
        Forum[] forums = {Forum.builder().forumName("测试论坛1").build(),
                Forum.builder().forumName("测试论坛2").build(),
                Forum.builder().forumName("测试论坛3").build()
        };
        List<Forum> forumList = Arrays.asList(forums);
        int[] rows = forumDao.batchInsert(forumList);
        System.out.println("row"+rows);
    }


    @Test
    public void update(){
        Forum forum=forumDao.get(7);
        forum.setForumName("测试论坛修改的新名称");
        int n = forumDao.update(forum);
        System.out.println("n"+n);
    }

    @Test
    public void get(){
        Forum forum=forumDao.get(7);
        System.out.println(forum);
    }

    @Test
    public void selectAll(){
        List<Forum> forums = forumDao.selectAll();
        for (Forum forum:forums) {
            System.out.println(forum);
        }
    }
}
