package com.oreilly.ignition.maventoys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.oreilly.ignition.maventoys.exception.EntityNotFoundException;
import com.oreilly.ignition.maventoys.model.CustomApiResponse;
import com.oreilly.ignition.maventoys.model.entity.Employee;
import com.oreilly.ignition.maventoys.repository.EmployeeRepository;

import jakarta.annotation.Nonnull;

/**
 * The EmployeeService class provides methods to interact with the
 * EmployeeRepository and perform CRUD operations on employees.
 */
@Service
public class EmployeeService {
    /**
     * The repository for managing employees.
     */
    private final EmployeeRepository employeeRepository;

    /**
     * Constructs a new EmployeeService with the given EmployeeRepository.
     *
     * @param employeeRepo the EmployeeRepository to be used
     */
    @Autowired
    public EmployeeService(final EmployeeRepository employeeRepo) {
        this.employeeRepository = employeeRepo;
    }

    /**
     * Retrieves all employees.
     *
     * @param p the pageable object for pagination
     * @return a list of all employees
     */
    public CustomApiResponse find(final Pageable p) {
        try {
            if (p.isPaged()) {
                return new CustomApiResponse("success", HttpStatus.OK.value(), "Employees fetched successfully",
                        employeeRepository.findAll(p));
            }
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Employees fetched successfully",
                    employeeRepository.findAll());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Retrieves an employee by their ID from the repository.
     *
     * @param id the ID of the employee to retrieve
     * @return an Optional containing the employee, or an empty Optional if no
     *         employee with the given ID exists
     */
    public CustomApiResponse findById(final Integer id) {
        try {
            Employee employee = employeeRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Employee with ID " + id + " not found"));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Employee retrieved successfully", employee);
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getStackTrace());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Saves an employee to the repository.
     *
     * @param employee the employee to save
     * @return the saved employee
     */
    public CustomApiResponse save(@Nonnull final Employee employee) {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Employee saved successfully",
                    employeeRepository.save(employee));
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Updates an employee with the given ID.
     *
     * @param employee The updated employee object.
     * @param id       The ID of the employee to update.
     * @return A CustomApiResponse object containing the result of the update
     *         operation.
     */
    public CustomApiResponse update(@Nonnull final Employee employee, @Nonnull final Integer id) {
        try {
            Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Employee with ID " + id + " not found"));
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Employee updated successfully",
                    employeeRepository.save(employeeToUpdate));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getStackTrace());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Deletes an employee by their ID from the repository.
     *
     * @param id the ID of the employee to delete
     * @return a CustomApiResponse object indicating the result of the delete
     *         operation
     */
    public CustomApiResponse deleteById(@Nonnull final Integer id) {
        try {
            Employee employee = employeeRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Employee with ID " + id + " not found"));
            employeeRepository.deleteById(employee.getId());
            return new CustomApiResponse("success", HttpStatus.OK.value(), "Employee deleted successfully",
                    employee.getId());
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getStackTrace());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Retrieves the sales associated with a specific employee.
     *
     * @param employeeId the ID of the employee
     * @return a list of sales associated with the employee
     */
    public CustomApiResponse findSales(final Integer employeeId) {
        // return employeeRepository.findSales(employeeId);
        try {
            Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                    () -> new EntityNotFoundException("Employee with ID " + employeeId + " not found"));
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Sales retrieved successfully", employeeRepository.findSales(employee.getId()));
        } catch (EntityNotFoundException e) {
            return new CustomApiResponse("error", HttpStatus.NOT_FOUND.value(), e.getMessage(), e.getStackTrace());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Retrieves a list of employees with the most sales.
     *
     * @return a list of Object arrays, where each array contains employee
     *         information and the total sales count
     */
    public CustomApiResponse findEmployeesWithMostSales() {
        try {
            return new CustomApiResponse("success", HttpStatus.OK.value(),
                    "Employees with most sales retrieved successfully",
                    employeeRepository.findEmployeesWithMostSales());
        } catch (Exception e) {
            return new CustomApiResponse("error", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(),
                    e.getStackTrace());
        }
    }

    /**
     * Returns the total number of employees.
     *
     * @return the total number of employees as an Integer
     */
    public CustomApiResponse getTotalEmployees() {
        return new CustomApiResponse("success", HttpStatus.OK.value(), "Total employees retrieved successfully",
                employeeRepository.getTotalEmployees());
    }
}
