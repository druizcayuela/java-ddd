package social.app.rrss.users;

import org.junit.jupiter.api.BeforeEach;
import social.app.rrss.users.domain.User;
import social.app.rrss.users.domain.UserId;
import social.app.rrss.users.domain.UserRepository;
import social.app.shared.domain.bus.query.Query;
import social.app.shared.domain.bus.query.Response;
import social.app.shared.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.*;

public abstract class UsersModuleUnitTestCase extends UnitTestCase {
    protected UserRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(UserRepository.class);
    }

    public void shouldHaveSaved(User user) {
        verify(repository, atLeastOnce()).save(user);
    }

    public void shouldHaveSearched(UserId id) {
        verify(repository, atLeastOnce()).search(id);
    }

    public void whenHasValidValue(UserId id, User user) {
        when(repository.search(id)).thenReturn(Optional.ofNullable(user));
    }
}
