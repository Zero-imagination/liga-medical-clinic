package liga.medical.personservice.core.repository;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.core.model.Contact;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ContactMapper extends IRepository<Contact> {

    @Select("SELECT id, phone_number as phoneNumber, email, profile_link as profileLink FROM contact;")
    List<Contact> getAll();

    @Select("SELECT id, phone_number as phoneNumber, email, profile_link as profileLink FROM contact WHERE id = #{contactID}")
    Contact getById(@Param("contactID") long contactID);

    @Insert("INSERT INTO contact (id, phone_number, email, profile_link) VALUES (#{id}, #{phoneNumber}, #{email}, #{profileLink})")
    int insert(Contact contact);

}
