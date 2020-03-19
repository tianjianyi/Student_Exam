package com.yifeng.service;

import com.yifeng.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll(int page, int size);

    void insertCourse(String studentId, Integer id);

    void updateCourseNum(Integer id, int num);

    List<String> selectStudentByCourseId(Integer id);

    void delSelectCourse(String studentId, Integer id);

    void save(Student student);

    Student selectStudentByStudentId(String studentId);

    void updateStudentByStudentId(Student student);

    void deleteStudent(String id);
}
