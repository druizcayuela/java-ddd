package social.app.apps.rrss.backend.controller.users;

import org.junit.jupiter.api.Test;
import social.app.apps.rrss.RRSSApplicationTestCase;

final class UserGetControllerShould extends RRSSApplicationTestCase {
    @Test
    void find_an_existing_user() throws Exception {
        String id = "99ad55f5-6eab-4d73-b383-c63268e251e8";
        String body = "{\"name\": \"Dani\", \"email\": \"nuflo@gmail.com\"}";

        givenThereIsAUser(id, body);

        assertResponse(String.format("/users/%s", id), 200, body);
    }

    @Test
    void no_find_a_non_existing_user() throws Exception {
        String id = "4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661";
        String body = "{\"error_code\": \"user_not_exist\", \"message\": \"The user <4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661> doesn't exist\"}";

        assertResponse(String.format("/users/%s", id), 404, body);
    }

    private void givenThereIsAUser(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/users/%s", id), body, 201);
    }
}
