package cmk.dao;

import cmk.bean.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int upData(User user);

    int delete(int id);
}
