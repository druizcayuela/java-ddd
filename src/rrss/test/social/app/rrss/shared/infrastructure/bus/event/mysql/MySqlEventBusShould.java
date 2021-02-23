package social.app.rrss.shared.infrastructure.bus.event.mysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import social.app.rrss.courses.domain.CourseCreatedDomainEventMother;
import social.app.rrss.RRSSContextInfrastructureTestCase;
import social.app.shared.domain.course.CourseCreatedDomainEvent;
import social.app.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import social.app.shared.infrastructure.bus.event.mysql.MySqlEventBus;

import javax.transaction.Transactional;
import java.util.Collections;

@Transactional
class MySqlEventBusShould extends RRSSContextInfrastructureTestCase {
    @Autowired
    private MySqlEventBus             eventBus;
    @Autowired
    private MySqlDomainEventsConsumer consumer;

    @Test
    void publish_and_consume_domain_events_from_msql() throws InterruptedException {
        CourseCreatedDomainEvent domainEvent = CourseCreatedDomainEventMother.random();

        eventBus.publish(Collections.singletonList(domainEvent));

        Thread consumerProcess = new Thread(() -> consumer.consume());
        consumerProcess.start();

        Thread.sleep(100);

        consumer.stop();
    }
}
