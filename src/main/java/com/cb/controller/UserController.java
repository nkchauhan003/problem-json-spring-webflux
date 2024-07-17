package com.cb.controller;

import com.cb.model.User;
import com.cb.problem.UserNotFoundProblem;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.AccessDeniedException;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    private static final Map<Long, User> USER_DB;

    static {
        USER_DB = Map.of(1L, User.builder().firstName("John").lastName("Snow").build(),
                2L, User.builder().firstName("Daenerys").lastName("Targaryen").build(),
                3L, User.builder().firstName("Cersei").lastName("Lannister").build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getUsers() {
        return Flux.fromIterable(USER_DB.values());
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<User> getUsers(@PathVariable("id") Long userId) {
        if (USER_DB.containsKey(userId)) {
            return Mono.just(USER_DB.get(userId));
        } else {
            throw new UserNotFoundProblem(userId);
        }
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws AccessDeniedException {
        throw new AccessDeniedException("You can't delete this user");
    }
}