package com.yifeng.domain;

public class Scourse {
    private Integer id;
    private String courseId;
    private String name;
    private String studentId;
    private String major;
    private String clazz;
    private Integer mark;

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Scourse{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", major='" + major + '\'' +
                ", clazz='" + clazz + '\'' +
                ", mark=" + mark +
                '}';
    }
}
