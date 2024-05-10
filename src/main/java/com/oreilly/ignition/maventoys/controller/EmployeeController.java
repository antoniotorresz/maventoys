package com.oreilly.ignition.maventoys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Employee;
import com.oreilly.ignition.maventoys.service.EmployeeService;
import org.springframework.http.MediaType;

@CrossOrigin
@RestController
@RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {
    /**
     * The service to handle the employee operations.
     */
    private final EmployeeService employeeService;

    /**
     * Creates a new instance of the controller.
     *
     * @param employeeServiceParam the service to handle the employee operations
     */
    @Autowired
    public EmployeeController(final EmployeeService employeeServiceParam) {
        this.employeeService = employeeServiceParam;
    }

    /**
     * Retrieves a list of employees.
     *
     * @param page  the page number to retrieve
     * @param limit the maximum number of employees to retrieve
     * @return the list of employees
     */
    @GetMapping
    public ResponseEntity<CustomApiResponse> find(
            @RequestParam(value = "page", required = false, defaultValue = "0") final Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") final Integer limit) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.find(PageRequest.of(page, limit)));
    }

    /**
     * Retrieves an employee by their ID.
     *
     * @param employeeId the ID of the employee to retrieve
     * @return the employee with the specified ID, or null if not found
     */
    @GetMapping(value = "/{employeeId}")
    public ResponseEntity<CustomApiResponse> findById(@PathVariable("employeeId") final Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(employeeId));
    }

    /**
     * Saves the given employee.
     *
     * @param employee the employee to be saved
     * @return the saved employee
     */
    @PostMapping
    public ResponseEntity<CustomApiResponse> save(@RequestBody final Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employee));
    }

    /**
     * * Updates an employee with the specified ID using the PATCH method.
     * @param employeeId the ID of the employee to be updated
     * @param employee   the updated employee object
     * @return a ResponseEntity containing the updated employee object if found, or
     *         the original employee object with HttpStatus.NOT_FOUND if not found
     */
    @PutMapping("/{employeeId}")
    public ResponseEntity<CustomApiResponse> update(@PathVariable("employeeId") final Integer employeeId,
            @RequestBody final Employee employee) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(employee, employeeId));
    }

    /**
     * Deletes an employee by their ID.
     *
     * @param employeeId the ID of the employee to be deleted
     * @return a ResponseEntity indicating the result of the deletion
     */
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<CustomApiResponse> deleteById(@PathVariable("employeeId") final Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.deleteById(employeeId));
    }

    /**
     * Retrieves the sales information for the employee with the specified ID.
     *
     * @param employeeId the ID of the employee
     * @return a ResponseEntity containing the sales information if the employee is
     *         found,
     *         or a ResponseEntity with a null body and HttpStatus.NOT_FOUND if the
     *         employee is not found
     */
    @GetMapping(value = "/{employeeId}/sales")
    public ResponseEntity<CustomApiResponse> findSales(@PathVariable("employeeId") final Integer employeeId) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findSales(employeeId));
    }
}
