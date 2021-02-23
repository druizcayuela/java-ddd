package social.app.rrss.shared.infrastructure.persistence;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import social.app.shared.infrastructure.bus.event.mysql.MySqlEventBus;
import social.app.shared.infrastructure.bus.event.rabbitmq.RabbitMqEventBus;
import social.app.shared.infrastructure.bus.event.rabbitmq.RabbitMqPublisher;

@Configuration
public class MoocRabbitMqEventBusConfiguration {
    private final RabbitMqPublisher publisher;
    private final MySqlEventBus     failoverPublisher;

    public MoocRabbitMqEventBusConfiguration(
        RabbitMqPublisher publisher,
        @Qualifier("moocMysqlEventBus") MySqlEventBus failoverPublisher
    ) {
        this.publisher         = publisher;
        this.failoverPublisher = failoverPublisher;
    }

    @Bean
    public RabbitMqEventBus moocRabbitMqEventBus() {
        return new RabbitMqEventBus(publisher, failoverPublisher);
    }
}
