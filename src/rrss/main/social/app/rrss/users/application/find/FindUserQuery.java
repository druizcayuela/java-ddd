package social.app.rrss.users.application.find;

import social.app.shared.domain.bus.query.Query;

public final class FindUserQuery implements Query {
    private final String id;

    public FindUserQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
