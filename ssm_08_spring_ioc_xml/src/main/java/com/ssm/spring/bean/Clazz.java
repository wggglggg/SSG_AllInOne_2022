package com.ssm.spring.bean;

import java.util.List;

/**
 * ClassName: Clazz
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 20:24
 * @Version 1.0
 */
public class Clazz {
    private Integer clazzId;
    private String clazzName;

    private List<Student> studentList;

    public Clazz() {
    }

    public Clazz(Integer clazzId, String clazzName) {
        this.clazzId = clazzId;
        this.clazzName = clazzName;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzId=" + clazzId +
                ", clazzName='" + clazzName + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
