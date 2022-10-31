package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Role;
import liga.medical.personservice.core.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE login = #{login};")
    @Results(value = {
            @Result(property = "login", column = "login"),
            @Result(property = "roles", javaType = Set.class, many = @Many(select = "liga.medical.personservice.core.repository.UserMapper.getRoles"), column = "login")
    })
    User getUserByUsername(@Param("login") String login);

    @Insert("INSERT INTO users (login, password) VALUES (#{login}, #{password});")
    void save(User user);

    @Select("SELECT r.id as id, role FROM users JOIN users_roles ur on users.id = ur.user_id JOIN roles r on r.id = ur.role_id WHERE users.login = #{userName};")
    Set<Role> getRoles(@Param("userName") String login);

    @Select("SELECT * FROM users;")
    List<User> findAll();

}
