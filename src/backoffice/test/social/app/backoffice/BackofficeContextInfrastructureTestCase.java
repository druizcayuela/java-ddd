package social.app.backoffice;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import social.app.apps.backoffice.backend.BackofficeBackendApplication;
import social.app.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = BackofficeBackendApplication.class)
@SpringBootTest
public abstract class BackofficeContextInfrastructureTestCase extends InfrastructureTestCase {
}
