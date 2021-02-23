package social.app.apps.backoffice;

import org.springframework.transaction.annotation.Transactional;
import social.app.apps.ApplicationTestCase;

@Transactional("backoffice-transaction_manager")
public abstract class BackofficeApplicationTestCase extends ApplicationTestCase {
}
