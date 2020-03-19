package com.yifeng.dao;

import com.yifeng.domain.Scourse;
import com.yifeng.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao {

    @Select("select * from teacher")
    List<Teacher> findAll();


    @Select("SELECT * from (SELECT a.mark,a.id, a.courseId,st.name, a.studentId,st.major,st.clazz from (SELECT s.mark,c.id,c.courseId,s.studentId from course c, selectedcourse s WHERE c.id = s.id) a, student st where a.studentId = st.studentId) b WHERE b.id = #{id}")
    List<Scourse> findSelectStudent(Integer id);

    @Insert("insert into teacher (teacherId, name, college, tie) values(#{teacherId}, #{name}, #{college}, #{tie})")
    void save(Teacher teacher);

    @Select("select * from teacher where teacherId = #{teacherId}")
    Teacher selectStudentByStudentId(String teacherId);

    @Update("update teacher set name = #{name}, college = #{college}, tie = #{tie} where teacherId = #{teacherId}")
    void updateTeacherByTeacherId(Teacher teacher);

    @Delete("delete from teacher where teacherId = #{id}")
    void deleteStudent(String id);
}
