package liga.medical.personservice.core.repository;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper extends IRepository<Address> {
    @Select("SELECT id, contact_id as contactId, country_id as countryId, city, index, street, building, flat FROM address;")
    List<Address> getAll();

    @Select("SELECT id, contact_id as contactId, country_id as countryId, city, index, street, building, flat FROM address WHERE id = #{addressID}")
    Address getById(@Param("addressID") long addressID);

    @Insert("INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) VALUES (#{id}, #{contactId}," +
            " #{countryId}, #{city}, #{index}, #{street}, #{building}, #{flat})")
    int insert(Address address);
}