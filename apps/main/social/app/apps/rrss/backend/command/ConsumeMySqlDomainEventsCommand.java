package social.app.apps.rrss.backend.command;

import social.app.shared.infrastructure.bus.event.mysql.MySqlDomainEventsConsumer;
import social.app.shared.infrastructure.cli.ConsoleCommand;

public final class ConsumeMySqlDomainEventsCommand extends ConsoleCommand {
    private final MySqlDomainEventsConsumer consumer;

    public ConsumeMySqlDomainEventsCommand(MySqlDomainEventsConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void execute(String[] args) {
        consumer.consume();
    }
}
