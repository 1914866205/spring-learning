package com.soft1851.spring.mybatis.service.impl;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.MatterDto;
import com.soft1851.spring.mybatis.entity.Teacher;
import com.soft1851.spring.mybatis.mapper.ClazzMapper;
import com.soft1851.spring.mybatis.service.ClazzService;
import com.soft1851.spring.mybatis.vo.ClazzVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/3/31 19:43
 * @Version 1.0
 **/
@Service
public class ClazzServiceImpl implements ClazzService {
    @Resource
    private ClazzMapper clazzMapper;
    @Override
    public List<ClazzVo> getClazzStudent(int clazzId) {
        return clazzMapper.getClazzStudent(clazzId);
    }

    @Override
    public List<ClazzVo> getClazzTeacher(int clazzId) {
        return clazzMapper.getClazzTeacher(clazzId);
    }

    @Override
    public List<Map<String, Object>> getClazzStudent1(int id) {
        return clazzMapper.getClazzStudent1(id);
    }

    @Override
    public List<Teacher> selectLimitFromTeacherInClassByDynamicSql(MatterDto matterDto) {
        return clazzMapper.selectLimitFromTeacherInClassByDynamicSql(matterDto);
    }

    @Override
    public Teacher getTeacherOneToOne(int clazzId) {
        return clazzMapper.getTeacherOneToOne(clazzId);
    }

    @Override
    public Clazz getClazzOneToMany(int clazzId) {
        return clazzMapper.getClazzOneToMany(clazzId);
    }
}
