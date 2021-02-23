package social.app.rrss.courses.application.search_last;

import social.app.shared.domain.IntegerMother;

public final class SearchLastCoursesQueryMother {
    public static SearchLastCoursesQuery create(Integer total) {
        return new SearchLastCoursesQuery(total);
    }

    public static SearchLastCoursesQuery random() {
        return create(IntegerMother.random());
    }
}
