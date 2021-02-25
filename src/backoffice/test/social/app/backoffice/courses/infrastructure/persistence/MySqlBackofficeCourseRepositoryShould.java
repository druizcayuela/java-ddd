package social.app.backoffice.courses.infrastructure.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import social.app.backoffice.BackofficeContextInfrastructureTestCase;
import social.app.backoffice.courses.domain.BackofficeCourse;
import social.app.backoffice.courses.domain.BackofficeCourseCriteriaMother;
import social.app.backoffice.courses.domain.BackofficeCourseMother;
import social.app.backoffice.courses.domain.BackofficeCourseRepository;
import social.app.shared.domain.criteria.Criteria;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Transactional
class MySqlBackofficeCourseRepositoryShould extends BackofficeContextInfrastructureTestCase {
    @Autowired
    @Qualifier("mySqlBackofficeCourseRepository")
    private BackofficeCourseRepository repository;

    @Test
    void save_a_course() {
        repository.save(BackofficeCourseMother.random());
    }

    @Test
    void search_all_existing_courses() {
        BackofficeCourse course = BackofficeCourseMother.random();
        BackofficeCourse anotherCourse = BackofficeCourseMother.random();

        repository.save(course);
        repository.save(anotherCourse);

        List<BackofficeCourse> allCourses = repository.searchAll();
        assertTrue(allCourses.contains(course));
        assertTrue(allCourses.contains(anotherCourse));
    }

    @Test
    void search_courses_using_a_criteria() {
        BackofficeCourse matchingCourse = BackofficeCourseMother.create("DDD en Java", "3 days");
        BackofficeCourse anotherMatchingCourse = BackofficeCourseMother.create("DDD en TypeScript", "2.5 days");
        BackofficeCourse intellijCourse = BackofficeCourseMother.create("Exprimiendo Intellij", "48 hours");
        BackofficeCourse cobolCourse = BackofficeCourseMother.create("DDD en Cobol", "5 years");

        Criteria criteria = BackofficeCourseCriteriaMother.nameAndDurationContains("DDD", "days");

        repository.save(matchingCourse);
        repository.save(anotherMatchingCourse);
        repository.save(intellijCourse);
        repository.save(cobolCourse);

        assertThat(
            Arrays.asList(matchingCourse, anotherMatchingCourse),
            containsInAnyOrder(repository.matching(criteria).toArray())
        );
    }
}
