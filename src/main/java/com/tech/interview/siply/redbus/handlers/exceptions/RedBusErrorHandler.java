package com.tech.interview.siply.redbus.handlers.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(basePackages = {"com.tech.interview.siply.redbus"})
public class RedBusErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {RedBusException.class})
    public ResponseEntity<Object> handleApiRequestException(RedBusException redBusException) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        RedBusExResponse redBusExResponse = RedBusExResponse.builder()
                .message(redBusException.getMessage())
                .httpStatus(badRequest)
                .timeStamp(LocalDateTime.now())
//                .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                .throwable(redBusException)
                .build();
        return new ResponseEntity<>(redBusExResponse, badRequest);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException redBusException, HttpHeaders httpHeaders, HttpStatus httpStatus,
                                                                  WebRequest request) {
//        String error = "Malformed JSON request";
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        RedBusExResponse redBusExResponse = RedBusExResponse.builder()
                .message(redBusException.getMessage())
                .httpStatus(badRequest)
                .timeStamp(LocalDateTime.now())
//                .timeStamp(ZonedDateTime.now(ZoneId.of("Z")))
                .throwable(redBusException)
                .build();
        return new ResponseEntity<>(redBusExResponse, badRequest);
    }
}