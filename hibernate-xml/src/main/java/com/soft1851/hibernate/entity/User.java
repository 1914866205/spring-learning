//package com.soft1851.hibernate.entity;
//
//import lombok.Builder;
//import lombok.Data;
//import org.hibernate.annotations.Entity;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * @Description TODO
// * @Author 涛涛
// * @Date 2020/4/1 9:25
// * @Version 1.0
// **/
//@Entity //标识该类是Hibernate的实体类，最好实现序列化
//@Table( name ="t_user")//正向工程的表名
//@Data
//@Builder
//public class User implements Serializable {
//
//    @Id  //声明属性为主键
//    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
//    @Column(name = "user_id")//数据库字段和类映射关系
//    private Integer userId;
//
//    @Column(name="user_name")
//    private String username;
//
//    @Column(name="age")
//    private Integer age;
//}
