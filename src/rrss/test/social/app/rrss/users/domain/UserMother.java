package social.app.rrss.users.domain;

import social.app.rrss.users.application.create.CreateUserCommand;

public final class UserMother {
    public static User create(UserId id, UserName name, UserEmail email) {
        return new User(id, name, email);
    }

    public static User fromRequest(CreateUserCommand request) {
        return create(
            UserIdMother.create(request.id()),
            UserNameMother.create(request.name()),
            UserEmailMother.create(request.email())
        );
    }

    public static User random() {
        return create(UserIdMother.random(), UserNameMother.random(), UserEmailMother.random());
    }
}
