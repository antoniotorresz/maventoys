package com.oreilly.ignition.maventoys.exception;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * This class handles custom exceptions and provides appropriate responses.
 */
@ControllerAdvice
public class CustomExceptionHandler {

  /**
   * Handles the exception when an entity is not found.
   *
   * @param ex The EntityNotFoundException that occurred
   * @return ResponseEntity containing the custom API response and HTTP status code
   */
  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<CustomApiResponse> handleCustomEntityNotFoundException(
      final EntityNotFoundException ex) {
    CustomApiResponse customApiResponse =
        new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(),
            ex.getMessage(), null);
    return new ResponseEntity<>(customApiResponse, HttpStatus.NOT_FOUND);
  }

  /**
   * Handles the exception when an entity validation fails.
   *
   * @param ex The EntityValidationException that occurred
   * @return ResponseEntity containing the custom API response and HTTP status code
   */
  @ExceptionHandler(EntityValidationException.class)
  public ResponseEntity<CustomApiResponse> handleEntityValidationException(
      final EntityValidationException ex) {
    CustomApiResponse customApiResponse =
        new CustomApiResponse("error", HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(), null);
    return new ResponseEntity<>(customApiResponse, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles the exception when there is a conflict with an entity.
   *
   * @param ex The EntityConflictException that occurred
   * @return ResponseEntity containing the custom API response and HTTP status code
   */
  @ExceptionHandler(EntityConflictException.class)
  public ResponseEntity<CustomApiResponse> handleEntityConflictException(
      final EntityConflictException ex) {
    CustomApiResponse customApiResponse =
        new CustomApiResponse("error", HttpStatus.CONFLICT.value(),
            ex.getMessage(), null);
    return new ResponseEntity<>(customApiResponse, HttpStatus.CONFLICT);
  }

  /**
   * Handles general exceptions that are not specifically handled by other methods.
   *
   * @param ex The Exception that occurred
   * @return ResponseEntity containing the custom API response and HTTP status code
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<CustomApiResponse> handleGeneralException(
      final Exception ex) {
    CustomApiResponse customApiResponse =
        new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "An unexpected error occurred.", ex.toString());
    return new ResponseEntity<>(customApiResponse,
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
