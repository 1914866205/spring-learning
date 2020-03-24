package com.soft1851.spring.orm.entity;

import java.util.List;

public class Student {

    private String name;
    private String id;
    private List<Phone> list;

    public Student() {
    }

    @Override
    public String toString() {
        return "StudentfFirst{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Phone> getList() {
        return list;
    }

    public void setList(List<Phone> list) {
        this.list = list;
    }
}
