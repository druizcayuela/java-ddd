package social.app.rrss.shared.infrastructure.bus.event.rabbitmq;

import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEventSubscriber;
import social.app.shared.domain.course.CourseCreatedDomainEvent;

@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class TestAllWorksOnRabbitMqEventsPublished {
    public Boolean hasBeenExecuted = false;

    public void on(CourseCreatedDomainEvent event) {
        hasBeenExecuted = true;
    }
}
