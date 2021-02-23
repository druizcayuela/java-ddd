package social.app.rrss.courses;

import org.junit.jupiter.api.BeforeEach;
import social.app.rrss.courses.domain.Course;
import social.app.rrss.courses.domain.CourseRepository;
import social.app.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.*;

public abstract class CoursesModuleUnitTestCase extends UnitTestCase {
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(CourseRepository.class);
    }

    public void shouldHaveSaved(Course course) {
        verify(repository, atLeastOnce()).save(course);
    }
}
