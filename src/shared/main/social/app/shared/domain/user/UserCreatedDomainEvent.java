package social.app.shared.domain.user;

import social.app.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class UserCreatedDomainEvent extends DomainEvent {
    private final String name;
    private final String email;

    public UserCreatedDomainEvent() {
        super(null);

        this.name = null;
        this.email = null;
    }

    public UserCreatedDomainEvent(String aggregateId, String name, String email) {
        super(aggregateId);

        this.name = name;
        this.email = email;
    }

    public UserCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String name,
        String email
    ) {
        super(aggregateId, eventId, occurredOn);

        this.name = name;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "user.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("email", email);
        }};
    }

    @Override
    public UserCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new UserCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("email")
        );
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserCreatedDomainEvent that = (UserCreatedDomainEvent) o;
        return name.equals(that.name) &&
            email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
