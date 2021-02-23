package social.app.rrss.courses.application.find;

import social.app.rrss.courses.application.CourseResponse;
import social.app.rrss.courses.domain.CourseId;
import social.app.rrss.courses.domain.CourseNotExist;
import social.app.rrss.courses.domain.CourseRepository;
import social.app.shared.domain.Service;

@Service
public final class CourseFinder {
    private final CourseRepository repository;

    public CourseFinder(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseResponse find(CourseId id) throws CourseNotExist {
        return repository.search(id)
                         .map(CourseResponse::fromAggregate)
                         .orElseThrow(() -> new CourseNotExist(id));
    }
}
