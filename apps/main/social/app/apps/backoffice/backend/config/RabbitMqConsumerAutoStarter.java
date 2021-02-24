package social.app.apps.backoffice.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import social.app.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;

@Component
public class RabbitMqConsumerAutoStarter implements CommandLineRunner {

    private final RabbitMqDomainEventsConsumer rabbitMqDomainEventsConsumer;

    public RabbitMqConsumerAutoStarter(RabbitMqDomainEventsConsumer rabbitMqDomainEventsConsumer) {
        this.rabbitMqDomainEventsConsumer = rabbitMqDomainEventsConsumer;
    }


    @Override
    public void run(String... args) {
        rabbitMqDomainEventsConsumer.consume();

        System.out.println("RabbitMQ consumer has been started.");
    }
}
