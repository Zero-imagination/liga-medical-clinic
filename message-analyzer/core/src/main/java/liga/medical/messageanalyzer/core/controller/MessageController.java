package liga.medical.messageanalyzer.core.controller;

import liga.medical.dto.RabbitMessageDto;
import liga.medical.messageanalyzer.core.api.MessageSenderService;
import liga.medical.messageanalyzer.core.config.RabbitConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageSenderService messageSenderService;

    public MessageController(MessageSenderService messageSenderService) {
        this.messageSenderService = messageSenderService;
    }

    @PostMapping
    ResponseEntity<String> sendMessage(@RequestBody RabbitMessageDto message) throws JsonProcessingException {
        messageSenderService.sendMessage(message, RabbitConfig.QUEUE_NAME);
        return ResponseEntity.ok(message.toString());
    }

}
