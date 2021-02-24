package social.app.rrss.users.domain;

import social.app.shared.domain.IntegerMother;
import social.app.shared.domain.RandomElementPicker;
import social.app.shared.domain.WordMother;

public final class UserEmailMother {
    public static UserEmail create(String value) {
        return new UserEmail(value);
    }

    public static UserEmail random() {
        return create(WordMother.random());
    }
}
