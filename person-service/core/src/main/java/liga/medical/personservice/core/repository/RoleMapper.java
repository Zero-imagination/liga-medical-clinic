package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface RoleMapper {

    @Select(value = "SELECT * FROM roles WHERE role = #{roleName};")
    Role findByName(@Param("roleName") String roleName);

    @Select("SELECT * FROM roles")
    Set<Role> getAll();
}
