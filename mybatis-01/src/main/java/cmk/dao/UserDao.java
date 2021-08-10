package cmk.dao;

import cmk.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    List<User> getUserByLike(String name);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    int upData(User user);

    int delete(int id);
}
