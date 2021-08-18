import cmk.bean.User;
import cmk.dao.UserDao;
import cmk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {


    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void testList() {
        Map<String, String >  map = new HashMap<>();
        map.put("1", "aaaa");
        map.put("2", "bbbb");
        map.put("3", "cccc");
        ArrayList<String> strings = new ArrayList<>(map.keySet());
        System.out.println(strings);
    }
}
