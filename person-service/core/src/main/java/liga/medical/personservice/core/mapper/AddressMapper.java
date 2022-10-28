package liga.medical.personservice.core.mapper;

import liga.medical.personservice.core.model.Address;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper {
    @Select("SELECT id, contact_id as contactId, country_id as countryId, city, index, street, building, flat " +
            "FROM address;")
    List<Address> getListAddress();

    @Insert("INSERT INTO address (id, contact_id, country_id, city, index, street, building, flat) " +
            "VALUES (#{id}, #{contactId}, #{countryId}, #{city}, #{index}, #{street}, #{building}, #{flat})")
    Address addAddress(Address address);
}
