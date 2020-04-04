package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-02 09:50:20
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = -80306965918667020L;
    /**
    * 主键
    */
    private Integer id;
    
    private String userName;
    
    private String password;
    
    private String salt;
    
    private String email;
    
    private String phoneNumber;
    
    private Integer status;
    
    private Integer binding;
    
    private Integer credits;
    
    private Date createTime;
    
    private Date lastLoginTime;


}