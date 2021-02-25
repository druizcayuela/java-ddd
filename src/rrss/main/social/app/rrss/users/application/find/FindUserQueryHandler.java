package social.app.rrss.users.application.find;

import social.app.rrss.users.application.UserResponse;
import social.app.rrss.users.domain.UserId;
import social.app.rrss.users.domain.UserNotExist;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserQueryHandler implements QueryHandler<FindUserQuery, UserResponse> {
    private final UserFinder finder;

    public FindUserQueryHandler(UserFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindUserQuery query) throws UserNotExist {
        return finder.find(new UserId(query.id()));
    }
}
