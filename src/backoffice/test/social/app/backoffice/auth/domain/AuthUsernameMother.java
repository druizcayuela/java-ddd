package social.app.backoffice.auth.domain;

import social.app.shared.domain.WordMother;

public final class AuthUsernameMother {
    public static AuthUsername create(String value) {
        return new AuthUsername(value);
    }

    public static AuthUsername random() {
        return create(WordMother.random());
    }
}
