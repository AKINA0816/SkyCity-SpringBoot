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

    @Insert("insert into t_user (name) values (#{name})")
    public int insert(User user);
}
