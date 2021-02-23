package social.app.backoffice.courses.application.search_all;

import social.app.backoffice.courses.application.BackofficeCourseResponse;
import social.app.backoffice.courses.application.BackofficeCoursesResponse;
import social.app.backoffice.courses.domain.BackofficeCourseRepository;
import social.app.shared.domain.Service;

import java.util.stream.Collectors;

@Service
public final class AllBackofficeCoursesSearcher {
    private final BackofficeCourseRepository repository;

    public AllBackofficeCoursesSearcher(BackofficeCourseRepository repository) {
        this.repository = repository;
    }

    public BackofficeCoursesResponse search() {
        return new BackofficeCoursesResponse(
            repository.searchAll().stream().map(BackofficeCourseResponse::fromAggregate).collect(Collectors.toList())
        );
    }
}
