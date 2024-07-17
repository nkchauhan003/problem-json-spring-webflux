package com.cb.problem;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class UserNotFoundProblem extends AbstractThrowableProblem {
    private static final URI TYPE
            = URI.create("https://example.org/not-found");

    public UserNotFoundProblem(Long userId) {
        super(
                TYPE,
                "Not found",
                Status.NOT_FOUND,
                String.format("User '%s' not found", userId));
    }
}
