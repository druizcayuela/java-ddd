package social.app.rrss.courses.application.find;

import social.app.rrss.courses.application.CourseResponse;
import social.app.rrss.courses.domain.CourseId;
import social.app.rrss.courses.domain.CourseNotExist;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.query.QueryHandler;

@Service
public final class FindCourseQueryHandler implements QueryHandler<FindCourseQuery, CourseResponse> {
    private final CourseFinder finder;

    public FindCourseQueryHandler(CourseFinder finder) {
        this.finder = finder;
    }

    @Override
    public CourseResponse handle(FindCourseQuery query) throws CourseNotExist {
        return finder.find(new CourseId(query.id()));
    }
}
