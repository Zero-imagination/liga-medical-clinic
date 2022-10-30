package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class Contact {

    private long id;

    private String phoneNumber;

    private String email;

    private String profileLink;

}