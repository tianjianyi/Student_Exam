package com.yifeng.controller;

import com.github.pagehelper.PageInfo;
import com.yifeng.domain.Course;
import com.yifeng.domain.Student;
import com.yifeng.service.CourseService;
import com.yifeng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){
        ModelAndView mv = new ModelAndView();
        List<Student> ordersList = studentService.findAll(page, size);
       // System.out.println(ordersList);
        //PageInfo就是一个分页Bean
        //System.out.println("*************");
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("admin/student-list");
        return mv;
    }

    @RequestMapping("/selectCourse.do")
    public ModelAndView selectFindAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){
        ModelAndView mv = new ModelAndView();

        List<Course> ordersList = courseService.findAll(page, size);

        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("student/selectcourse");
        return mv;
    }

    @RequestMapping("/courseMark.do")
    public ModelAndView courseMark(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){

        ModelAndView mv = new ModelAndView();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String studentId = userDetails.getUsername();
        List<Course> ordersList = courseService.findCourseMark(page, size, studentId);

        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("student/courseMark");
        return mv;
    }

    @RequestMapping("/stuSelectedCourse.do")
    public String stuSelectedCourse(@RequestParam(name = "id") Integer id){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String studentId = userDetails.getUsername();
        //System.out.println(studentId+"  " +id);

        Course course = courseService.findCourseById(id);
        studentService.insertCourse(studentId, id);
        studentService.updateCourseNum(id, course.getNum() - 1);
        return "redirect:selectCourse.do";
    }

    @RequestMapping("/outCourse.do")
    public String outCourse(@RequestParam(name = "id") Integer id){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String studentId = userDetails.getUsername();
        Course course = courseService.findCourseById(id);
        studentService.delSelectCourse(studentId , id);
        studentService.updateCourseNum(id, course.getNum() + 1);
        return "redirect:alreadySelect.do";
    }

    @RequestMapping("/check.do")
    public @ResponseBody String check(Integer id){
        //System.out.println(id);
        Course course = courseService.findCourseById(id);
        //System.out.println("----------");
        if(course.getNum() <= 0) return "empty";
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String studentId = userDetails.getUsername();
        List<String> list = studentService.selectStudentByCourseId(id);
        //System.out.println("---------------");
        for(String str:list){
            System.out.println(str);
            if(studentId.equals(str)) return "NO";

        }
        return "OK";
    }

    @RequestMapping("/alreadySelect.do")
    public ModelAndView alreadySelect(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name = "size", required = true, defaultValue = "12") int size){
        ModelAndView mv = new ModelAndView();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String studentId = userDetails.getUsername();
        List<Course> ordersList = courseService.alreadySelect(page, size, studentId);

        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("student/alreadySelectCourse");

        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Student student){
        //System.out.println(student);
        studentService.save(student);
        return "redirect:findAll.do";
    }
    @RequestMapping("/exitStudent.do")
    public ModelAndView exitStudent(String studentId){
        ModelAndView mv = new ModelAndView();
        //System.out.println(studentId);
        Student student = studentService.selectStudentByStudentId(studentId);
        mv.addObject("student", student);
        mv.setViewName("admin/exitStudent");
        return mv;
    }
    @RequestMapping("/updateStudent.do")
    public String updateStudent(Student student){
        //System.out.println(student);
        studentService.updateStudentByStudentId(student);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteStudent.do")
    public String deleteStudent(String id){
        studentService.deleteStudent(id);
        return "redirect:findAll.do";
    }
}
