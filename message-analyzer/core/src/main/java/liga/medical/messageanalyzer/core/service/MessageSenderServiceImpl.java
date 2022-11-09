package liga.medical.messageanalyzer.core.service;

import liga.medical.dto.RabbitMessageDto;
import liga.medical.messageanalyzer.core.api.MessageSenderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper;

    public MessageSenderServiceImpl(AmqpTemplate amqpTemplate, ObjectMapper objectMapper) {
        this.amqpTemplate = amqpTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessage(RabbitMessageDto rabbitMessageDto, String queue) throws JsonProcessingException {
        String messageStr = objectMapper.writeValueAsString(rabbitMessageDto);
        amqpTemplate.convertAndSend(queue, messageStr);
        //System.out.printf("Сообщение " + messageStr + " в очередь " + queue + " отправлено!%n");
    }
}
