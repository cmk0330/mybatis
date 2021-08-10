import cmk.bean.User;
import cmk.dao.UserDao;
import cmk.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {


    @Test
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        List<User> userList = mapper.getUserList();
        Map<String, Integer> map = new HashMap<>();
        map.put("pageIndex", 0);
        map.put("pageSize", 2);
        List<User> userList = mapper.limitUserList(map);
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
