package com.cmk.dao;


import com.cmk.bean.Student;

import java.util.List;

/**
 * 一对多
 */
public interface StudentMapper {

    List<Student> getStudent();
    List<Student> getStudentList();
    List<Student> getStudentList2();
}
