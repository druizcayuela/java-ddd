package social.app.rrss.courses.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import social.app.rrss.courses.CoursesModuleUnitTestCase;
import social.app.rrss.courses.domain.Course;
import social.app.rrss.courses.domain.CourseCreatedDomainEventMother;
import social.app.rrss.courses.domain.CourseMother;
import social.app.shared.domain.course.CourseCreatedDomainEvent;

final class CreateCourseCommandHandlerShould extends CoursesModuleUnitTestCase {
    private CreateCourseCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateCourseCommandHandler(new CourseCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_course() {
        CreateCourseCommand command = CreateCourseCommandMother.random();

        Course                   course      = CourseMother.fromRequest(command);
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.fromCourse(course);

        handler.handle(command);

        shouldHaveSaved(course);
        shouldHavePublished(domainEvent);
    }
}
