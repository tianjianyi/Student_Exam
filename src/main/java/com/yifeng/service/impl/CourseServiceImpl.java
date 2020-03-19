package com.yifeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.yifeng.dao.CourseDao;
import com.yifeng.dao.StudentDao;
import com.yifeng.domain.Course;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;
import com.yifeng.service.CourseService;
import com.yifeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Override
    public List<Course> findAll(int page, int size) {
        //System.out.println(page+"  " + size);

        //System.out.println("---------------------");
        //List<Student> list = studentDao.findAll();
        //System.out.println("--------------");
        //System.out.println(list);
        PageHelper.startPage(page, size);
        return courseDao.findAll();
    }

    public Course findCourseById(Integer id){
        return courseDao.findCourseById(id);
    }

    @Override
    public List<Course> alreadySelect(int page, int size, String studentId) {
        PageHelper.startPage(page, size);
        return courseDao.alreadySelect(studentId);
    }

    @Override
    public List<Course> findCourseMark(int page, int size, String studentId) {
        PageHelper.startPage(page, size);
        return courseDao.findCourseMark(studentId);
    }

    @Override
    public Course findCourseTeacherId(String teacherId) {
        return courseDao.findCourseTeacherId(teacherId);
    }

    @Override
    public void updateMark(Integer id, String studentId, Integer mark) {
        courseDao.updateMark(id, studentId, mark);
    }

    @Override
    public void save(Course course) {
        courseDao.save(course);
    }

    @Override
    public Course selectCourseByid(Integer id) {
        return courseDao.selectCourseByid(id);
    }

    @Override
    public void updateCourseById(Course course) {
        courseDao.updateCourseById(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        courseDao.deleteCourse(id);
    }
}
