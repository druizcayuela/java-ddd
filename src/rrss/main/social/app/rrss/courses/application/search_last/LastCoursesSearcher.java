package social.app.rrss.courses.application.search_last;

import social.app.rrss.courses.application.CourseResponse;
import social.app.rrss.courses.application.CoursesResponse;
import social.app.rrss.courses.domain.CourseRepository;
import social.app.shared.domain.Service;
import social.app.shared.domain.criteria.Criteria;
import social.app.shared.domain.criteria.Filters;
import social.app.shared.domain.criteria.Order;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public final class LastCoursesSearcher {
    private final CourseRepository repository;

    public LastCoursesSearcher(CourseRepository repository) {
        this.repository = repository;
    }

    public CoursesResponse search(int courses) {
        Criteria criteria = new Criteria(
            Filters.none(),
            Order.none(),
            Optional.of(courses),
            Optional.empty()
        );

        return new CoursesResponse(
            repository.matching(criteria).stream().map(CourseResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
