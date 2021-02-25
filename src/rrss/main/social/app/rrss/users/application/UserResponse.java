package social.app.rrss.users.application;

import social.app.rrss.users.domain.User;
import social.app.shared.domain.bus.query.Response;

public final class UserResponse implements Response {
    private final String id;
    private final String name;
    private final String email;

    public UserResponse(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id().value(), user.name().value(), user.email().value());
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
