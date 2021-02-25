package social.app.backoffice.courses.domain;

import social.app.shared.domain.criteria.Criteria;
import social.app.shared.domain.criteria.Filter;
import social.app.shared.domain.criteria.Filters;
import social.app.shared.domain.criteria.Order;

import java.util.Arrays;

public final class BackofficeCourseCriteriaMother {
    public static Criteria nameAndDurationContains(String name, String duration) {
        Filter nameFilter = Filter.create("name", "contains", name);
        Filter durationFilter = Filter.create("duration", "contains", duration);

        return new Criteria(new Filters(Arrays.asList(nameFilter, durationFilter)), Order.asc("name"));
    }
}
