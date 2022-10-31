package liga.medical.personservice.core.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RolesUserMapper {

    @Insert("INSERT INTO users_roles (user_id, role_id) VALUES (#{user_id}, #{role_id})")
    void save(@Param("user_id") Long userId, @Param("role_id") Long roleId);

}
