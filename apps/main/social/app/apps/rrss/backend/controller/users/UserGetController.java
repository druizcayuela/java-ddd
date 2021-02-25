package social.app.apps.rrss.backend.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import social.app.rrss.users.application.UserResponse;
import social.app.rrss.users.application.find.FindUserQuery;
import social.app.rrss.users.domain.UserNotExist;
import social.app.shared.domain.DomainError;
import social.app.shared.domain.bus.command.CommandBus;
import social.app.shared.domain.bus.query.QueryBus;
import social.app.shared.domain.bus.query.QueryHandlerExecutionError;
import social.app.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public final class UserGetController extends ApiController {

    public UserGetController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(@PathVariable String id) throws QueryHandlerExecutionError {
        UserResponse user = ask(new FindUserQuery(id));

        return ResponseEntity.ok().body(new HashMap<>() {{
            put("id", user.id());
            put("name", user.name());
            put("email", user.email());
        }});
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<>() {{
            put(UserNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
