package social.app.apps.rrss.backend.controller.users;

import org.junit.jupiter.api.Test;
import social.app.apps.rrss.RRSSApplicationTestCase;

public final class UserPutControllerShould extends RRSSApplicationTestCase {
    @Test
    void create_a_valid_non_existing_user() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/users/1aab45ba-3c7a-4344-8936-78466eca77fa",
            "{\"name\": \"Dani\", \"email\": \"nuflo@gmail.com\"}",
            201
        );
    }
}
