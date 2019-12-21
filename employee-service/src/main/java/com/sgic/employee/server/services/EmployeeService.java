package com.sgic.employee.server.services;

import java.util.List;

import com.sgic.employee.server.entities.Employee;

public interface EmployeeService {
public Employee createEmployee(Employee employee);
public boolean isEmailAlreadyExist(String email);
public List<Employee> getAllEmployee();
}
