package com.oreilly.ignition.maventoys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oreilly.ignition.maventoys.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    
}
