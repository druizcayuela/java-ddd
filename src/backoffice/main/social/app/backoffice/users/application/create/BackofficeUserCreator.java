package social.app.backoffice.users.application.create;

import social.app.backoffice.users.domain.BackofficeUser;
import social.app.backoffice.users.domain.BackofficeUserRepository;
import social.app.shared.domain.Service;

@Service
public final class BackofficeUserCreator {
    private final BackofficeUserRepository repository;

    public BackofficeUserCreator(BackofficeUserRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String email) {
        this.repository.save(new BackofficeUser(id, name, email));
    }
}
