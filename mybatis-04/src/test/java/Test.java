import cmk.bean.User;
import cmk.dao.UserMapper;
import cmk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {

    @org.junit.Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @org.junit.Test
    public void test1() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @org.junit.Test
    public void add() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(7, "周芷若", "123123"));
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void update() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.upData(new User(7, "巴卡尔", "aaaaa"));
        sqlSession.commit();
        sqlSession.close();
    }

    @org.junit.Test
    public void delete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(7);
        sqlSession.commit();
        sqlSession.close();
    }
}
