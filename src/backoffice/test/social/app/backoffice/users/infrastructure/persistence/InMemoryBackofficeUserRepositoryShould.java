package social.app.backoffice.users.infrastructure.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import social.app.backoffice.BackofficeContextInfrastructureTestCase;
import social.app.backoffice.users.domain.BackofficeUser;
import social.app.backoffice.users.domain.BackofficeUserMother;

final class InMemoryBackofficeUserRepositoryShould extends BackofficeContextInfrastructureTestCase {
    private InMemoryBackofficeUserRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = new InMemoryBackofficeUserRepository();
    }

    @Test
    void save_a_user() {
        BackofficeUser user = BackofficeUserMother.random();

        repository.save(user);
    }
}
