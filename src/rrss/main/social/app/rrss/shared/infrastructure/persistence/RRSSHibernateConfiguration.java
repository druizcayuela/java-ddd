package social.app.rrss.shared.infrastructure.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import social.app.shared.infrastructure.config.Parameter;
import social.app.shared.infrastructure.config.ParameterNotExist;
import social.app.shared.infrastructure.hibernate.HibernateConfigurationFactory;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class RRSSHibernateConfiguration {
    private final HibernateConfigurationFactory factory;
    private final Parameter                     config;
    private final String                        CONTEXT_NAME = "rrss";

    public RRSSHibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
    }

    @Bean("rrss-transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("rrss-session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("rrss-data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("RRSS_DATABASE_HOST"),
            config.getInt("RRSS_DATABASE_PORT"),
            config.get("RRSS_DATABASE_NAME"),
            config.get("RRSS_DATABASE_USER"),
            config.get("RRSS_DATABASE_PASSWORD")
        );
    }
}
