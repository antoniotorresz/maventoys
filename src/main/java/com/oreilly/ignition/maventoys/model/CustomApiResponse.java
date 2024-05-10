package com.oreilly.ignition.maventoys.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Standard response format for API requests.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Standard response format for API requests.")
public class CustomApiResponse {
  /**
   * The status of the response, typically 'success' or 'error'.
   */
  @Schema(description = "The status of the response, typically 'success' or " +
      "'error'.")
  private String status;

  /**
   * The HTTP status code associated with the response.
   */
  @Schema(description = "The HTTP status code associated with the response.")
  private int code;

  /**
   * A message providing additional information about the response.
   */
  @Schema(description = "A message providing additional information about the" +
      " response.")
  private String message;

  /**
   * The data payload of the response, if any.
   */
//   @Schema(description = "The data payload of the response, if any.", oneOf = {
//       EmployeeDTO.class, EmployeeSummaryDTO.class})
  private Object data;
}
