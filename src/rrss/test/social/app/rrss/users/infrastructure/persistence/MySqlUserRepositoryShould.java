package social.app.rrss.users.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import social.app.rrss.users.domain.User;
import social.app.rrss.users.domain.UserMother;
import social.app.rrss.users.UsersModuleInfrastructureTestCase;

import javax.transaction.Transactional;

@Transactional
class MySqlUserRepositoryShould extends UsersModuleInfrastructureTestCase {
    @Test
    void save_a_user() {
        User user = UserMother.random();

        mySqlUserRepository.save(user);
    }
}
