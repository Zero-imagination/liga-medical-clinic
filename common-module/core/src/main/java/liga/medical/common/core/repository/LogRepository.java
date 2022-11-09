package liga.medical.common.core.repository;

import liga.medical.common.core.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, String> {

    @Modifying
    @Query(value = "insert into medical_log.debug(uuid,system_type_id,method_params) " +
            "values (:uuid,:systemTypeId,:methodParams)", nativeQuery = true)
    void saveDebugLog(@Param("uuid") String uuid,
                      @Param("systemTypeId") Long systemTypeId,
                      @Param("methodParams") String methodParams);

    @Modifying
    @Query(value = "insert into medical_log.exception(uuid,system_type_id,method_params) " +
            "values (:uuid,:systemTypeId,:methodParams)", nativeQuery = true)
    void saveExceptionLog(@Param("uuid") String uuid,
                      @Param("systemTypeId") Long systemTypeId,
                      @Param("methodParams") String methodParams);
}
