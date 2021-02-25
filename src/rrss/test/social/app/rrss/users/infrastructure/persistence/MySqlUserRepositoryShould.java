package social.app.rrss.users.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import social.app.rrss.users.UsersModuleInfrastructureTestCase;
import social.app.rrss.users.domain.User;
import social.app.rrss.users.domain.UserIdMother;
import social.app.rrss.users.domain.UserMother;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Transactional
class MySqlUserRepositoryShould extends UsersModuleInfrastructureTestCase {
    @Test
    void save_a_user() {
        User user = UserMother.random();

        mySqlUserRepository.save(user);
    }

    @Test
    void return_an_existing_user() {
        User user = UserMother.random();

        mySqlUserRepository.save(user);

        assertEquals(Optional.of(user), mySqlUserRepository.search(user.id()));
    }

    @Test
    void not_return_a_non_existing_user() {
        assertFalse(mySqlUserRepository.search(UserIdMother.random()).isPresent());
    }
}
