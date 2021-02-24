package social.app.backoffice.users.infrastructure.persistence;

import social.app.backoffice.users.domain.BackofficeUser;
import social.app.backoffice.users.domain.BackofficeUserRepository;
import social.app.shared.domain.Service;

import java.util.HashMap;

@Service
public final class InMemoryBackofficeUserRepository implements BackofficeUserRepository {

    private HashMap<String, BackofficeUser> users = new HashMap<>();

    @Override
    public void save(BackofficeUser user) {
        users.put(user.id(), user);
        System.out.println("BackofficeUser created!" + user.toPrimitives());
    }
}
