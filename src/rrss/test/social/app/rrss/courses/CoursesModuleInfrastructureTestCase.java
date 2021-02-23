package social.app.rrss.courses;

import org.springframework.beans.factory.annotation.Autowired;
import social.app.rrss.RRSSContextInfrastructureTestCase;
import social.app.rrss.courses.domain.CourseRepository;
import social.app.rrss.courses.infrastructure.persistence.InMemoryCourseRepository;

public abstract class CoursesModuleInfrastructureTestCase extends RRSSContextInfrastructureTestCase {
    protected InMemoryCourseRepository inMemoryCourseRepository = new InMemoryCourseRepository();
    @Autowired
    protected CourseRepository         mySqlCourseRepository;
}
