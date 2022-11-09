package liga.medical.medicalmonitoring.core.listener;

import liga.medical.medicalmonitoring.core.api.MessageRouterService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import liga.medical.utils.QueueNames;

@Service
public class MessageRouterListener {
    private final MessageRouterService messageRouterService;

    public MessageRouterListener(MessageRouterService messageRouterService) {
        this.messageRouterService = messageRouterService;
    }

    @RabbitListener(queues = QueueNames.ROUTER_QUEUE_NAME)
    public void getAndRouteMessage(String message) {
        messageRouterService.routeMessage(message);
    }
}
