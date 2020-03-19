package com.yifeng.domain;

public class Teacher {

    private Integer id;
    private String teacherId;
    private String name;
    private String college;
    private String tie;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getTie() {
        return tie;
    }

    public void setTie(String tie) {
        this.tie = tie;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", college='" + college + '\'' +
                ", tie='" + tie + '\'' +
                '}';
    }
}
