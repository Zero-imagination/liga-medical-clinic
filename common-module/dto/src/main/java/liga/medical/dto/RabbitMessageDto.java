package liga.medical.dto;

import liga.medical.utils.MessageType;
import lombok.Data;

@Data
public class RabbitMessageDto {
    private Long id;
    private MessageType type;
    private String description;

}
