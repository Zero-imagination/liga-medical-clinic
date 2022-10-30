package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class Address {

    private long id;

    private long contactId;

    private long countryId;

    private String city;

    private long index;

    private String street;

    private String building;

    private String flat;

}