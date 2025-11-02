package com.skillverse.exception;
import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResponseStatusException.class)
  public ResponseEntity<ApiError> handleRse(ResponseStatusException ex, HttpServletRequest req) {
    ApiError api = new ApiError(Instant.now(), ex.getStatusCode().value(),
        ex.getStatusCode().toString(), ex.getReason(), req.getRequestURI());
    return ResponseEntity.status(ex.getStatusCode()).body(api);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
    String msg = ex.getBindingResult().getFieldErrors().stream()
        .map(f -> f.getField()+": "+f.getDefaultMessage()).findFirst().orElse("Validation error");
    ApiError api = new ApiError(Instant.now(), 400, "BAD_REQUEST", msg, req.getRequestURI());
    return ResponseEntity.badRequest().body(api);
  }
}
