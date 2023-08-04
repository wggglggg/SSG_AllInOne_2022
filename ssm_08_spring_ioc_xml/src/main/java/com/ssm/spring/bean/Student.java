package com.ssm.spring.bean;

import java.util.Arrays;
import java.util.Map;

/**
 * ClassName: Student
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/3 19:05
 * @Version 1.0
 */
public class Student implements Person {
    private Integer sid;
    private String sname;
    private Integer age;
    private String gender;
    private Double Score;
    private String[] hobby;

    private Clazz clazz;

    private Map<Integer, Teacher> teacherMap;

    public Student() {
    }

    public Student(Integer sid, String sname, Integer age, String gender) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
    }

    public Student(Integer sid, String sname, Integer age, String gender, Double score, String[] hobby, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.age = age;
        this.gender = gender;
        Score = score;
        this.hobby = hobby;
        this.clazz = clazz;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double score) {
        Score = score;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Map<Integer, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<Integer, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", Score=" + Score +
                ", hobby=" + Arrays.toString(hobby) +
                ", clazz=" + clazz +
                ", teacherMap=" + teacherMap +
                '}';
    }
}
