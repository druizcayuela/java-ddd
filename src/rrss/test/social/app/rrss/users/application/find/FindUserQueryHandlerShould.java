package social.app.rrss.users.application.find;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import social.app.rrss.courses.application.create.CreateCourseCommand;
import social.app.rrss.courses.application.create.CreateCourseCommandMother;
import social.app.rrss.courses.domain.Course;
import social.app.rrss.courses.domain.CourseCreatedDomainEventMother;
import social.app.rrss.courses.domain.CourseMother;
import social.app.rrss.users.UsersModuleUnitTestCase;
import social.app.rrss.users.application.UserResponse;
import social.app.rrss.users.application.UserResponseMother;
import social.app.rrss.users.domain.*;
import social.app.shared.domain.course.CourseCreatedDomainEvent;

final class FindUserQueryHandlerShould extends UsersModuleUnitTestCase {
    private FindUserQueryHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new FindUserQueryHandler(new UserFinder(repository));
    }

    @Test
    void search_some_valid_user() {
        FindUserQuery query = FindUserQueryMother.random();
        UserId id = UserIdMother.create(query.id());
        User user = UserMother.create(id, UserNameMother.random(), UserEmailMother.random());

        whenHasValidValue(id, user);

        handler.handle(query);

        shouldHaveSearched(id);
    }
}
