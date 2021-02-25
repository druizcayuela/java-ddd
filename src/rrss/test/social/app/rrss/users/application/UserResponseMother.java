package social.app.rrss.users.application;

import social.app.rrss.users.domain.*;

public final class UserResponseMother {
    public static UserResponse create(UserId id, UserName name, UserEmail duration) {
        return new UserResponse(id.value(), name.value(), duration.value());
    }

    public static UserResponse random() {
        return create(UserIdMother.random(), UserNameMother.random(), UserEmailMother.random());
    }
}
