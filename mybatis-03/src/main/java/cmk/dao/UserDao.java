package cmk.dao;

import cmk.bean.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> getUserList();

    List<User> limitUserList(Map<String, Integer> map);

    User getUserById(int id);

    int addUser(User user);

    int upData(User user);

    int delete(int id);
}
