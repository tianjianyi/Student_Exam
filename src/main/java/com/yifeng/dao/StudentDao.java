package com.yifeng.dao;

import com.yifeng.domain.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {

    @Select("select * from student")
    List<Student> findAll();

    @Insert("insert into selectedcourse(studentId,id) values(#{studentId},#{id})")
    void insertCourse(@Param("studentId") String studentId, @Param("id") Integer id);

    @Update("update course set num = #{num} where id = #{id}")
    void updateCourseNum(@Param("id") Integer id, @Param("num") int num);

    @Select("select studentId from selectedcourse where id = #{id}")
    List<String> selectStudentByCourseId(Integer id);

    @Delete("delete from selectedcourse where studentId = #{studentId} and id = #{id}")
    void delSelectCourse(@Param("studentId") String studentId, @Param("id") Integer id);

    @Insert("insert into student (studentId, name, major, clazz) values(#{studentId}, #{name}, #{major}, #{clazz})")
    void save(Student student);

    @Select("select * from student where studentId = #{studentId}")
    Student selectStudentByStudentId(String studentId);

    @Select("update student set name = #{name}, major = #{major}, clazz = #{clazz} where studentId = #{studentId}")
    void updateStudentByStudentId(Student student);

    @Delete("delete from student where studentId = #{id}")
    void deleteStudent(String id);
}
