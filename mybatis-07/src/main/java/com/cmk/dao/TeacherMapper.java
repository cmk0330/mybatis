package com.cmk.dao;

import com.cmk.bean.Student;
import com.cmk.bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

//    @Select("select * from teacher where id = #{id}")
//    Teacher getTeacher(@Param("id") int id);

    // 获取老师
    List<Teacher> getTeacher();

    // 获取老师下的学生
    @Select("select * from teacher t, student s where t.id = s.tid")
    List<Student> getTeacherOnStudent(@Param("id") int id);

    Teacher getTeacherStudent(int tid);
    Teacher getTeacherStudent2(int tid);
}
