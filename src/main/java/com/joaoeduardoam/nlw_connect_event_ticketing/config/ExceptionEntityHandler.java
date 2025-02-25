package com.joaoeduardoam.nlw_connect_event_ticketing.config;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.EventNotFoundException;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.UserAlreadySubscribedException;
import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.UserNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<StandardError> handleEventNotFoundException(EventNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), "Event not found!",
                exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> handleEventNotFoundException(UserNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;


        StandardError error = new StandardError(Instant.now(), status.value(), "User not found!",
                exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserAlreadySubscribedException.class)
    public ResponseEntity<StandardError> handleUserAlreadySubscribedException(UserAlreadySubscribedException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.CONFLICT;
        StandardError error = new StandardError(Instant.now(), status.value(), "Subscription error!",
                exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handleValidationExceptions(
            MethodArgumentNotValidException exception, HttpServletRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        String message = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        StandardError error = new StandardError(
                Instant.now(),
                status.value(),
                "Validation error",
                message,
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(error);
    }

}
