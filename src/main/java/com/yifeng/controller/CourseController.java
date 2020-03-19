package com.yifeng.controller;

import com.github.pagehelper.PageInfo;
import com.yifeng.domain.Course;
import com.yifeng.domain.Teacher;
import com.yifeng.service.CourseService;
import com.yifeng.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){
        ModelAndView mv = new ModelAndView();

        List<Course> ordersList = courseService.findAll(page, size);

        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/course-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Course course){
        //System.out.println(student);
        courseService.save(course);
        return "redirect:findAll.do";
    }
    @RequestMapping("/exitCourse.do")
    public ModelAndView exitCourse(Integer id){
        ModelAndView mv = new ModelAndView();
        //System.out.println(id);
        Course course = courseService.selectCourseByid(id);
        mv.addObject("course", course);
        mv.setViewName("admin/exitCourse");
        return mv;
    }
    @RequestMapping("/updateCourse.do")
    public String updateStudent(Course course){
        //System.out.println(course);
        courseService.updateCourseById(course);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteCourse.do")
    public String deleteCourse(Integer id){
        courseService.deleteCourse(id);
        return "redirect:findAll.do";
    }

}
