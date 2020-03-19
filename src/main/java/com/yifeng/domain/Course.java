package com.yifeng.domain;

public class Course {
    private Integer id;
    private String courseId;
    private String name;
    private String teachername;
    private Integer num;
    private String room;
    private Integer mark;
    private String teacherId;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

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

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", teachername='" + teachername + '\'' +
                ", num=" + num +
                ", room='" + room + '\'' +
                ", mark=" + mark +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
