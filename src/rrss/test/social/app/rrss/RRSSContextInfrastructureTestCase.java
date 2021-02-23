package social.app.rrss;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import social.app.apps.rrss.backend.RRSSBackendApplication;
import social.app.shared.infrastructure.InfrastructureTestCase;

@ContextConfiguration(classes = RRSSBackendApplication.class)
@SpringBootTest
public abstract class RRSSContextInfrastructureTestCase extends InfrastructureTestCase {
}
