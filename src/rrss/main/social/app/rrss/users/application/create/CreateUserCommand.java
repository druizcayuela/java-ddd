package social.app.rrss.users.application.create;

import social.app.shared.domain.bus.command.Command;

public final class CreateUserCommand implements Command {

    private final String id;
    private final String name;
    private final String email;

    public CreateUserCommand(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }
}
