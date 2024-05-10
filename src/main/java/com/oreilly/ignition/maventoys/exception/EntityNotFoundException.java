package com.oreilly.ignition.maventoys.exception;

/**
 * Exception thrown when an attempt to access a specific entity fails because
 * it does not exist in the database. This exception is typically used in
 * services to handle cases where a requested resource by its
 * identifier cannot be found.
 *
 * <p>It extends {@link RuntimeException} to avoid the need for methods
 * to catch or declare it if they choose to let higher layers handle it.</p>
 */
public class EntityNotFoundException extends RuntimeException {
  /**
   * Constructs a new {@code EntityNotFoundException} with the specified detail
   * message. The detail message is saved for later retrieval by the
   * {@link Throwable#getMessage()} method.
   *
   * @param message the detail message. The detail message is used to provide
   *                more information about the reason for the exception and to
   *                facilitate debugging and logging.
   */
  public EntityNotFoundException(final String message) {
    super(message);
  }
}
