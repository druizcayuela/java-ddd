package social.app.rrss.users.application.find;

import social.app.rrss.users.application.UserResponse;
import social.app.rrss.users.domain.UserId;
import social.app.rrss.users.domain.UserNotExist;
import social.app.rrss.users.domain.UserRepository;
import social.app.shared.domain.Service;

@Service
public final class UserFinder {
    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse find(UserId id) throws UserNotExist {
        return repository.search(id)
            .map(UserResponse::fromAggregate)
            .orElseThrow(() -> new UserNotExist(id));
    }
}
