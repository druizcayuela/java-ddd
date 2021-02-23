package social.app.rrss.shared.infrastructure.bus.event.rabbitmq;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import social.app.rrss.courses.domain.CourseCreatedDomainEventMother;
import social.app.rrss.RRSSContextInfrastructureTestCase;
import social.app.shared.domain.course.CourseCreatedDomainEvent;
import social.app.shared.infrastructure.bus.event.DomainEventSubscriberInformation;
import social.app.shared.infrastructure.bus.event.DomainEventSubscribersInformation;
import social.app.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;
import social.app.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;

import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

public final class RabbitMqEventBusShould extends RRSSContextInfrastructureTestCase {
    @Autowired
    private RabbitMqEventBus                      eventBus;
    @Autowired
    private RabbitMqDomainEventsConsumer          consumer;
    @Autowired
    private TestAllWorksOnRabbitMqEventsPublished subscriber;

    @BeforeEach
    protected void setUp() {
        subscriber.hasBeenExecuted = false;

        consumer.withSubscribersInformation(
            new DomainEventSubscribersInformation(
                new HashMap<Class<?>, DomainEventSubscriberInformation>() {{
                    put(TestAllWorksOnRabbitMqEventsPublished.class, new DomainEventSubscriberInformation(
                        TestAllWorksOnRabbitMqEventsPublished.class,
                        Collections.singletonList(CourseCreatedDomainEvent.class)
                    ));
                }}
            )
        );
    }

    @Test
    void publish_and_consume_domain_events_from_rabbitmq() throws Exception {
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        consumer.consume();

        eventually(() -> assertTrue(subscriber.hasBeenExecuted));
    }
}
