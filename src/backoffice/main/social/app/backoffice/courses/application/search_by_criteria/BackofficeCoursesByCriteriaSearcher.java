package social.app.backoffice.courses.application.search_by_criteria;

import social.app.backoffice.courses.application.BackofficeCourseResponse;
import social.app.backoffice.courses.application.BackofficeCoursesResponse;
import social.app.backoffice.courses.domain.BackofficeCourseRepository;
import social.app.shared.domain.Service;
import social.app.shared.domain.criteria.Criteria;
import social.app.shared.domain.criteria.Filters;
import social.app.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class BackofficeCoursesByCriteriaSearcher {
    private final BackofficeCourseRepository repository;

    public BackofficeCoursesByCriteriaSearcher(BackofficeCourseRepository repository) {
        this.repository = repository;
    }

    public BackofficeCoursesResponse search(
        Filters filters,
        Order order,
        Optional<Integer> limit,
        Optional<Integer> offset
    ) {
        Criteria criteria = new Criteria(filters, order, limit, offset);

        return new BackofficeCoursesResponse(
            repository.matching(criteria)
                      .stream()
                      .map(BackofficeCourseResponse::fromAggregate)
                      .collect(Collectors.toList())
        );
    }
}
