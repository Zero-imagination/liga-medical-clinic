package liga.medical.personservice.core.repository;

import liga.medical.personservice.core.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c where c.email= :email")
    Contact findByEmail(@Param("email") String email);
}
