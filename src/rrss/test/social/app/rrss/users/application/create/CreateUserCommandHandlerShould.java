package social.app.rrss.users.application.create;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import social.app.rrss.users.UsersModuleUnitTestCase;
import social.app.rrss.users.domain.User;
import social.app.rrss.users.domain.UserCreatedDomainEventMother;
import social.app.rrss.users.domain.UserMother;
import social.app.shared.domain.user.UserCreatedDomainEvent;


final class CreateUserCommandHandlerShould extends UsersModuleUnitTestCase {
    private CreateUserCommandHandler handler;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        handler = new CreateUserCommandHandler(new UserCreator(repository, eventBus));
    }

    @Test
    void create_a_valid_user() {
        CreateUserCommand command = CreateUserCommandMother.random();

        User user = UserMother.fromRequest(command);
        UserCreatedDomainEvent domainEvent = UserCreatedDomainEventMother.fromUser(user);

        handler.handle(command);

        shouldHaveSaved(user);
        shouldHavePublished(domainEvent);
    }
}
