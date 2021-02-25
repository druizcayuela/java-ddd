package social.app.rrss.courses.application.create;

import social.app.rrss.courses.domain.CourseDuration;
import social.app.rrss.courses.domain.CourseId;
import social.app.rrss.courses.domain.CourseName;
import social.app.shared.domain.Service;
import social.app.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateCourseCommandHandler implements CommandHandler<CreateCourseCommand> {
    private final CourseCreator creator;

    public CreateCourseCommandHandler(CourseCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateCourseCommand command) {
        CourseId id = new CourseId(command.id());
        CourseName name = new CourseName(command.name());
        CourseDuration duration = new CourseDuration(command.duration());

        creator.create(id, name, duration);
    }
}
