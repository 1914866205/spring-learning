package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.HeroDao;
import com.soft1851.spring.web.entity.Hero;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/28 16:23
 * @Version 1.0
 **/
@Repository
public class HeroDaoImpl implements HeroDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public HeroDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Hero> selectAll() {
        String sql = "SELECT * FROM springtest.t_hero";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Hero.class));    }

    @Override
    public int[] batchInsert(List<Hero> heroes) {
        final List<Hero> heroList = heroes;
        String sql="INSERT INTO springtest.t_hero VALUES (?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, heroList.get(i).getName());
                preparedStatement.setString(2, heroes.get(i).getImg());
            }
            @Override
            public int getBatchSize() {
                return heroes.size();
            }
        });
    }
}
