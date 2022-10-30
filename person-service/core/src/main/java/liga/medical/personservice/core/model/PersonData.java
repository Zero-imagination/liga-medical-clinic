package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class PersonData {

    private long id;

    private String lastName;

    private String firstName;

    private java.sql.Date birthDt;

    private long age;

    private String sex;

    private long contactId;

    private long medicalCardId;

    private long parentId;

}