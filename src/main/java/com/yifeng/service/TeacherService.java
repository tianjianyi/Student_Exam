package com.yifeng.service;

import com.yifeng.domain.Scourse;
import com.yifeng.domain.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll(int page, int size);

    List<Scourse> findSelectStudent(int page, int size, Integer id);

    void save(Teacher teacher);

    Teacher selectStudentByStudentId(String teacherId);

    void updateTeacherByTeacherId(Teacher teacher);

    void deleteStudent(String id);
}
