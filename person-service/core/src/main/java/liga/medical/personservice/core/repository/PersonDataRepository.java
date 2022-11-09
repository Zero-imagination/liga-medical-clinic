package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.entity.PersonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDataRepository extends JpaRepository<PersonData, Long> {
    @Query("select p from PersonData p where p.firstName = :name")
    PersonData findByName(@Param("name") String name);
}
