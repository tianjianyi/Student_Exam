package com.yifeng.service.impl;

import com.github.pagehelper.PageHelper;
import com.yifeng.dao.StudentDao;
import com.yifeng.domain.Student;
import com.yifeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll(int page, int size) {
        //System.out.println(page+"  " + size);

        //System.out.println("---------------------");
        //List<Student> list = studentDao.findAll();
        //System.out.println("--------------");
        //System.out.println(list);
        PageHelper.startPage(page, size);
        return studentDao.findAll();
    }

    @Override
    public void insertCourse(String studentId, Integer id) {
       // System.out.println(studentId+" ** " + id);
        String aid = studentId;
        studentDao.insertCourse(studentId, id);
    }

    @Override
    public void updateCourseNum(Integer id, int num) {
        studentDao.updateCourseNum(id, num);
    }

    @Override
    public List<String> selectStudentByCourseId(Integer id) {
        return studentDao.selectStudentByCourseId(id);
    }

    @Override
    public void delSelectCourse(String studentId, Integer id) {
        studentDao.delSelectCourse(studentId, id);
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student selectStudentByStudentId(String studentId) {
        return studentDao.selectStudentByStudentId(studentId);
    }

    @Override
    public void updateStudentByStudentId(Student student) {
        studentDao.updateStudentByStudentId(student);
    }

    @Override
    public void deleteStudent(String id) {
        studentDao.deleteStudent(id);
    }
}
