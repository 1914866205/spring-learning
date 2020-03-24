package com.soft1851.spring.orm.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grade {
    private String name;
    private List<Student> listGrade;
    private Set<Student> setGrade;
    private Map<String,Student> mapGrade;

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "name='" + name + '\'' +
                ", listGrade=" + listGrade +
                ", setGrade=" + setGrade +
                ", mapGrade=" + mapGrade +
                '}';
    }

    public Set<Student> getSetGrade() {
        return setGrade;
    }

    public void setSetGrade(Set<Student> setGrade) {
        this.setGrade = setGrade;
    }

    public Map<String, Student> getMapGrade() {
        return mapGrade;
    }

    public void setMapGrade(Map<String, Student> mapGrade) {
        this.mapGrade = mapGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getListGrade() {
        return listGrade;
    }

    public void setListGrade(List<Student> listGrade) {
        this.listGrade = listGrade;
    }

    public Grade(List<Student> listGrade) {
        this.listGrade = listGrade;
    }
}
