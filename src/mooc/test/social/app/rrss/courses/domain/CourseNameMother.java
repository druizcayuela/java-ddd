package social.app.rrss.courses.domain;

import social.app.shared.domain.WordMother;

public final class CourseNameMother {
    public static CourseName create(String value) {
        return new CourseName(value);
    }

    public static CourseName random() {
        return create(WordMother.random());
    }
}
