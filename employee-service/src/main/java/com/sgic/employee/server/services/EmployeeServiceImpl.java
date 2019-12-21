package com.sgic.employee.server.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgic.employee.server.entities.Employee;
import com.sgic.employee.server.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
    @Transactional(readOnly = false)
	public Employee createEmployee(Employee employee) {
		Employee responseEmployee = employeeRepository.save(employee);
		return responseEmployee;
	}

    @Transactional(readOnly = true)
	public boolean isEmailAlreadyExist(String email) {
		return employeeRepository.existsByEmail(email);
	}
    @Transactional(readOnly = false)
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	

}
