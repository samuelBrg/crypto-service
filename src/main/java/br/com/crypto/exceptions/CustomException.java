package br.com.crypto.exceptions;

import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class CustomException {
    private final String message;
    private final HttpStatus httpStatus;
    private final OffsetDateTime offsetDateTime;

    public CustomException(String message, HttpStatus httpStatus, OffsetDateTime offsetDateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.offsetDateTime = offsetDateTime;
    }
}
