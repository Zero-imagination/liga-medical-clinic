package liga.medical.medicalmonitoring.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.medicalmonitoring.core.api.MessageRouterService;
import liga.medical.medicalmonitoring.core.api.MessageSenderService;
import liga.medical.dto.RabbitMessageDto;
import liga.medical.utils.MessageType;
import liga.medical.utils.QueueNames;
import org.springframework.stereotype.Service;

@Service
public class MessageRouterServiceImpl implements MessageRouterService {
    private final ObjectMapper objectMapper;
    private final MessageSenderService messageSenderService;

    public MessageRouterServiceImpl(ObjectMapper objectMapper, MessageSenderService messageSenderService) {
        this.objectMapper = objectMapper;
        this.messageSenderService = messageSenderService;
    }

    @Override
    public void routeMessage(String message) {
        try {
            RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
            MessageType messageType = rabbitMessageDto.getType();
            switch (messageType) {
                case DAILY:
                    messageSenderService.sendMessage(rabbitMessageDto, QueueNames.DAILY_QUEUE_NAME);
                    break;
                case ALERT:
                    messageSenderService.sendMessage(rabbitMessageDto, QueueNames.ALERT_QUEUE_NAME);
                    break;
                case ERROR:
                    messageSenderService.sendMessage(rabbitMessageDto, QueueNames.ERROR_QUEUE_NAME);
                    break;
                default:
                    System.out.println("Cannot send message [" + rabbitMessageDto + "] to any queue");
            }
        } catch (Exception e) {
            messageSenderService.sendError(e.getMessage());
        }
    }
}