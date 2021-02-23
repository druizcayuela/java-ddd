package social.app.rrss.courses.application.create;

import social.app.rrss.courses.domain.*;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.EventBus;

@Service
public final class CourseCreator {
    private final CourseRepository repository;
    private final EventBus         eventBus;

    public CourseCreator(CourseRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(CourseId id, CourseName name, CourseDuration duration) {
        Course course = Course.create(id, name, duration);

        repository.save(course);
        eventBus.publish(course.pullDomainEvents());
    }
}
