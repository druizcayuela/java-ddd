package social.app.rrss.users.application.find;

import social.app.rrss.users.domain.UserId;
import social.app.rrss.users.domain.UserIdMother;

public class FindUserQueryMother {

    public static FindUserQuery create(UserId id) {
        return new FindUserQuery(id.value());
    }

    public static FindUserQuery random() {
        return create(UserIdMother.random());
    }
}
