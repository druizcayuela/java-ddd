package social.app.backoffice.users.application.create;

import org.springframework.context.event.EventListener;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEventSubscriber;
import social.app.shared.domain.user.UserCreatedDomainEvent;

@Service
@DomainEventSubscriber({UserCreatedDomainEvent.class})
public final class CreateBackofficeUserOnUserCreated {
    private final BackofficeUserCreator creator;

    public CreateBackofficeUserOnUserCreated(BackofficeUserCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(UserCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.name(), event.email());
    }
}
