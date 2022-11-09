package liga.medical.medicalmonitoring.core.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import liga.medical.dto.RabbitMessageDto;

public interface MessageSenderService {
    void sendMessage(RabbitMessageDto rabbitMessageDto, String queue) throws JsonProcessingException;

    void sendError(String message);
}
