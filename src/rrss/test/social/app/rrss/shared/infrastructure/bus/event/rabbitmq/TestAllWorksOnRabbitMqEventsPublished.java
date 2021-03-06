package social.app.rrss.shared.infrastructure.bus.event.rabbitmq;

import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEventSubscriber;

@Service
@DomainEventSubscriber({TestCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public Boolean hasBeenExecuted = false;

    public void on(TestCreatedDomainEvent event) {
        hasBeenExecuted = true;
    }
}
