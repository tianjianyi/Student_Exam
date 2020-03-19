package com.yifeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.yifeng.dao.TeacherDao;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Teacher;
import com.yifeng.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Override
    public List<Teacher> findAll(int page, int size) {
        //System.out.println(page+"  " + size);

        //System.out.println("---------------------");
        //List<Student> list = studentDao.findAll();
        //System.out.println("--------------");
        //System.out.println(list);
        PageHelper.startPage(page, size);
        return teacherDao.findAll();
    }

    @Override
    public List<Scourse> findSelectStudent(int page, int size, Integer id) {
        PageHelper.startPage(page, size);
        //System.out.println("$$$$$$$$$$$$");
        //System.out.println(teacherDao.findSelectStudent(id));
        return teacherDao.findSelectStudent(id);
    }

    @Override
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    public Teacher selectStudentByStudentId(String teacherId) {
        return teacherDao.selectStudentByStudentId(teacherId);
    }

    @Override
    public void updateTeacherByTeacherId(Teacher teacher) {
        teacherDao.updateTeacherByTeacherId(teacher);
    }

    @Override
    public void deleteStudent(String id) {
        teacherDao.deleteStudent(id);
    }
}
