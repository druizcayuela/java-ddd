package social.app.rrss.users.domain;

import social.app.shared.domain.StringValueObject;

public final class UserEmail extends StringValueObject {

    public UserEmail(String value) {
        super(value);
    }

    public UserEmail() {
        super("");
    }
}
