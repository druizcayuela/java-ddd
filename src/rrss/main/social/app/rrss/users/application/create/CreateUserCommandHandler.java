package social.app.rrss.users.application.create;

import social.app.rrss.users.domain.UserEmail;
import social.app.rrss.users.domain.UserId;
import social.app.rrss.users.domain.UserName;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {

    private final UserCreator userCreator;

    public CreateUserCommandHandler(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @Override
    public void handle(CreateUserCommand command) {
        UserId id = new UserId(command.id());
        UserName name = new UserName(command.name());
        UserEmail email = new UserEmail(command.email());

        userCreator.create(id, name, email);
    }
}
