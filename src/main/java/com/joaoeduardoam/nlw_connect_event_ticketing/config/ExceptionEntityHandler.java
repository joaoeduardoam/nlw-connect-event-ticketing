package com.joaoeduardoam.nlw_connect_event_ticketing.config;

import com.joaoeduardoam.nlw_connect_event_ticketing.infrastructure.exceptions.EventNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<StandardError> handleEventNotFoundException(EventNotFoundException exception, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(Instant.now(), status.value(), "Event not found!",
                exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }

//    @ExceptionHandler(EventFullException.class)
//    public ResponseEntity<ErrorResponseDTO> handleEventNotFoundException(EventFullException exception){
//        return ResponseEntity.badRequest().body(new ErrorResponseDTO(exception.getMessage()));
//    }

//    @ExceptionHandler(AttendeeNotFoundException.class)
//    public ResponseEntity handleEventNotFoundException(AttendeeNotFoundException exception){
//        return ResponseEntity.notFound().build();
//    }

//    @ExceptionHandler(AttendeeAlreadyExistException.class)
//    public ResponseEntity handleEventNotFoundException(AttendeeAlreadyExistException exception){
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//    }

//    @ExceptionHandler(CheckInAlreadyExistsException.class)
//    public ResponseEntity handleEventNotFoundException(CheckInAlreadyExistsException exception) {
//        return ResponseEntity.status(HttpStatus.CONFLICT).build();
//
//    }
}
