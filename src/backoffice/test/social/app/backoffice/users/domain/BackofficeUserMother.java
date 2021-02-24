package social.app.backoffice.users.domain;

import social.app.shared.domain.UuidMother;
import social.app.shared.domain.WordMother;

public final class BackofficeUserMother {
    public static BackofficeUser create(String id, String name, String email) {
        return new BackofficeUser(id, name, email);
    }

    public static BackofficeUser create(String name, String email) {
        return new BackofficeUser(UuidMother.random(), name, email);
    }

    public static BackofficeUser random() {
        return create(UuidMother.random(), WordMother.random(), WordMother.random());
    }
}
