package liga.medical.personservice.core.repository;

import liga.medical.personservice.api.repository.IRepository;
import liga.medical.personservice.core.model.Illness;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IllnessMapper extends IRepository<Illness> {

    @Select("SELECT id, medical_card_id as medicalCardId, type_id as typeId, heaviness, appearance_dttm as appearanceDttm, " +
            "recovery_dt as recoveryDt FROM illness;")
    List<Illness> getAll();

    @Select("SELECT id, medical_card_id as medicalCardId, type_id as typeId, heaviness, appearance_dttm as appearanceDttm, " +
            "recovery_dt as recoveryDt FROM illness WHERE id = #{illnessID}")
    Illness getById(@Param("illnessID") long illnessID);

    @Insert("INSERT INTO illness (id, medical_card_id, type_id, heaviness, appearance_dttm, recovery_dt) " +
            "VALUES (#{id}, #{medicalCardId}, #{typeId}, #{heaviness}, #{appearanceDttm}, #{recoveryDt})")
    int insert(Illness illness);

}
