package tv.skycity.mapper;

import org.apache.ibatis.annotations.*;
import tv.skycity.model.User;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    public List<User> getAll();

    @Insert("insert into t_user (name,password) values (#{name},#{password})")
    public void addUser(User user);

    @Delete("delete from t_user where id = #{id}")
    public void deleteUser(User user);

    @Update("update t_user set password = #{password} where name = #{name}")
    public int updateUserPassword(User user);

    @Select("select name from t_user where name = #{name}")
    public User selectByName(User user);

    @Select("select name,password from t_user where name = #{name} and password = #{password}")
    public User selectByNameAndPassword(User user);
}
