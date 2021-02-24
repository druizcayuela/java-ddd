package social.app.apps.rrss.backend.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import social.app.rrss.users.application.create.CreateUserCommand;
import social.app.shared.domain.DomainError;
import social.app.shared.domain.bus.command.CommandBus;
import social.app.shared.domain.bus.command.CommandHandlerExecutionError;
import social.app.shared.domain.bus.query.QueryBus;
import social.app.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public final class UserPutController extends ApiController {
    public UserPutController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new CreateUserCommand(id, request.name(), request.email()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class Request {
    private String name;
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    String email() {
        return email;
    }
}
