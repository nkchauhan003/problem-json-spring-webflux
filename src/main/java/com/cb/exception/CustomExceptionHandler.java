package com.cb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.webflux.advice.ProblemHandling;

@ControllerAdvice
class CustomExceptionHandler implements ProblemHandling {

}
