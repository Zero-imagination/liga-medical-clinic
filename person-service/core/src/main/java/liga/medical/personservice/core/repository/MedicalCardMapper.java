package liga.medical.personservice.core.repository;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.core.model.MedicalCard;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedicalCardMapper extends IRepository<MedicalCard> {

    @Select("SELECT id, client_status as clientStatus, med_status as medStatus, registry_dt as registryDt, comment FROM medical_card;")
    List<MedicalCard> getAll();

    @Select("SELECT id, client_status as clientStatus, med_status as medStatus, registry_dt as registryDt, comment FROM medical_card WHERE id = #{cardID};")
    MedicalCard getById(@Param("cardID") long id);

    @Insert("INSERT INTO medical_card (id, client_status, med_status, registry_dt, comment) VALUES (#{id}, #{clientStatus}, #{medStatus}, #{registryDt}, #{comment});")
    int insert(MedicalCard medicalCard);

}
