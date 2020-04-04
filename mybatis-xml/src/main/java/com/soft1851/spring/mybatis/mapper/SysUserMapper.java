package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.SysUser;

/**
 * @Description TODO
 * @Author 涛涛
 * @Date 2020/4/2 9:59
 * @Version 1.0
 **/
public interface SysUserMapper {

    /**
     * 用户登录
     * @param sysUser
     * @return
     */
    boolean login(SysUser sysUser);
    /**
     * 根据用户数据查用户信息
     * @return
     */
    SysUser getUserByUser(SysUser sysUser);

    /**
     * 添加积分
     * @return
     */
    void addCredits(SysUser sysUser);

    /**
     * 根据
     * @param id
     * @return
     */
    SysUser selectById(int id);

    /**
     * 注册
     * @param sysUser
     * @return
     */
    void insert(SysUser sysUser);

    /**
     * 修改
     * @param sysUser
     */
    void update(SysUser sysUser);

}
