package tv.skycity.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tv.skycity.model.User;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    public List<User> getAll();

    @Insert("insert into t_user (name,password) values (#{name},#{password})")
    public void addUser(User user);

    @Select("select name from t_user where name = #{name}")
    public User selectByName(User user);

    @Select("select name,password from t_user where name = #{name} and password = #{password}")
    public User selectByNameAndPassword(User user);
}
