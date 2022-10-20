package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.MessageDto;
import liga.medical.medicalmonitoring.core.api.MessageSenderService;
import liga.medical.medicalmonitoring.core.config.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public MessageSenderServiceImpl(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(MessageDto messageDto, String queue) throws JsonProcessingException {
        String messageStr = objectMapper.writeValueAsString(messageDto);
        amqpTemplate.convertAndSend(queue, messageStr);
        System.out.println("Сообщение " + messageStr + " добавлено в очередь " + queue);
    }

    @Override
    public void sendError(String message) {
        if (Objects.nonNull(message)){
            amqpTemplate.convertAndSend(RabbitConfig.ERROR_QUEUE_NAME, message);
        } else {
            amqpTemplate.convertAndSend(RabbitConfig.ERROR_QUEUE_NAME, "message is null");
        }
    }
}