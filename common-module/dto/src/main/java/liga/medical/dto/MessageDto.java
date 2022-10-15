package liga.medical.dto;

import lombok.Data;

@Data
public class MessageDto {
    MessageType messageType;
    String content;
}
