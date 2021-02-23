package social.app.rrss.courses.infrastructure.persistence;

import social.app.rrss.courses.domain.Course;
import social.app.rrss.courses.domain.CourseId;
import social.app.rrss.courses.domain.CourseRepository;
import social.app.shared.domain.criteria.Criteria;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public final class InMemoryCourseRepository implements CourseRepository {
    private HashMap<String, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        courses.put(course.id().value(), course);
    }

    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id.value()));
    }

    @Override
    public List<Course> matching(Criteria criteria) {
        return null;
    }
}
