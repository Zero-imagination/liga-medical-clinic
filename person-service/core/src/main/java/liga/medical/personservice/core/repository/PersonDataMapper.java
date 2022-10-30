package liga.medical.personservice.core.repository;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.core.model.PersonData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonDataMapper extends IRepository<PersonData> {

    @Results(id = "personDataResult", value = {
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "birthDt", column = "birth_dt"),
            @Result(property = "contactId", column = "contact_id"),
            @Result(property = "medicalCardId", column = "medical_card_id"),
            @Result(property = "parentId", column = "parent_id")
    })
    @Select("SELECT * FROM person_data;")
    List<PersonData> getAll();

    @Select("SELECT * FROM person_data WHERE id = #{dataID};")
    @ResultMap("personDataResult")
    PersonData getById(@Param("dataID") long id);

    @Insert("INSERT INTO person_data VALUES (#{id}, #{lastName}, #{firstName}, #{birthDt}, #{age}, #{sex}, #{contactId}, #{medicalCardId}, #{parentId});")
    int insert(PersonData personData);

}
