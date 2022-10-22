package liga.medical.medicalmonitoring.core.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String DAILY_QUEUE_NAME = "daily_queue";

    public static final String ALERT_QUEUE_NAME = "alert_queue";

    public static final String ERROR_QUEUE_NAME = "error_queue";

    public static final String ROUTER_QUEUE_NAME = "common_monitoring";
    private static final String HOST = "rabbithost";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(HOST);
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean("routerQueue")
    public Queue getRouterQueue() {
        return new Queue(ROUTER_QUEUE_NAME);
    }

    @Bean("dailyQueue")
    public Queue getDailyQueue() {
        return new Queue(DAILY_QUEUE_NAME);
    }

    @Bean("alertQueue")
    public Queue getAlertQueue() {
        return new Queue(ALERT_QUEUE_NAME);
    }

    @Bean("errorQueue")
    public Queue getErrorQueue() {
        return new Queue(ERROR_QUEUE_NAME);
    }
}
