package social.app.backoffice.auth.application.authenticate;

import social.app.backoffice.auth.domain.AuthPassword;
import social.app.backoffice.auth.domain.AuthUsername;
import social.app.backoffice.auth.domain.AuthPasswordMother;
import social.app.backoffice.auth.domain.AuthUsernameMother;

public final class AuthenticateUserCommandMother {
    public static AuthenticateUserCommand create(AuthUsername username, AuthPassword password) {
        return new AuthenticateUserCommand(username.value(), password.value());
    }

    public static AuthenticateUserCommand random() {
        return create(AuthUsernameMother.random(), AuthPasswordMother.random());
    }
}
