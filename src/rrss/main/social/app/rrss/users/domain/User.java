package social.app.rrss.users.domain;

import social.app.shared.domain.AggregateRoot;
import social.app.shared.domain.user.UserCreatedDomainEvent;

public final class User extends AggregateRoot {

    private final UserId id;
    private final UserName name;
    private final UserEmail email;

    public User(UserId id, UserName name, UserEmail email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {
        id = null;
        name = null;
        email = null;
    }

    public static User create(UserId id, UserName name, UserEmail email) {
        User user = new User(id, name, email);

        user.record(new UserCreatedDomainEvent(id.value(), name.value(), email.value()));

        return user;
    }

    public UserId id() {
        return id;
    }

    public UserName name() {
        return name;
    }

    public UserEmail email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
