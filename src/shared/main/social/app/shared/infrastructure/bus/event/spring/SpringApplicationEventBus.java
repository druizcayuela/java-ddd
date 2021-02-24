package social.app.shared.infrastructure.bus.event.spring;

import org.springframework.context.ApplicationEventPublisher;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEvent;
import social.app.shared.domain.bus.event.EventBus;

import java.util.List;

@Service
public class SpringApplicationEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}
