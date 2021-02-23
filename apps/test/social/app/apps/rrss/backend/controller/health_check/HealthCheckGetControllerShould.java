package social.app.apps.rrss.backend.controller.health_check;

import org.junit.jupiter.api.Test;
import social.app.apps.rrss.RRSSApplicationTestCase;

final class HealthCheckGetControllerShould extends RRSSApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'application':'rrss_backend','status':'ok'}");
    }
}
