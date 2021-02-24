package social.app.rrss.users;

import org.springframework.beans.factory.annotation.Autowired;
import social.app.rrss.RRSSContextInfrastructureTestCase;
import social.app.rrss.users.domain.UserRepository;

public abstract class UsersModuleInfrastructureTestCase extends RRSSContextInfrastructureTestCase {
    @Autowired
    protected UserRepository mySqlUserRepository;
}
