package social.app.rrss.courses.domain;

import social.app.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    void save(Course course);

    Optional<Course> search(CourseId id);

    List<Course> matching(Criteria criteria);
}
