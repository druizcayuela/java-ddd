package social.app.rrss.users.domain;

import social.app.shared.domain.StringValueObject;

public final class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    public UserName() {
        super("");
    }
}
