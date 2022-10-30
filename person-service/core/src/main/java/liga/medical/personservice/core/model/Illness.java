package liga.medical.personservice.core.model;

import lombok.Data;

@Data
public class Illness {

    private long id;

    private long medicalCardId;

    private long typeId;

    private String heaviness;

    private java.sql.Timestamp appearanceDttm;

    private java.sql.Date recoveryDt;

}
