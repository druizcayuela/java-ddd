package social.app.rrss.shared.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import social.app.shared.infrastructure.bus.event.DomainEventsInformation;
import social.app.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import social.app.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import social.app.shared.infrastructure.bus.event.spring.SpringApplicationEventBus;

@Configuration
public class RRSSMySqlEventBusConfiguration {
    private final SessionFactory sessionFactory;
    private final DomainEventsInformation domainEventsInformation;
    private final SpringApplicationEventBus bus;

    public RRSSMySqlEventBusConfiguration(
        @Qualifier("rrss-session_factory") SessionFactory sessionFactory,
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus
    ) {
        this.sessionFactory = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.bus = bus;
    }

    @Bean
    public MySqlEventBus rrssMysqlEventBus() {
        return new MySqlEventBus(sessionFactory);
    }

    @Bean
    public MySqlDomainEventsConsumer rrssMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
    }
}
