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
public class MoocMySqlEventBusConfiguration {
    private final SessionFactory            sessionFactory;
    private final DomainEventsInformation   domainEventsInformation;
    private final SpringApplicationEventBus bus;

    public MoocMySqlEventBusConfiguration(
        @Qualifier("mooc-session_factory") SessionFactory sessionFactory,
        DomainEventsInformation domainEventsInformation,
        SpringApplicationEventBus bus
    ) {
        this.sessionFactory          = sessionFactory;
        this.domainEventsInformation = domainEventsInformation;
        this.bus                     = bus;
    }

    @Bean
    public MySqlEventBus moocMysqlEventBus() {
        return new MySqlEventBus(sessionFactory);
    }

    @Bean
    public MySqlDomainEventsConsumer moocMySqlDomainEventsConsumer() {
        return new MySqlDomainEventsConsumer(sessionFactory, domainEventsInformation, bus);
    }
}