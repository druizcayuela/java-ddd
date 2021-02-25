package social.app.rrss.users.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import social.app.rrss.users.domain.User;
import social.app.rrss.users.domain.UserId;
import social.app.rrss.users.domain.UserRepository;
import social.app.shared.domain.Service;
import social.app.shared.infrastructure.hibernate.HibernateRepository;

import java.util.Optional;


@Service
@Transactional("rrss-transaction_manager")
public class MySqlUserRepository extends HibernateRepository<User> implements UserRepository {
    public MySqlUserRepository(@Qualifier("rrss-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public Optional<User> search(UserId id) {
        return byId(id);
    }
}
