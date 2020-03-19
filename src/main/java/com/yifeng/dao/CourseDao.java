package com.yifeng.dao;

import com.yifeng.domain.Course;
import com.yifeng.domain.Scourse;
import com.yifeng.domain.Teacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao {

    @Select("select * from course")
    List<Course> findAll();

    @Select("select * from course where id = #{id}")
    Course findCourseById(Integer id);

    @Select("select * from course where id in (select id from selectedcourse where studentId=#{studentId})")
    List<Course> alreadySelect(String studentId);
    @Select("SELECT * from (select c.id, c.name, c.courseId, c.teachername,c.room, s.mark from course c, selectedcourse s where c.id = s.id) a where a.id in (select id from selectedcourse where studentId=#{studentId})")
    List<Course> findCourseMark(String studentId);

    @Select("select * from course where teacherId = #{teacherId}")
    Course findCourseTeacherId(String teacherId);

    @Update("update selectedcourse set mark = #{mark} where studentId =#{studentId} and id = #{id}")
    void updateMark(@Param("id") Integer id, @Param("studentId") String studentId, @Param("mark") Integer mark);

    @Insert("insert into course (courseId,name,teachername,num,room,teacherId) values(#{courseId},#{name},#{teachername},#{num},#{room},#{teacherId})")
    void save(Course course);

    @Select("select * from course where id = #{id}")
    Course selectCourseByid(Integer id);

    @Select("update course set courseId = #{courseId} ,name = #{name},teachername = #{teachername},num=#{num},room= #{room},teacherId=#{teacherId} where id = #{id}")
    void updateCourseById(Course course);

    @Delete("delete from course where id = #{id}")
    void deleteCourse(Integer id);
}
