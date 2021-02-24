package social.app.rrss.shared.infrastructure.bus.event.rabbitmq;

import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEventSubscriber;
import social.app.shared.domain.user.UserCreatedDomainEvent;

@Service
@DomainEventSubscriber({UserCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public Boolean hasBeenExecuted = false;

    public void on(UserCreatedDomainEvent event) {
        hasBeenExecuted = true;
    }
}
