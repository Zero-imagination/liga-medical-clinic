package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class MedicalCard {

    private long id;

    private String clientStatus;

    private String medStatus;

    private java.sql.Date registryDt;

    private String comment;

}