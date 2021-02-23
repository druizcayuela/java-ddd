package social.app.backoffice.auth;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import social.app.backoffice.auth.domain.AuthRepository;
import social.app.backoffice.auth.domain.AuthUser;
import social.app.backoffice.auth.domain.AuthUsername;
import social.app.shared.infrastructure.UnitTestCase;

import java.util.Optional;

import static org.mockito.Mockito.mock;

public abstract class AuthModuleUnitTestCase extends UnitTestCase {
    protected AuthRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(AuthRepository.class);
    }

    public void shouldSearch(AuthUsername username, AuthUser user) {
        Mockito.when(repository.search(username)).thenReturn(Optional.of(user));
    }

    public void shouldSearch(AuthUsername username) {
        Mockito.when(repository.search(username)).thenReturn(Optional.empty());
    }
}
