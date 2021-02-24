package social.app.rrss.users.domain;

import social.app.shared.domain.UuidMother;

public final class UserIdMother {
    public static UserId create(String value) {
        return new UserId(value);
    }

    public static UserId random() {
        return create(UuidMother.random());
    }
}
