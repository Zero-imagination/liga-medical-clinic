package liga.medical.personservice.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address", schema = "medical")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "index", nullable = false)
    private Integer index;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "building", nullable = false, length = 32)
    private String building;

    @Column(name = "flat", nullable = false, length = 32)
    private String flat;

    @Column(name = "contact_id", nullable = false)
    private Long contactId;
}
