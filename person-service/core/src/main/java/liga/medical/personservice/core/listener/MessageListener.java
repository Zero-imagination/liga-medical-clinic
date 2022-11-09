package liga.medical.personservice.core.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.RabbitMessageDto;
import liga.medical.personservice.core.entity.Signal;
import liga.medical.personservice.core.service.api.SignalService;
import liga.medical.utils.QueueNames;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    private final ObjectMapper objectMapper;

    private final SignalService signalService;

    public MessageListener(ObjectMapper objectMapper, SignalService signalService) {
        this.objectMapper = objectMapper;
        this.signalService = signalService;
    }

    @RabbitListener(queues = QueueNames.DAILY_QUEUE_NAME)
    public void listenDailyQueue(String message) {
        try {
            RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
            signalService.save(mapper(rabbitMessageDto));
            System.out.println("Сообщение: " + rabbitMessageDto + " получено из очереди " + QueueNames.DAILY_QUEUE_NAME);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RabbitListener(queues = QueueNames.ALERT_QUEUE_NAME)
    public void listenAlertQueue(String message) {
        try {
            RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
            signalService.save(mapper(rabbitMessageDto));
            System.out.println("Сообщение: " + rabbitMessageDto + " получено из очереди " + QueueNames.ALERT_QUEUE_NAME);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RabbitListener(queues = QueueNames.ERROR_QUEUE_NAME)
    public void listenErrorQueue(String message) {
        System.out.println("Сообщение: " + message + " получено из очереди " + QueueNames.ERROR_QUEUE_NAME);
    }

    private Signal mapper(RabbitMessageDto rabbitMessageDto) {
        Signal signal = new Signal();
        signal.setPersonDataId(rabbitMessageDto.getId());
        signal.setDescription(rabbitMessageDto.getDescription());
        signal.setType(rabbitMessageDto.getType().toString());
        return signal;
    }
}
