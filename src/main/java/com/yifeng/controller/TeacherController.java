package com.yifeng.controller;

import com.github.pagehelper.PageInfo;
import com.yifeng.domain.Course;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Student;
import com.yifeng.domain.Teacher;
import com.yifeng.service.CourseService;
import com.yifeng.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){
        ModelAndView mv = new ModelAndView();

        List<Teacher> ordersList = teacherService.findAll(page, size);

        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/teacher-list");
        return mv;
    }

    @RequestMapping("/findSelectStudent.do")
    public ModelAndView findSelectStudent(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){

        ModelAndView mv = new ModelAndView();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String teacherId = userDetails.getUsername();
        Course course = courseService.findCourseTeacherId(teacherId);
        //System.out.println(course.getId());
        List<Scourse> ordersList = teacherService.findSelectStudent(page, size, course.getId());
        //System.out.println(ordersList);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("teacher/selectStudent");
        return mv;
    }

    @RequestMapping("/findGrade.do")
    public ModelAndView findGrade (@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){

        ModelAndView mv = new ModelAndView();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String teacherId = userDetails.getUsername();
        Course course = courseService.findCourseTeacherId(teacherId);
        //System.out.println(course.getId());
        List<Scourse> ordersList = teacherService.findSelectStudent(page, size, course.getId());
        //System.out.println(ordersList);
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("teacher/studentGrate");
        return mv;
    }
    @RequestMapping("/putGrate.do")
    public String putGrate(Scourse scourse){
       // System.out.println(scourse);
        courseService.updateMark(scourse.getId(), scourse.getStudentId(),scourse.getMark());
        return "redirect:findGrade.do";
    }
    @RequestMapping("/save.do")
    public String save(Teacher teacher){
        //System.out.println(student);
        teacherService.save(teacher);
        return "redirect:findAll.do";
    }
    @RequestMapping("/exitTeacher.do")
    public ModelAndView exitTeacher(String teacherId){
        ModelAndView mv = new ModelAndView();
        //System.out.println(studentId);
        Teacher teacher = teacherService.selectStudentByStudentId(teacherId);
        //System.out.println(teacher);
        mv.addObject("teacher", teacher);
        mv.setViewName("admin/exitTeacher");
        return mv;
    }
    @RequestMapping("/updateTeacher.do")
    public String updateTeacher(Teacher teacher){
        //System.out.println(student);
        teacherService.updateTeacherByTeacherId(teacher);
        return "redirect:findAll.do";
    }

    @RequestMapping("/deleteTeacher.do")
    public String deleteTeacher(String id){
        teacherService.deleteStudent(id);
        return "redirect:findAll.do";
    }

}
