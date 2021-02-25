package social.app.shared.infrastructure.bus.event.rabbitmq;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import social.app.shared.domain.Service;

@Service
public class RabbitMqConsumerAutoStarter implements ApplicationListener {
    private final RabbitMqDomainEventsConsumer rabbitMqDomainEventsConsumer;

    public RabbitMqConsumerAutoStarter(RabbitMqDomainEventsConsumer rabbitMqDomainEventsConsumer) {
        this.rabbitMqDomainEventsConsumer = rabbitMqDomainEventsConsumer;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent) {
            rabbitMqDomainEventsConsumer.consume();
            System.out.println("RabbitMQ consumer has been started.");
        }
    }
}
