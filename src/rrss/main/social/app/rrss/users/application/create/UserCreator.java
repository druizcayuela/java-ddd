package social.app.rrss.users.application.create;

import social.app.rrss.users.domain.*;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.event.EventBus;

@Service
public final class UserCreator {

    private final UserRepository userRepository;
    private final EventBus eventBus;


    public UserCreator(UserRepository userRepository, EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void create(UserId id, UserName name, UserEmail email) {
        User user = User.create(id, name, email);

        userRepository.save(user);
        eventBus.publish(user.pullDomainEvents());
    }
}
