package br.com.crypto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class RequestExceptionsHandler {
    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<Object> handleRequestException(RequestException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        CustomException customException1 = new CustomException(
                exception.getMessage(),
                badRequest,
                OffsetDateTime.now()
        );
        return new ResponseEntity<>(exception, badRequest);
    }
}
