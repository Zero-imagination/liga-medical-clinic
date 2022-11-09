package liga.medical.dto;

import lombok.Data;

@Data
public class LogDto {
    private String uuid;
    private Long systemTypeId;
    private String methodParams;
}
