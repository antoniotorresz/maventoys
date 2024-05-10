package com.oreilly.ignition.maventoys.model.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents an employee in the company.
 */
@Entity
@Data
@Table(name = "employees")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Employee {
    /**
     * The ID of the employee.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * The first name of the employee.
     */
    private String firstName;
    /**
     * The last name of the employee.
     */
    private String lastName;
    /**
     * The hire date of the employee.
     */
    private Date hireDate;
    /**
     * The gender of the employee.
     */
    private String gender;
    /**
     * The birth date of the employee.
     */
    private Date birthDate;
    /**
     * The store where the employee works.
     */
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    /**
     * The status of the employee (active or inactive).
     */
    private Boolean active;

    /**
     * Default constructor for the Employee class.
     */
    public Employee() {
    }

    /**
     * Constructs an Employee object with the specified parameters.
     *
     * @param idParam        the employee ID
     * @param firstNameParam the first name of the employee
     * @param lastNameParam  the last name of the employee
     * @param hireDateParam  the hire date of the employee
     * @param genderParam    the gender of the employee
     * @param birthDateParam the birth date of the employee
     * @param storeParam     the store where the employee works
     * @param activeParam    the status of the employee (active or inactive)
     */
    public Employee(final Integer idParam, final String firstNameParam, final String lastNameParam,
            final Date hireDateParam, final String genderParam, final Date birthDateParam,
            final Store storeParam, final Boolean activeParam) {
        this.id = idParam;
        this.firstName = firstNameParam;
        this.lastName = lastNameParam;
        this.hireDate = hireDateParam;
        this.gender = genderParam;
        this.birthDate = birthDateParam;
        this.store = storeParam;
        this.active = activeParam;
    }
}
