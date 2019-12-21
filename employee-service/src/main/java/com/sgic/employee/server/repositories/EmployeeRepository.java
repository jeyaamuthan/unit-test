package com.sgic.employee.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.employee.server.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	boolean existsByEmail(String email);
}
