package com.tech.interview.siply.redbus.handlers.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@ToString
@Setter
@Getter
public class RedBusExResponse {
    private final String message;
    private final HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timeStamp;
    //    private final ZonedDateTime timeStamp;
    private final Throwable throwable;
}
