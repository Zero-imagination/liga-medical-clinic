package liga.medical.dto;

import liga.medical.utils.MessageType;
import lombok.Data;

@Data
public class MessageDto {
    MessageType messageType;
    String content;
}
