package social.app.apps.rrss.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import social.app.apps.rrss.backend.command.ConsumeMySqlDomainEventsCommand;
import social.app.apps.rrss.backend.command.ConsumeRabbitMqDomainEventsCommand;
import social.app.shared.domain.Service;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"social.app.shared", "social.app.rrss", "social.app.apps.rrss.backend"}
)
public class RRSSBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
            put("domain-events:mysql:consume", ConsumeMySqlDomainEventsCommand.class);
            put("domain-events:rabbitmq:consume", ConsumeRabbitMqDomainEventsCommand.class);
        }};
    }
}
