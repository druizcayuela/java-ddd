package social.app.rrss.courses.domain;

import social.app.shared.domain.StringValueObject;

public final class CourseName extends StringValueObject {
    public CourseName(String value) {
        super(value);
    }

    public CourseName() {
        super("");
    }
}
