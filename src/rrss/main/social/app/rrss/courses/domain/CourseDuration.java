package social.app.rrss.courses.domain;

import social.app.shared.domain.StringValueObject;

public final class CourseDuration extends StringValueObject {
    public CourseDuration(String value) {
        super(value);
    }

    private CourseDuration() {
        super("");
    }
}
