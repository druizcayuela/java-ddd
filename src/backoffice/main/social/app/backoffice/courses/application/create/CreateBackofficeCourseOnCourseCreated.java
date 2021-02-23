package social.app.backoffice.courses.application.create;

import org.springframework.context.event.EventListener;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.DomainEventSubscriber;
import social.app.shared.domain.course.CourseCreatedDomainEvent;

@Service
@DomainEventSubscriber({CourseCreatedDomainEvent.class})
public final class CreateBackofficeCourseOnCourseCreated {
    private final BackofficeCourseCreator creator;

    public CreateBackofficeCourseOnCourseCreated(BackofficeCourseCreator creator) {
        this.creator = creator;
    }

    @EventListener
    public void on(CourseCreatedDomainEvent event) {
        creator.create(event.aggregateId(), event.name(), event.duration());
    }
}
