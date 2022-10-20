package liga.medical.medicalmonitoring.core.service;

import liga.medical.medicalmonitoring.core.api.MessageRouterService;
import liga.medical.medicalmonitoring.core.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageRouterListener {
    private final MessageRouterService messageRouterService;

    public MessageRouterListener(MessageRouterService messageRouterService) {
        this.messageRouterService = messageRouterService;
    }

    @RabbitListener(queues = RabbitConfig.ROUTER_QUEUE_NAME)
    public void getAndRouteMessage(String message) {
        messageRouterService.routeMessage(message);
    }
}
