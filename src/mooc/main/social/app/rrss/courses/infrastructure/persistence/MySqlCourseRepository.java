package social.app.rrss.courses.infrastructure.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import social.app.rrss.courses.domain.Course;
import social.app.rrss.courses.domain.CourseId;
import social.app.rrss.courses.domain.CourseRepository;
import social.app.shared.domain.Service;
import social.app.shared.domain.criteria.Criteria;
import social.app.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlCourseRepository extends HibernateRepository<Course> implements CourseRepository {
    public MySqlCourseRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Course.class);
    }

    @Override
    public void save(Course course) {
        persist(course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return byId(id);
    }

    @Override
    public List<Course> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
