package com.soft1851.spring.ioc.entity;

import com.soft1851.spring.ioc.entity.Phone;

public class StudentfFirst {
    private String name;
    private Phone phone;

    public StudentfFirst() {
    }

    public StudentfFirst(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "StudentfFirst{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
