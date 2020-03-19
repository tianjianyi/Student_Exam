package com.yifeng.service;

import com.yifeng.domain.Course;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;

import java.util.List;

public interface CourseService {
    List<Course> findAll(int page, int size);
    public Course findCourseById(Integer id);

    List<Course> alreadySelect(int page, int size, String studentId);

    List<Course> findCourseMark(int page, int size, String studentId);

    Course findCourseTeacherId(String teacherId);

    void updateMark(Integer id, String studentId, Integer mark);

    void save(Course course);

    Course selectCourseByid(Integer id);

    void updateCourseById(Course course);

    void deleteCourse(Integer id);
}
