package com.oreilly.ignition.maventoys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.oreilly.ignition.maventoys.model.entity.Employee;
import com.oreilly.ignition.maventoys.model.entity.Sale;

/**
 * This interface represents a repository for managing Employee entities.
 * It extends the JpaRepository interface, providing CRUD operations for
 * Employee entities.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * Retrieves a list of sales associated with the specified employee.
     *
     * @param employeeId the ID of the employee
     * @return a list of Sale objects
     */
    @Query("SELECT s FROM Sale s WHERE s.employee.id = :employeeId")
    List<Sale> findSales(@Param("employeeId") Integer employeeId);

    /**
     * Retrieves a list of employees with the most sales.
     *
     * @return a list of Object arrays containing employee ID, full name, and total
     *         sales count
     */
    @Query(value = "SELECT e.id, CONCAT(e.first_name, CONCAT(' ', e.last_name)) AS fullName, COUNT(s.id) AS totalSales "
            + "FROM employees e INNER JOIN sales s ON e.id = s.employee_id GROUP BY e.id, fullName " +
            "ORDER BY totalSales DESC LIMIT 5", nativeQuery = true)
    List<Object[]> findEmployeesWithMostSales();

    /**
     * Retrieves the total number of employees.
     *
     * @return the total number of employees
     */
    @Query(value = "SELECT COUNT(e.id) FROM employees e", nativeQuery = true)
    Integer getTotalEmployees();
}
