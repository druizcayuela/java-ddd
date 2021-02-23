package social.app.apps.rrss;

import org.springframework.transaction.annotation.Transactional;
import social.app.apps.ApplicationTestCase;

@Transactional("rrss-transaction_manager")
public abstract class RRSSApplicationTestCase extends ApplicationTestCase {
}
