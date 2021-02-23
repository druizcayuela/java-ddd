package social.app.backoffice.courses.application.create;

import social.app.backoffice.courses.domain.BackofficeCourse;
import social.app.backoffice.courses.domain.BackofficeCourseRepository;
import social.app.shared.domain.Service;

@Service
public final class BackofficeCourseCreator {
    private final BackofficeCourseRepository repository;

    public BackofficeCourseCreator(BackofficeCourseRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String duration) {
        this.repository.save(new BackofficeCourse(id, name, duration));
    }
}
