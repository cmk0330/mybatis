package cmk.dao;

import cmk.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

    List<User> limitUserList(Map<String, Integer> map);

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pass) values (#{id},#{name},#{pass})")
    int addUser(User user);

    @Update("update user set name=#{name},pass=#{pass} where id=#{id}")
    int upData(User user);

    @Delete("delete from user where id=#{id}")
    int delete(@Param("id") int id);
}
