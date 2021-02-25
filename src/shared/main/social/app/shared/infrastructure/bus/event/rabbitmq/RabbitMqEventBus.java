package social.app.shared.infrastructure.bus.event.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.context.annotation.Primary;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEvent;
import social.app.shared.domain.bus.event.EventBus;
import social.app.shared.infrastructure.bus.event.mysql.MySqlEventBus;

import java.util.Collections;
import java.util.List;

@Primary
@Service
public class RabbitMqEventBus implements EventBus {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus failoverPublisher;
    private final String exchangeName;

    public RabbitMqEventBus(RabbitMqPublisher publisher, MySqlEventBus failoverPublisher) {
        this.publisher = publisher;
        this.failoverPublisher = failoverPublisher;
        this.exchangeName = "domain_events";
    }

    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(DomainEvent domainEvent) {
        try {
            this.publisher.publish(domainEvent, exchangeName);
        } catch (AmqpException error) {
            error.printStackTrace();
            failoverPublisher.publish(Collections.singletonList(domainEvent));
        }
    }
}
