package social.app.backoffice.courses.domain;

import social.app.shared.domain.criteria.Criteria;

import java.util.List;

public interface BackofficeCourseRepository {
    void save(BackofficeCourse course);

    List<BackofficeCourse> searchAll();

    List<BackofficeCourse> matching(Criteria criteria);
}
