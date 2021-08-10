import com.cmk.bean.Student;
import com.cmk.bean.Teacher;
import com.cmk.dao.StudentMapper;
import com.cmk.dao.TeacherMapper;
import com.cmk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @org.junit.Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudentList();
        studentList.forEach(System.out::println);
        sqlSession.close();
    }

    @org.junit.Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudentList2();
        studentList.forEach(System.out::println);
        sqlSession.close();
    }

    @org.junit.Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        studentList.forEach(System.out::println);
        sqlSession.close();
    }
}
