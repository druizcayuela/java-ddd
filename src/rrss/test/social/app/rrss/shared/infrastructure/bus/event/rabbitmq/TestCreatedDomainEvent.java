package social.app.rrss.shared.infrastructure.bus.event.rabbitmq;

import social.app.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public final class TestCreatedDomainEvent extends DomainEvent {
    private final String name;

    public TestCreatedDomainEvent() {
        super(null);

        this.name     = null;
    }

    public TestCreatedDomainEvent(String aggregateId, String name) {
        super(aggregateId);

        this.name     = name;
    }

    public TestCreatedDomainEvent(
        String aggregateId,
        String eventId,
        String occurredOn,
        String name
    ) {
        super(aggregateId, eventId, occurredOn);

        this.name     = name;
    }

    @Override
    public String eventName() {
        return "test.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
        }};
    }

    @Override
    public TestCreatedDomainEvent fromPrimitives(
        String aggregateId,
        HashMap<String, Serializable> body,
        String eventId,
        String occurredOn
    ) {
        return new TestCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name")
        );
    }

    public String name() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestCreatedDomainEvent that = (TestCreatedDomainEvent) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}

